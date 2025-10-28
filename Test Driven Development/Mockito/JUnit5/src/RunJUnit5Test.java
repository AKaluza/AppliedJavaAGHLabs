import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

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
                "\n------------------------------------------" +
                        "\nTests started: " + summary.getTestsStartedCount() +
                        "\nTests failed: " + summary.getTestsFailedCount() +
                        "\nTests succeeded: " + summary.getTestsSucceededCount() +
                        "\n------------------------------------------"
        );

        if(summary.getTestsFailedCount() > 0) {
            for(TestExecutionSummary.Failure f: summary.getFailures()){
                System.out.println(f.getTestIdentifier().getSource() +
                        "\nException " + f.getException());
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