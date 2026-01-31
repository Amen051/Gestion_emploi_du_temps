package scheduling.factoredconstraints;

import scheduling.activities.Activity;

public class MeetConstraint extends BinaryConstraint{		
	
		public MeetConstraint(Activity a1, Activity a2){
			super(a1,a2);
		}
		@Override
		public boolean isSatisfied(int debut1, int debut2){
			int fin1 = debut1 + a1.getDuration(); 
			if(debut2 == fin1)
			{
				return true;
			}else{
					return false;
				}
		}
}
