package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import play.Logger;
import play.db.ebean.Model;
import play.libs.Crypto;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Abhinavkoppula on 5/8/15.
 */
@Entity
@Table(name = "login")
public class Login extends Model {

    @Id
    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "auth_token")
    public String authToken;

    @JsonBackReference
    @OneToOne(targetEntity = UserDetail.class)
    @JoinColumn(name = "user_id")
    public UserDetail userDetail;

    private static Finder<Integer, Login> find = new Finder<Integer, Login>(Integer.class, Login.class);

    public static boolean check(Login login) {
        Login loginRow = Login.find.where()
                .eq("username", login.username)
                .eq("password", login.password)
                .findUnique();
        return loginRow != null;
    }

    public static Login findByUsername(String username) {
        return Login.find
                .fetch("userDetail")
                .where()
                .eq("username", username)
                .findUnique();
    }

    public static Login attemptToLogin(String userId, String password){
        Logger.info("User Attempt to login " + userId);

        Login user = Login.findByUsername(userId);
        if(user == null) {
            return null;
        }

        String encryptedPassword = Crypto.encryptAES(password);

        if(!encryptedPassword.equalsIgnoreCase(user.password)){
            Logger.info("Failed Login Attempt " + userId);
            return null;
        } else{
            user.authToken = createToken();
            Logger.info("User Attempt to login OK "+userId);
            user.save();
            return user;
        }
    }

    public static String createToken() {
        return UUID.randomUUID().toString();
    }
}
