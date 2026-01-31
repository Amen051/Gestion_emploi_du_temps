package scheduling.constraints;

import java.util.*;
import scheduling.activities.Activity;

public class TestDisjunction {

    public static void main(String[] args) {
        boolean ok = true;

        Activity acts1 = new Activity("A", 10);
        Activity acts2 = new Activity("B", 5);

        Constraint cont1 = new UnaryConstraint(acts1, 0, 0);   
        Constraint cont2 = new UnaryConstraint(acts2, 10, 20); 

        Constraint OR = new DisjunctionConstraint(cont1, cont2);

        Map<Activity, Integer> sched = new HashMap<>();
        sched.put(acts1, 0);
        sched.put(acts2, 200);

        ok = ok && OR.isSatisfied(sched); 

        sched.put(acts1, 200);
        sched.put(acts2, 15);

        ok = ok && OR.isSatisfied(sched); 

        sched.put(acts1, 200);
        sched.put(acts2, 200);

        ok = ok && !OR.isSatisfied(sched); 

        ok = ok && OR.getActivities().contains(acts1);
        ok = ok && OR.getActivities().contains(acts2);

        System.out.println(ok ? "All test passed for Disjunction OK" : "At least one test for Disjunction FAILED");
    }
}
