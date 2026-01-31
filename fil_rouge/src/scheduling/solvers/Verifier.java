package scheduling.solvers;

import scheduling.constraints.Constraint;
import scheduling.activities.Activity;
import java.util.*;
public class Verifier
{
	private Set<Constraint> cont;
	public Verifier(Set<Constraint> cont)
	{
		this.cont = new HashSet<>(cont);
	}

	public Set<Constraint> unsatisfied(Map<Activity, Integer> schedule) {
        Set<Constraint> unsat = new HashSet<>();

        for (Constraint c : cont) {


                boolean satis = c.isSatisfied(schedule);
                if (!satis) {
                    unsat.add(c);
                }
		}
        return unsat;
    }
}
