package scheduling.basicconstraints;

import scheduling.activities.Activity;

	public class PrecedenceConstraint{		
		protected Activity a1;
		
		protected Activity a2;
		
		public PrecedenceConstraint(Activity a1, Activity a2){

			this.a1 = a1;
			this.a2 = a2;
		}
		
		public Activity getFirst(){
		
			return this.a1;
		}
		public Activity getSecond(){
			return this.a2;
		}
		
		public boolean isSatisfied(int debut1, int debut2){
			int fin1 = debut1 + a1.getDuration(); 
			if(debut2 >= fin1)
			{
				return true;
			}else{
					return false;
				}
		}
}
