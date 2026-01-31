package scheduling.constraints;

import java.util.*;
import scheduling.activities.Activity;

public class MaxSpanConstraint implements Constraint
{
	
	protected Set<Activity> acts;
	protected int maxSpan;
	
	public MaxSpanConstraint(Set<Activity> acts, int maxSpan)
	{
		this.acts = new HashSet<>(acts);
		this.maxSpan = maxSpan;
	}
	@Override
	public Set<Activity> getActivities()
	{
		return new HashSet<>(acts);
	}
	@Override
	public boolean isSatisfied(Map<Activity, Integer> horaires)
	{
		if (acts.isEmpty()) 
		{
			return true;
		}
		int minDebut = Integer.MAX_VALUE;
		int maxFin = Integer.MIN_VALUE;
		for(Activity mesActivities : acts)
		{
			int debut = horaires.get(mesActivities);
			int fin = debut + mesActivities.getDuration();
			if(debut < minDebut)
			{
				minDebut = debut;
			}
			if(fin>maxFin)
			{
				maxFin = fin;
			}
		}
		if((maxFin - minDebut) <= maxSpan)
		{
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "MaxSpanConstraint(" + acts.size() + " activités, maxSpan=" + maxSpan + ")";
}

}
