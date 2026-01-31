package scheduling.basicconstraints;

import scheduling.activities.Activity;
public class PrecedenceConstraintWithGap extends PrecedenceConstraint{
   private int min;
   private int max;
   
   public PrecedenceConstraintWithGap(Activity a1, Activity a2, int min, int max){
	   super(a1, a2);
	   this.min = min;
	   this.max = max;
   }
   @Override
   public boolean isSatisfied(int debut1, int debut2)
   {
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
}
