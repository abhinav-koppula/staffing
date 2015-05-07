package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Abhinavkoppula on 5/8/15.
 */
@Entity
@Table(name = "project_members")
public class ProjectMembers extends Model {

    @Id
    @Column(name = "id")
    public int id;

    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project_id")
    public Project project;

    @ManyToOne(targetEntity = UserDetail.class)
    @JoinColumn(name = "member_id")
    public UserDetail member;

    @Column(name = "start_date")
    public Timestamp startDate;

    @Column(name = "end_date")
    public Timestamp endDate;

    @Column(name = "part_time")
    public boolean partTime;

    @Column(name = "part_time_allocation")
    public int partTimeAllocation;
}
