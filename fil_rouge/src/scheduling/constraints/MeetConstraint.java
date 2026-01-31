package scheduling.constraints;

import java.util.*;
import scheduling.activities.Activity;

public class MeetConstraint extends BinaryConstraint implements Constraint
{		
	
		public MeetConstraint(Activity a1, Activity a2){
			super(a1,a2);
		}
		
		public boolean isSatisfied(int debut1, int debut2) {
		int fin1 = debut1 + a1.getDuration();
			if(debut2 == fin1)
			{
				return true;
			}else{
					return false;
				}
			}
		
		@Override
		public boolean isSatisfied(Map<Activity, Integer> horaires){
			int debut1 = horaires.get(a1);
			int debut2 = horaires.get(a2);
			int fin1 = debut1 + a1.getDuration(); 
			if(debut2 == fin1)
			{
				return true;
			}else{
					return false;
				}
		}
		@Override
		public String toString() {
			return "MeetConstraint(" + a1.getDescription() + " meets " + a2.getDescription() + ")";
}

}
