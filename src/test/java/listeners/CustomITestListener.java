package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.BaseClass;
import utils.Log;

public class CustomITestListener extends BaseClass implements ITestListener{

	@Override
	public void onFinish(ITestContext context) {
		Log.info("CustomITestListener :: onFinish method started "+context.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		Log.info("CustomITestListener :: onStart method started "+ context.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	@Override
	public void onTestFailure(ITestResult result) {
		Log.info("CustomITestListener :: onTestFailure Method " +result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {}

	@Override
	public void onTestStart(ITestResult result) {
		Log.info("CustomITestListener :: New Test Started " +result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("CustomITestListener :: onTestSuccess Method " +result.getName());
	}

}
