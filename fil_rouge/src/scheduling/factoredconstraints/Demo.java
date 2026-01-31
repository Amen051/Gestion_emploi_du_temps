package scheduling.factoredconstraints;
import scheduling.activities.Activity;

public class Demo{
    public static void main(String[] args){
		Activity act1 = new Activity("Aller a l'universite", 15);
		Activity act2 = new Activity("Attacher le velo", 1);
		PrecedenceConstraint pc = new PrecedenceConstraint(act1, act2);
		
		System.out.println("________________________________________Mes contraintes de précédence______________________________________________________");
		System.out.println("Contrainte de Précédence : " + pc);
		System.out.println("Activite1: « " + act1.getDescription() + "»  de duree  " + act1.getDuration() + " minutes");
		System.out.println("Activite2 : « " + act2.getDescription() + "» de duree " + act2.getDuration()+ " minutes");
		System.out.println("Debut activite1: 500 & debut activite2: 515 -> " + pc.isSatisfied(500,515));
		System.out.println("Debut activite1: 500 & debut activite2: 13 -> " + pc.isSatisfied(500, 13));
		System.out.println("Debut activite1: 500 & debut activite2: 518 -> " + pc.isSatisfied(500, 518));
		
		
		 
		Activity s1 = new Activity("S'échauffer", 10);
        Activity s2 = new Activity("Faire du sport", 60);
        MeetConstraint mc = new MeetConstraint(s1, s2);
        
        System.out.println("________________________________________Mes contraintes de type meet______________________________________________________");
        System.out.println("Contrainte meet : " + mc);
        System.out.println("Activite3: « " + s1.getDescription() + "»  de duree  " + s1.getDuration() + " minutes");
		System.out.println("Activite4 : « " + s2.getDescription() + "» de duree " + s2.getDuration()+ " minutes");
        System.out.println("Debut activite3: 520 & debut activite4: 530 -> " + mc.isSatisfied(520, 530)); 
        System.out.println("debut activite3: 520 & debut activite4: 531 -> " + mc.isSatisfied(520, 531)); 
		
		System.out.println("__________________________PrecedenceConstraintWithGap_______________________________");
		Activity act3 = new Activity("Cours magistral", 60);
		Activity act4 = new Activity("Travaux Pratiques", 150);
		PrecedenceConstraintWithGap constraint = new PrecedenceConstraintWithGap(act3, act4, 15, 10080);
		
		
		System.out.println("Contrainte de PrecedenceConstraintWithGap : " + constraint);
		System.out.println("Activite1: « " + act3.getDescription() + "»  de duree  " + act3.getDuration() + " minutes");
		System.out.println("Activite2 : « " + act4.getDescription() + "» de duree " + act4.getDuration()+ " minutes");
		System.out.println("Il doit y avoir un délai minimum de 15 minutes et maximum de 7 jours  ");
	
        System.out.println("Debut activite1: 500 & debut activite2: 575 -> " + constraint.isSatisfied(500, 575));  
        System.out.println("Debut activite1: 500 & debut activite2: 590 -> " + constraint.isSatisfied(500, 590));  
        System.out.println("Debut activite1: 500 & debut activite2: 70000 -> " + constraint.isSatisfied(500, 70000)); 
        System.out.println("Debut activite1: 500 & debut activite2: 75000 -> " + constraint.isSatisfied(500, 75000));  
	}
    
}
