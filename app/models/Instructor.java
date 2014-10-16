package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by engenveg on 02.10.2014.
 */

@Entity
public class Instructor extends Model {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    private Track track;

    private static Finder<Long, Instructor> find = new Model.Finder<Long, Instructor>(Long.class, Instructor.class);

    public static Instructor findById(long id) {
        return find.byId(id);
    }


    public Instructor(String name){
        this.name = name.trim();
    }


    public String getName() {
        return name;
    }

    public static Instructor findByName(String instructorName) {
        return find.where().eq("name", instructorName.trim()).findUnique();
    }

    public static List<Instructor> findAll(){
        return find.findList();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Instructor && ((Instructor) o).name.equals(name);
    }

    @Override
    public String toString(){
        return name;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
