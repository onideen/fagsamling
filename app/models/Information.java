package models;



public class Information extends Model implements Comparable<Information>{
	@Id
	public long id;
	
	private String information;
	private String title;
	
	
	
}