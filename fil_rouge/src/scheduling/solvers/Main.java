package scheduling.solvers;

import java.util.*;

import scheduling.activities.Activity;
import scheduling.constraints.MeetConstraint;
import scheduling.constraints.Constraint;
import scheduling.constraints.PrecedenceConstraint; 
import scheduling.constraints.UnaryConstraint;
import scheduling.constraints.MaxSpanConstraint;
import scheduling.constraints.PrecedenceConstraintWithGap;
public class Main {

    public static void main(String[] args) {

        Activity lever = new Activity("Se lever", 1);
        Activity petitDej = new Activity("Petit déjeuner", 10);
        Activity douche = new Activity("Douche", 5);
        Activity travail = new Activity("Aller au travail", 30);

        Set<Activity> allActivities = new HashSet<>(Arrays.asList(lever, petitDej, douche, travail));
		 System.out.println("\n I)\t\tListe des activités déclarées :\n");
        for (Activity a : allActivities) {
            System.out.println( a.getDescription() + " de durée = " + a.getDuration() + "  minutes ");
        }
			
		System.out.println("\n II) \t\tDéfinition des contraintes :\n");
        Set<Constraint> constraints = new HashSet<>();
        Constraint cons1 = new PrecedenceConstraint(lever, petitDej);
        Constraint cons2 = new PrecedenceConstraintWithGap(petitDej, douche, 0, 5);
        Constraint cons3 = new MeetConstraint(douche, travail);
        Constraint cons4 = new UnaryConstraint(lever, 6, 8);
        Constraint cons5 = new MaxSpanConstraint(new HashSet<>(Arrays.asList(lever, douche,petitDej,travail)), 60);

        constraints.add(cons1);
        constraints.add(cons2);
        constraints.add(cons3);
        constraints.add(cons4);
        constraints.add(cons5);		
		 int n = 1;
		for (Constraint c : constraints) {
				System.out.println("   C" + (n++) + " : " + c);
			}
		
		Verifier notreVerification = new Verifier(constraints);
        Map<Activity, Integer> scheduleVrai = new HashMap<>();
        scheduleVrai.put(lever,     7);
        scheduleVrai.put(petitDej,  8);
        scheduleVrai.put(douche,   18);
        scheduleVrai.put(travail,  23);

        System.out.println("_______________________________Emploi du temps valide_________________________");
          Set<Constraint> unsatisfied1 = notreVerification.unsatisfied(scheduleVrai);

        System.out.println(" Emploi du temps testé :\n");
		for (Activity a : allActivities) {
			System.out.println("   - " + a.getDescription() + "  début = " + scheduleVrai.get(a));
		}
		System.out.println("\n Vérification des contraintes :\n");
		int copt =0;
        for (Constraint c : constraints) {
			if (c.isSatisfied(scheduleVrai) == true)
			{
				copt = copt +1;
			  System.out.println("   " + c + " => " + "ok la contrainte est vérifié \n" );
			}else{
				copt = copt;
					System.out.println("   " + c + " => " + " la contrainte n'est pas  vérifié \n" );
				}
        }
		 if(copt == 5)
        {
			System.out.println(copt +" constraintes sont vérifiées et l'emploi du temps est opérationnel");
		}else{
				System.out.println("Au moins " + (5 - copt)+ " contraintes ne sont pas vérifiées et l'emploi du temps n'est pas opérationnel");
			}

        Map<Activity, Integer> scheduleFaux = new HashMap<>();
        scheduleFaux.put(lever,     5);  
        scheduleFaux.put(petitDej,  7);
        scheduleFaux.put(douche,   50);  
        scheduleFaux.put(travail,  90);  

        System.out.println("___________________________Emploi du temps invalide_________________");
          Set<Constraint> unsatisfied2 = notreVerification.unsatisfied(scheduleFaux);

       		for (Activity a : allActivities) 
       	{
			System.out.println("   - " + a.getDescription() + "  début = " + scheduleFaux.get(a));
		}
		System.out.println("\n Vérification des contraintes :\n");
		int cpt =0;
        for (Constraint c : constraints) {
			if (c.isSatisfied(scheduleFaux) == true)
			{
			  System.out.println("   " + c + " => " + "Ok la contrainte est vérifié \n" );
			  cpt = cpt +1;;
			}else
			   {
					System.out.println("   " + c + " => " + "la contrainte n'est pas  vérifié \n" );
					cpt = cpt;
				}
        }
        if(cpt == 5)
        {
			System.out.println(cpt +" constraintes sont vérifiées et l'emploi du temps est opérationnel");
		}else{
				System.out.println("Au moins " + (5 - cpt)+ " contraintes ne sont pas vérifiées et l'emploi du temps n'est pas opérationnel");
			}
        
        
    }

}
