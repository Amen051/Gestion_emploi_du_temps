package scheduling.constraints;
import java.util.*;
import scheduling.activities.Activity;
public abstract class BinaryConstraint implements Constraint{
	public int debut1;
	public int debut2;
	protected Activity a1;
    protected Activity a2;
	public BinaryConstraint(Activity a1, Activity a2){
		this.a1 = a1;
		this.a2 = a2;
	}
	
	public Activity getFirst(){
		
			return this.a1;
	}
	public Activity getSecond(){
			return this.a2;
	}
	@Override
	public Set<Activity> getActivities()
	{
		Set<Activity> activities = new HashSet<> ();
		activities.add(a1);
		activities.add(a2);
		return activities;
	}
	public abstract boolean isSatisfied(int debut1, int debut2);
}
