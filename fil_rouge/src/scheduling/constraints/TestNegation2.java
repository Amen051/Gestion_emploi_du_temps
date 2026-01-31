package scheduling.constraints;

import java.util.*;
import scheduling.activities.Activity;

public class TestNegation2 {

    public static void main(String[] args) {
        boolean ok = true;

        Activity acts = new Activity("A", 10);

        Constraint base = new UnaryConstraint(acts, 0, 0);
        Constraint neg = new NegationConstraint(base);

        Map<Activity, Integer> sched1 = new HashMap<>();
        sched1.put(acts, 0);

        Map<Activity, Integer> sched2 = new HashMap<>();
        sched2.put(acts, 5);

        ok = ok && !neg.isSatisfied(sched1);  

        ok = ok && neg.isSatisfied(sched2);   

        ok = ok && neg.getActivities().isEmpty(); 

        System.out.println(ok ? 
            "All tests passed of NegationConstraint passed" : 
            "At least one test of NegationConstraint FAILED");
    }
}
