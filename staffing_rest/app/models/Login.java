package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import play.db.ebean.Model;

import javax.persistence.*;

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
}
