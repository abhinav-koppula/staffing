package models;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Abhinavkoppula on 5/8/15.
 */
@Entity
@Table(name = "skill")
public class Skill extends Model {
    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;
}
