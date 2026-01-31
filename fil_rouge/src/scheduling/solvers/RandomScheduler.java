package scheduling.solvers;

import scheduling.activities.Activity;
import java.util.*;
import java.util.Random;
import scheduling.constraints.Constraint;

public class RandomScheduler
{
	private Set<Activity> acts;
	private int dateMin;
	private int dateMax;
	private int nbTirage;
	private Random random;
	
	public RandomScheduler(Random random)
	{
		this.random = random;
	}
	public Map<Activity, Integer> generateOneSchedule(Set<Activity> acts, int dateMin, int dateMax)
	{
		Map<Activity, Integer> schedule = new HashMap<>();
		for (Activity a : acts)
		{
			int randomDebut = dateMin + random.nextInt(dateMax - dateMin + 1);
			schedule.put(a, randomDebut);
		}
		return schedule;
	}
	public Map<Activity, Integer> generateSchedule(Set<Activity> acts, Set<Constraint> constraints, int dateMin, int dateMax, int nbTirage)
	{
		  Verifier verifier = new Verifier(constraints);
		  Map<Activity, Integer> meilleurSchedule = null;
		  
		  int meilleurScore = Integer.MAX_VALUE;
		  
		  for (int i = 0; i < nbTirage; i++) 
		  {
			  Map<Activity, Integer> schedule = generateOneSchedule(acts, dateMin, dateMax);
			  Set<Constraint> unsatisfied = verifier.unsatisfied(schedule);
			  int nbNonSatisfait = unsatisfied.size();

			  if (nbNonSatisfait == 0)
			  {
				 return schedule;
			  }
			  
			  if (nbNonSatisfait < meilleurScore)
			  {
					meilleurScore = nbNonSatisfait;
					meilleurSchedule = schedule;
			  }
		  }
		  return meilleurSchedule;
	}
}
