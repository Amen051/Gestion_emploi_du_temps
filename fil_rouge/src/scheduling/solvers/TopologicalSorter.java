package scheduling.solvers;

import scheduling.activities.Activity;
import scheduling.constraints.PrecedenceConstraint;

import java.util.*;

public class TopologicalSorter {

    public TopologicalSorter() {
        
    }

    public List<Activity> bruteForceSort(Set<Activity> activities, Set<PrecedenceConstraint> constraints) {
       
        Set<Activity> copy = new HashSet<>(activities);
        List<Activity> res = new ArrayList<>();

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

    private Activity getAvailableActivity(Set<Activity> remaining, Set<PrecedenceConstraint> constraints, List<Activity> done) {
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
        public Map<Activity, Integer> schedule(Set<Activity> activities,Set<PrecedenceConstraint> constraints, int dateDepart){
		List<Activity> ordre = bruteForceSort(activities, constraints);
		if (ordre == null)
		{
			return null;
		}
		Map<Activity, Integer> horaires = new HashMap<>();
		int currentTime = dateDepart;
        for(Activity act : ordre){
			 horaires.put(act, currentTime);
			 currentTime = currentTime + act.getDuration();
			 
		}
		return horaires;
	}
	public List<Activity> linearTimeSort(Set<Activity> activities, Set<PrecedenceConstraint> constraints) 
	{

        Map<Activity, Integer> nbPredecesseurs = new HashMap<>();
        Map<Activity, List<Activity>> successeurs = new HashMap<>();

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

       List<Activity> L = new ArrayList<>();
        for (Activity a : activities) {
            if (nbPredecesseurs.get(a) == 0) {
                L.add(a);
            }
        }

        List<Activity> res = new ArrayList<>();

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

