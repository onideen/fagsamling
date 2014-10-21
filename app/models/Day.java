package models;

import org.apache.commons.lang3.text.WordUtils;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by vegaen on 9/22/14.
 */
@Entity
public class Day extends Model implements Comparable<Day>{

    @Id
    private long id;

    @Constraints.Required
    private Date date;


    @OneToMany
    private List<Activity> activities;

    private static Finder<Long, Day> find = new Finder<Long, Day>(Long.class, Day.class);

    public static List<Day> findAll(){
        List<Day> days = find.all();
        Collections.sort(days);
        return days;
    }

    public static Day findById(long id) {
        return find.byId(id);
    }

    public long getId(){
        return id;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public String getTitle(){
        return WordUtils.capitalize(new SimpleDateFormat("EEEE", new Locale("no", "NO")).format(getDate()));
    }

    public void setId(long id){
        this.id = id;
    }

    public List<Activity> getActivities() {
        Collections.sort(activities);
        return activities;
    }

    @Override
    public int compareTo(Day o) {
        return date.compareTo(o.getDate());
    }
}
