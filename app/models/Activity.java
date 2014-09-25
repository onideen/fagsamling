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
    public long id;

    @ManyToOne
    public Day day;
    private String startTime;
    private String endTime;
    private String title;
    private boolean active;

    private String room;

    private static Finder<Long, Activity> find = new Finder<Long, Activity>(Long.class, Activity.class);

    public static List<Activity> findAll(){
        return find.all();
    }

    public static Activity findById(long id){
        return find.byId(id);
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

    public long getId() {
        return id;
    }

    public boolean isNew(){
        return id == 0;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
