package scheduling.solvers;

import java.util.Random;
import schedulingtests.solvers.RandomSchedulerTests;
import schedulingtests.solvers.TopologicalSorterTests;
import schedulingtests.solvers.VerifierTests;
public class Test{

	public static void main(String[] args)
	{
		boolean ok = true;
		TopologicalSorterTests topologicalSortTester = new TopologicalSorterTests();
		ok = ok && topologicalSortTester.testBruteForceSort();
		ok = ok && topologicalSortTester.testSchedule();
		ok = ok && topologicalSortTester.testLinearTimeSort();
		
		VerifierTests verifierTester = new VerifierTests();
		ok = ok && verifierTester.testUnsatisfied();
		
		Random random = new Random();
		RandomSchedulerTests randomSchedulerTester = new RandomSchedulerTests(random);
		ok = ok && randomSchedulerTester.testGenerateOneSchedule();
		ok = ok && randomSchedulerTester.testGenerateSchedule();
		
		System.out.println(ok ? "All tests passed" : "At least one test failed");
	
	}
}
