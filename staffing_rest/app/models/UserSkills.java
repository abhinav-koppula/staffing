package models;

import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by Abhinavkoppula on 5/8/15.
 */
@Entity
@Table(name = "user_skills")
public class UserSkills extends Model {
    @Id
    @Column(name = "id")
    public int id;

    @ManyToOne(targetEntity = UserDetail.class)
    @JoinColumn(name = "user_id")
    public UserDetail userDetail;

    @ManyToOne(targetEntity = Skill.class)
    @JoinColumn(name = "skill_id")
    public Skill skill;

    @Column(name = "level")
    public int level;
}
