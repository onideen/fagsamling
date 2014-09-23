package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import java.util.List;

/**
 * Created by vegaen on 9/22/14.
 */
@Entity
public class Day extends Model {

    @Id
    private long id;

    public String title;
    public int position;

    @OneToMany
    private List<Activity> activities;

    private Finder<Long, Day> find = new Finder<>(Long.class, Day.class);

    public List<Day> findAll(){
        return find.all();
    }

    public long getId(){
        return id;
    }
}
