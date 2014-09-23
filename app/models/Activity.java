package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vegaen on 9/22/14.
 */

@Entity
public class Activity extends Model {

    @Id
    private long id;

    @ManyToOne
    public Day day;
    public String startTime;
    public String endTime;
    public String title;
    public boolean active;

    private Finder<Long, Activity> find = new Finder<>(Long.class, Activity.class);

    public List<Activity> findAll(){
        return find.all();
    }

}
