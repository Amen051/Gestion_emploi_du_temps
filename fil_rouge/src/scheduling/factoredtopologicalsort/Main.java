package scheduling.factoredtopologicalsort;

import scheduling.activities.Activity;
import scheduling.factoredconstraints.PrecedenceConstraint;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       System.out.println("___________________________________Exemple 1___________________________________");
        Activity lever = new Activity("se lever", 1);
        Activity travail = new Activity("aller au travail", 15);
        Activity douche = new Activity("prendre une douche", 10);
        Activity dents = new Activity("se brosser les dents", 3);
        Activity habiller = new Activity("s'habiller", 2);
        Activity petitDej = new Activity("prendre un petit déjeuner", 15);

        HashSet<Activity> acts1 = new HashSet<>(Arrays.asList(lever, travail, douche, dents, habiller, petitDej));
        HashSet<PrecedenceConstraint> cons1 = new HashSet<>();
        cons1.add(new PrecedenceConstraint(lever, petitDej));
        cons1.add(new PrecedenceConstraint(lever, habiller));
        cons1.add(new PrecedenceConstraint(petitDej, dents));
        cons1.add(new PrecedenceConstraint(douche, habiller));
        cons1.add(new PrecedenceConstraint(dents, travail));
        cons1.add(new PrecedenceConstraint(habiller, travail));
        cons1.add(new PrecedenceConstraint(lever, douche));
        cons1.add(new PrecedenceConstraint(petitDej, travail));

        TopologicalSorter sorter = new TopologicalSorter();
        ArrayList<Activity> order1 = sorter.bruteForceSort(new HashSet<>(acts1), cons1);
        
 
				 for (Activity a : order1) 
				 {
					 System.out.println(" - " + a.getDescription());
				 }
			
            System.out.println("Emploi du temps (début = 500) :");
            HashMap<Activity, Integer> sched = sorter.schedule(new HashSet<>(acts1), cons1, 500);
            for (Activity a : order1) {
                System.out.println("   " + a.getDescription() + " -> début = " + sched.get(a));
            }
             if (order1 == null)
         {
			 System.out.println("Impossible car l'ordonnancement est null");
		 }
         else if (sorter.schedule(acts1, cons1, 0) == null) {
				System.out.println("Aucun emploi du temps possible pour l'exemple 1 !!!! Erreur.");
		} else{
						System.out.println("L'emploi du temps marche");
					}
            
            
            
            
            
        System.out.println("___________________________________Exemple 2__________________________________");
        Activity prendreSujet = new Activity("prendre connaissance du sujet d'examen", 30);
        Activity reviser = new Activity("réviser", 300);
        Activity entrer = new Activity("entrer dans la salle d'examen", 8);

        HashSet<Activity> acts2 = new HashSet<>(Arrays.asList(prendreSujet, reviser, entrer));
        HashSet<PrecedenceConstraint> cons2 = new HashSet<>();
        cons2.add(new PrecedenceConstraint(reviser, entrer));
        cons2.add(new PrecedenceConstraint(entrer, prendreSujet));
        cons2.add(new PrecedenceConstraint(prendreSujet, reviser));
		TopologicalSorter sorter1 = new TopologicalSorter();
        ArrayList<Activity> order2 = sorter.bruteForceSort(new HashSet<>(acts2), cons2);
        for (Activity a : acts2) 
		{
			System.out.println("   " + a.getDescription() );
		}
        if (order2 == null) 
        {
			System.out.println("Impossible : le graphe contient un cycle, donc pas d'ordonnancement possible !");
		} else {
    
					System.out.println("Ordonnancement possible :");
					for (Activity a : order2) 
					{
						System.out.println(" - " + a.getDescription());
					}

					System.out.println("Emploi du temps (début = 500) :");
					HashMap<Activity, Integer> sched2 = sorter1.schedule(new HashSet<>(acts2), cons2, 500);

					if (sched2 == null) 
					{
						System.out.println("Aucun emploi du temps possible !!!");
					} else {
								for (Activity a : order2) 
								{
									System.out.println("   " + a.getDescription() + " -> début = " + sched2.get(a));
								}
							}
				}

    
	}
}

