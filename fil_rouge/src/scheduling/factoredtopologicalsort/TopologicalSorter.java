package scheduling.factoredtopologicalsort;

import scheduling.activities.Activity;
import scheduling.factoredconstraints.PrecedenceConstraint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class TopologicalSorter {

    public TopologicalSorter() {
        
    }

    public ArrayList<Activity> bruteForceSort(HashSet<Activity> activities, HashSet<PrecedenceConstraint> constraints) {
       
        HashSet<Activity> copy = new HashSet<>(activities);
        ArrayList<Activity> res = new ArrayList<>();

        while (!copy.isEmpty()) {
            
            Activity dispo = getAvailableActivity(copy, constraints, res);

            if (dispo == null) {
                return null;
            }

            res.add(dispo);
            copy.remove(dispo);
        }

        return res;
    }

    private Activity getAvailableActivity(HashSet<Activity> remaining, HashSet<PrecedenceConstraint> constraints, ArrayList<Activity> done) {
        for (Activity a : remaining) {
            boolean disponible = true;

            for (PrecedenceConstraint c : constraints) {
                
                if (c.getSecond().equals(a) && !done.contains(c.getFirst())) {
                    disponible = false;
                    break;
                }
            }

            if (disponible) {
                return a;
            }
        }
        return null;
    }
        public HashMap<Activity, Integer> schedule(HashSet<Activity> activities,HashSet<PrecedenceConstraint> constraints, int dateDepart){
		ArrayList<Activity> ordre = bruteForceSort(activities, constraints);
		if (ordre == null)
		{
			return null;
		}
		HashMap<Activity, Integer> horaires = new HashMap<>();
		int currentTime = dateDepart;
        for(Activity act : ordre){
			 horaires.put(act, currentTime);
			 currentTime = currentTime + act.getDuration();
			 
		}
		return horaires;
	}
	public ArrayList<Activity> linearTimeSort(HashSet<Activity> activities, HashSet<PrecedenceConstraint> constraints) 
	{

        HashMap<Activity, Integer> nbPredecesseurs = new HashMap<>();
        HashMap<Activity, ArrayList<Activity>> successeurs = new HashMap<>();

        for (Activity a : activities) {
            nbPredecesseurs.put(a, 0);
            successeurs.put(a, new ArrayList<>());
        }

        for (PrecedenceConstraint c : constraints) {
            Activity first = c.getFirst();
            Activity second = c.getSecond();

            nbPredecesseurs.put(second, nbPredecesseurs.get(second) + 1);
            successeurs.get(first).add(second);
        }

        ArrayList<Activity> L = new ArrayList<>();
        for (Activity a : activities) {
            if (nbPredecesseurs.get(a) == 0) {
                L.add(a);
            }
        }

        ArrayList<Activity> res = new ArrayList<>();

        while (!L.isEmpty()) {
            Activity o = L.remove(0);  
            res.add(o);

            for (Activity succ : successeurs.get(o)) {
                nbPredecesseurs.put(succ, nbPredecesseurs.get(succ) - 1);

                if (nbPredecesseurs.get(succ) == 0) {
                    L.add(succ);
                }
            }
        }

        if (res.size() == activities.size()) {
            return res;
        } else {
           
            return null;
        }
    }
	
}

