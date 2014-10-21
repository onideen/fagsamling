package models;


import org.apache.commons.lang3.text.WordUtils;
import play.db.ebean.Model;

import javax.persistence.*;
import play.data.format.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Information extends Model{
	
	@Id
	public long id;
	
	private String info;
	private String title;
	private String hotelInfo;
	
	
	
	public String getHotelInfo(){
		return hotelInfo;
	}
	
	public void setHotelInfo(String hotelInfo){
		this.hotelInfo=hotelInfo;
	}
	
	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public Long getId(){
    	return id;
    }
    private static Finder<Long, Information> find = new Finder<Long, Information>(Long.class, Information.class);

    public static List<Information> findAll() {
        return find.all();
    }
    
	
	
}