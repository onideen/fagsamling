package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by vegaen on 9/22/14.
 */

@Entity
public class Track extends Model {

    @Id
    private long id;

    private String title;
    private String instructors;
    private String host;
    private String format;
    private String level;
    private String place;
    private String description;
    private String audience;
    private List<Requirement> requirements;

    private static Finder<Long, Track> find = new Finder<Long, Track>(Long.class, Track.class);

    public static List<Track> findAll() {
        return find.all();
    }

    public static Track findById(long id) {
        return find.byId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }
}
