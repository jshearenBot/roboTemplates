package test.java.roboUtilities;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by JShearen7 on 4/5/2016.
 */

public class TestSuiteEnvironment {
    static String testCaseEnvironment;

    public TestSuiteEnvironment(){
        if (testCaseEnvironment == null) {
            testCaseEnvironment = "Production";
        }
    }

    public void setTestSuiteEnvironment(String Environement) {
        testCaseEnvironment = Environement;
    }

    public String getTestSuiteEnvironment() {
        return testCaseEnvironment;
    }
}
