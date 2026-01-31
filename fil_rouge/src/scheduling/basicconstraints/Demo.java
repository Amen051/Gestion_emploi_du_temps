package scheduling.basicconstraints;

import scheduling.activities.Activity;

public class Demo{
    public static void main(String[] args){
		Activity act1 = new Activity("Aller a l'eglise", 15);
		Activity act2 = new Activity("Aller a l'essai ", 1);
		PrecedenceConstraint pc1 = new PrecedenceConstraint(act1, act2);
		
		System.out.println("________________________________________Mes contraintes de précédence______________________________________________________");
		System.out.println("Activite premiere : « " + act1.getDescription() + "»  de duree  " + act1.getDuration() + " minutes");
		System.out.println("Activite seconde : « " + act2.getDescription() + "» de duree " + act2.getDuration()+ " minutes");
		System.out.println("Contrainte de precedence : " + pc1.isSatisfied(500,516));
		System.out.println("Contrainte de meet : " + pc1.isSatisfied(500,516));
		
		
		System.out.println("__________________________PrecedenceConstraintWithGap_______________________________");
		PrecedenceConstraintWithGap constraint = new PrecedenceConstraintWithGap(act1, act2, 5, 15);

        System.out.println("Contrainte de precedenceWithGap : " + constraint.isSatisfied(500, 515));  
        System.out.println("Contrainte de precedenceWithGap : " + constraint.isSatisfied(500, 520));  
        System.out.println("Contrainte de precedenceWithGap : " + constraint.isSatisfied(500, 530)); 
        System.out.println("Contrainte de precedenceWithGap : " + constraint.isSatisfied(500, 510));  
	}
    
}
