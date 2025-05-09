package Utils;

import java.io.File;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;

import normalFlow_BaseClasses.addGoalPlan;

public abstract class SuitListener implements ITestListener, IAnnotationTransformer{
	
//	WebDriver driver;
	
	public void onTestFailure(ITestResult result) {

		String fileName = System.getProperty("user.dir")+File.separator+"Screenshort"+File.separator+result.getMethod().getMethodName();
//	File fi=((TakeSreenshot)driver).get
		
	}
	}
