package scheduling.activities;

public class Activity{
	private String description;
	private int duree;
	
	public Activity(String description, int duree){
		this.description =  description;
		this.duree = duree;
	}
	
	public String getDescription(){
		return this.description;
	}
    public int getDuration(){
		return this.duree;
	}
    
}
