package scheduling.constraints;

import java.util.*;
import scheduling.activities.Activity;
public class PrecedenceConstraintWithGap extends PrecedenceConstraint implements Constraint
{
   private int min;
   private int max;
   
   public PrecedenceConstraintWithGap(Activity a1, Activity a2, int min, int max){
	   super(a1, a2);
	   this.min = min;
	   this.max = max;
   }
      public boolean isSatisfied(int debut1, int debut2) {
		int fin1 = debut1 + a1.getDuration();
		int diff = debut2 - fin1;

   			if(debut2 >= fin1) 
			{
				if (diff >= min && diff <= max) {
					return true;  
                }
			}
			return false;
}
   @Override
   public boolean isSatisfied(Map<Activity, Integer> horaires)
   {
	   int debut1 = horaires.get(a1);
	   int debut2 = horaires.get(a2);
	   int fin1 = debut1 + a1.getDuration(); 
			if(debut2 >= fin1) 
			{
				int diff = debut2 - fin1;
				if (diff >= min && diff <= max) {
					return true;  
                }
			}
			return false;
			
   }
   @Override
	public String toString() {
		return "PrecedenceConstraintWithGap(" + a1.getDescription() + " ---- et " + a2.getDescription()
           + ", min=" + min + ", max=" + max + ")";
}

}
