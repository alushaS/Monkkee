package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.PrintStream;

public class Retry implements IRetryAnalyzer {
    private int attempt = 0;
    private static final int MAX_RETRY = 5;

    public Retry() {
    }

    public boolean retry(ITestResult result) {
        if (!result.isSuccess() && this.attempt < 5) {
            ++this.attempt;
            PrintStream var10000 = System.out;
            String var10001 = result.getName();
            var10000.println("Retrying test " + var10001 + " for the " + this.attempt + " time.");
            return true;
        } else {
            return false;
        }
    }
}
