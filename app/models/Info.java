//package models;
//import org.apache.commons.lang3.text.WordUtils;
//import play.data.validation.Constraints;
//import play.db.ebean.Model;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//import java.text.SimpleDateFormat;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
//@Entity
//public class Info extends Model implements Comparable<Info>{
//
//	
//    @Id
//    public long id;
//
//    private String name;
//
//    private String info;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getInfo() {
//            return info;
//        }
//
//    public void setInfo(String info) {
//            this.info = info;
//        }
//
//    public long getId(){
//    return id;
//    }
//
//}