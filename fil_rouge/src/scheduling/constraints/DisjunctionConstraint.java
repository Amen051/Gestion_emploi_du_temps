package scheduling.constraints;

import java.util.*;
import scheduling.activities.Activity;
public class DisjunctionConstraint implements Constraint
{
	private Constraint cont1;
    private Constraint cont2;

    public DisjunctionConstraint(Constraint cont1, Constraint cont2) {
        this.cont1 = cont1;
        this.cont2 = cont2;
    }

    @Override
    public Set<Activity> getActivities() {
        Set<Activity> res = new HashSet<>();
        res.addAll(cont1.getActivities());
        res.addAll(cont2.getActivities());
        return res;
    }
    
    @Override
    public boolean isSatisfied(Map<Activity, Integer> horaires) {
		if(cont1.isSatisfied(horaires)==true || cont2.isSatisfied(horaires) == true)
		{
			return true;
		}else{
				return false;
			}
      
    }

    @Override
    public String toString() {
        return "(" + cont1.toString() + " OU BIEN  " + cont2.toString() + ")";
    }
}
