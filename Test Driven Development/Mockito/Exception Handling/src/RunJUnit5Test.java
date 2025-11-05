import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class RunJUnit5Test {
    SummaryGeneratingListener listener = new SummaryGeneratingListener();


    public void runAll() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(MathApplicationTest.class))
                //.selectors(selectPackage("org.example"))
                //.filters(includeClassNamePatterns(".*Test"))
                .build();
        Launcher launcher = LauncherFactory.create();
        TestPlan testPlan = launcher.discover(request);
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }
    private static void printReport(TestExecutionSummary summary) {

        System.out.println(
                System.lineSeparator()+ "------------------------------------------" +
                        System.lineSeparator()+ "Tests started: " + summary.getTestsStartedCount() +
                        System.lineSeparator()+ "Tests failed: " + summary.getTestsFailedCount() +
                        System.lineSeparator()+ "Tests succeeded: " + summary.getTestsSucceededCount() +
                        System.lineSeparator()+ "------------------------------------------"
        );

        if(summary.getTestsFailedCount() > 0) {
            for(TestExecutionSummary.Failure f: summary.getFailures()){
                System.out.println(f.getTestIdentifier().getSource() +
                        System.lineSeparator()+ "Exception " + f.getException());
            }
        }
    }


    public static void main(String[] args) {
        RunJUnit5Test runner = new RunJUnit5Test();
        runner.runAll();

        TestExecutionSummary summary = runner.listener.getSummary();
        printReport(summary);
    }
}