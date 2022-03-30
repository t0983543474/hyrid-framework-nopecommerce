package reportConfig;



import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import common.BaseTest;
import common.GlobalConstants;

public class ReportNGListener extends BaseTest implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("---------- " + result.getName() + " FAILED test ----------");
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		Object testClass = result.getInstance();
		WebDriver webDriver = ((BaseTest) testClass).getInstance();

		String screenshotPath = captureScreenShotBase64(webDriver, result.getName());
		Reporter.getCurrentTestResult();
//		Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///" + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
		Reporter.log("<br><a target=\"_blank\" href=\"data:image/png;base64," + screenshotPath + "\">" + "<img src=\"data:image/png;base64," + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
		Reporter.setCurrentTestResult(null);
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public String captureScreenShot(WebDriver driver , String screenShotName) {
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String screenPath = GlobalConstants.SCREENSHOT_FOLDER + screenShotName + File.separator + formater.format(calendar.getTime()) +  ".png";
			FileUtils.copyFile(source, new File(screenPath));
			return screenPath;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception while taking screenshot: " + e.getMessage());
			return e.getMessage();
		}
	}
	
	public String captureScreenShotBase64(WebDriver driver , String screenShotName) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}

}
