package models;


import play.db.ebean.Model;

import javax.persistence.Id;

public class Information extends Model implements Comparable<Information>{
	@Id
	public long id;
	
	private String information;
	private String title;


    @Override
    public int compareTo(Information o) {
        return 0;
    }
}