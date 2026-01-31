package scheduling.constraints;

import java.util.*;
import scheduling.activities.Activity;
public interface Constraint
{
	Set<Activity> getActivities();
	boolean isSatisfied(Map<Activity, Integer> horaires);
	
}
