package models;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by Abhinavkoppula on 5/8/15.
 */

@Entity
@Table(name = "project")
public class Project extends Model {

    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "start_date")
    public Timestamp startDate;

    @Column(name = "end_date")
    public Timestamp endDate;

    @Column(name = "service_line_id")
    public int serviceLine;

    @Column(name = "domain")
    public String domain;
}
