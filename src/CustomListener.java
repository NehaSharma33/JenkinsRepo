import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {

     public void onTestStart(ITestResult result) {
         System.out.println("Tests Started:" +result.getName());

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Tests Passed: "+result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

}
