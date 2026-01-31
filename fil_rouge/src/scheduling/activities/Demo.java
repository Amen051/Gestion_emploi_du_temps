package scheduling.activities;

public class Demo{
    public static void main(String[] args){
		Activity act1 = new Activity("Aller a l'eglise", 15);
		Activity act2 = new Activity("Aller a l'essai ", 1);
		
		
		System.out.println("________________________________________Mes Activites______________________________________________________");
		System.out.println("Activite premiere : « " + act1.getDescription() + "»  de duree  " + act1.getDuration() + " minutes");
		System.out.println("Activite seconde : « " + act2.getDescription() + "» de duree " + act2.getDuration()+ " minutes");
	}
    
}
