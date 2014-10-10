package models;

        import play.db.ebean.Model;

        import javax.persistence.*;
        import java.util.List;

/**
 * Created by vegaen on 23.09.2014.
 */

@Entity
public class Requirement extends Model {

    @Id
    private long id;

    private String description;

    private static Finder<Long, Requirement> find = new Finder<Long, Requirement>(Long.class, Requirement.class);

    public static List<Requirement> findAll() {
        return find.all();
    }

    public static Requirement findById(long id) {
        return find.byId(id);
    }

    public Requirement(String description){
        setDescription(description);
    }
    public long getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
