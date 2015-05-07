package models;

import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by Abhinavkoppula on 5/8/15.
 */

@Entity
@Table(name = "user_detail")
public class UserDetail extends Model {

    @Id
    @Column(name = "id")
    public int id;

    @OneToOne(mappedBy = "userDetail")
    public Login login;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id")
    public Role role;

    @Column(name = "name")
    public String name;
}
