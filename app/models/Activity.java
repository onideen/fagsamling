package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vegaen on 9/22/14.
 */

@Entity
public class Activity extends Model implements Comparable<Activity>{

    @Id
    private long id;

    @ManyToOne
    private Day day;
    private String startTime;
    private String endTime;
    private String title;
    private boolean active;

    private static Finder<Long, Activity> find = new Finder<Long, Activity>(Long.class, Activity.class);

    public static List<Activity> findAll(){
        return find.all();
    }

    public static Activity findById(long id){
        return find.byId(id);
    }

    public Activity(Day day) {
        this.day = day;
    }


    @Override
    public int compareTo(Activity other) {
        return startTime.compareTo(other.startTime);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
