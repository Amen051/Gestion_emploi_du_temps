package scheduling.constraints;

import java.util.*;
import scheduling.activities.Activity;
public class UnaryConstraint implements Constraint
{
	protected Activity act;
	protected int min;
	protected int max;
	public UnaryConstraint(Activity act, int min, int max)
	{
		this.act = act;
		this.min = min;
		this.max = max;
	}
	@Override
	public Set<Activity> getActivities()
	{
		Set<Activity> activities = new HashSet<> ();
		activities.add(act);
		return activities;
	}
	@Override
	public boolean isSatisfied(Map<Activity, Integer> horaires)
	{
		int debut = horaires.get(act);
		if(debut >= min && debut<= max)
		{
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "UnaryConstraint(" + act.getDescription()
           + ", min=" + min + ", max=" + max + ")";
}
}
