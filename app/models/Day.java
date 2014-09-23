package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Collections;
import java.util.List;

/**
 * Created by vegaen on 9/22/14.
 */
@Entity
public class Day extends Model {

    @Id
    private long id;

    private String title;
    public int position;

    @OneToMany
    private List<Activity> activities;

    private static Finder<Long, Day> find = new Finder<Long, Day>(Long.class, Day.class);

    public static List<Day> findAll(){
        return find.all();
    }

    public static Day findById(long id) {
        return find.byId(id);
    }

    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public List<Activity> getActivities() {
        Collections.sort(activities);
        return activities;
    }
}
