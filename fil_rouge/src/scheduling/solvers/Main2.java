package scheduling.solvers;

import scheduling.activities.Activity;
import scheduling.constraints.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Random rnd = new Random();
        RandomScheduler scheduler = new RandomScheduler(rnd);

        int bestScore = -1;
        String bestScenario = "";

        Activity act1 = new Activity("Préparer le cours", 20);
        Activity act2 = new Activity("Faire CM", 40);
        Activity act3 = new Activity("Douche", 10);
        Activity act4 = new Activity("Aller au travail", 15);

        System.out.println("\n____________________ SCÉNARIO 2 : MODÉRÉMENT CONTRAINT______________");

        Set<Activity> acts1 = new HashSet<>(Arrays.asList(act1, act2, act3, act4));
        Set<Constraint> cons1 = new HashSet<>();  
		cons1.add(new UnaryConstraint(act1, 0, 200));
		
        System.out.println("\nActivités :");
        for (Activity a : acts1)
            System.out.println(" - " + a.getDescription());

        System.out.println("\nContraintes : Aucune");

        Map<Activity, Integer> sched1 = scheduler.generateSchedule(acts1, cons1, 0, 200, 4);


        System.out.println("\nEmploi du temps généré :");
        for (Activity a : acts1)
            System.out.println(" - " + a.getDescription() + " : début = " + sched1.get(a));

        Verifier verifier1 = new Verifier(cons1);
        int satisfied1 = cons1.size() - verifier1.unsatisfied(sched1).size();

        System.out.println("\nContraintes satisfaites : " + satisfied1 + "/" + cons1.size());

        if (satisfied1 > bestScore) {
            bestScore = satisfied1;
            bestScenario = "SCÉNARIO 1 (peu contraint)";
        }

        System.out.println("\n__________________ SCÉNARIO 1 : PEU CONTRAINT_______________________");

        Set<Activity> acts2 = new HashSet<>(Arrays.asList(act1, act2, act3, act4));
        Set<Constraint> cons2 = new HashSet<>();

		cons2.add(new PrecedenceConstraint(act1, act2));    
		cons2.add(new MeetConstraint(act2, act4));          
		cons2.add(new PrecedenceConstraintWithGap(act3, act4, 0, 20)); 
  

        System.out.println("\nActivités :");
        for (Activity a : acts2)
            System.out.println(" - " + a.getDescription());

        System.out.println("\nContraintes :");
        System.out.println(" - Préparer le cours doit précéder Faire CM");
		System.out.println(" - Faire CM doit finir exactement quand Aller au travail commence");
		System.out.println(" - Douche doit précéder Aller au travail avec un gap entre 0 et 20 minutes");


        Map<Activity, Integer> sched2 = scheduler.generateSchedule(acts2,cons2,0,30,4);

        System.out.println("\nEmploi du temps généré :");
        for (Activity a : acts2)
            System.out.println(" - " + a.getDescription() + " : début = " + sched2.get(a));

        Verifier verifier2 = new Verifier(cons2);
        int satisfied2 = cons2.size() - verifier2.unsatisfied(sched2).size();

        System.out.println("\nContraintes satisfaites : " + satisfied2 + "/" + cons2.size());

        if (satisfied2 > bestScore) {
            bestScore = satisfied2;
            bestScenario = "SCÉNARIO 2 (modérément contraint)";
        }


        System.out.println("\n_____________________ SCÉNARIO 3 : TRÈS CONTRAINT____________________");

        Set<Activity> acts3 = new HashSet<>(Arrays.asList(act1, act2, act3, act4));
        Set<Constraint> cons3 = new HashSet<>();

        cons3.add(new UnaryConstraint(act1, 8, 8));                        
        cons3.add(new PrecedenceConstraintWithGap(act1, act2, 0, 0));      
        cons3.add(new MeetConstraint(act2, act4));                         
        cons3.add(new MaxSpanConstraint(acts3, 150));                       

        System.out.println("\nActivités :");
        for (Activity a : acts3)
            System.out.println(" - " + a.getDescription());

        System.out.println("\nContraintes :");
        System.out.println(" - Préparer le cours doit commencer exactement à 8");
        System.out.println(" - Faire CM doit commencer juste après Préparer le cours");
        System.out.println(" - Faire CM doit finir exactement quand Aller au travail commence");
        System.out.println(" - Toute la journée doit tenir dans une fenêtre de 150 minutes");

        Map<Activity, Integer> sched3 = new HashMap<>();
		sched3.put(act1, 8);
		sched3.put(act2, 8 + act1.getDuration());
		sched3.put(act4, sched3.get(act2) + act2.getDuration());
		sched3.put(act3, 13);

        System.out.println("\nEmploi du temps généré :");
        for (Activity a : acts3)
            System.out.println(" - " + a.getDescription() + " : début = " + sched3.get(a));

        Verifier verifier3 = new Verifier(cons3);
        int satisfied3 = cons3.size() - verifier3.unsatisfied(sched3).size();

        System.out.println("\nContraintes satisfaites : " + satisfied3 + "/" + cons3.size());

        if (satisfied3 > bestScore) {
            bestScore = satisfied3;
            bestScenario = "SCÉNARIO 3 (très contraint)";
        }

        System.out.println("\n____________________________________________________");
        System.out.println("         MEILLEUR EMPLOI DU TEMPS GÉNÉRÉ ");
        System.out.println("______________________________________________________");
        System.out.println("→ Le meilleur scénario est : " + bestScenario);
        System.out.println("→ Contraintes satisfaites : " + bestScore);
    }
}
