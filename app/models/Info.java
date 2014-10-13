package models;

@Entity
public class Info extends Model implements Comparable<Info>{


    @Id
    public long id;

    private String name;

    private String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
            return info;
        }

    public void setInfo(String info) {
            this.info = info;
        }

    public long getId(){
    return id;
    }

}