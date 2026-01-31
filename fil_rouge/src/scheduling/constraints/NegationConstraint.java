package scheduling.constraints;


import java.util.*;
import scheduling.activities.Activity;
public class NegationConstraint implements Constraint
{
	private Constraint cont;  
	
    public NegationConstraint(Constraint cont) {
        this.cont = cont;
    }
    
    @Override
    public Set<Activity> getActivities() {
        return cont.getActivities();
    }
    
    @Override
    public boolean isSatisfied(Map<Activity, Integer> horaires)
    {
		if(cont.isSatisfied(horaires)==true)
		{
			return false;
		}else{
				return true;
			}
		
	}

    @Override
    public String toString() 
    {
        return "NEGATION DE (" + cont.toString() + ")";
    }
}
