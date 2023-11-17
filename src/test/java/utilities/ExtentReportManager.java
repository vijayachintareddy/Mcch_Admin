package utilities;

import java.io.IOException;
//import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
   
    public  ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    
    String repName;
    public void onStart(ITestContext testContext) {
    	
   String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp
  repName="Test-Report-" + timestamp +".html";
  
  sparkReporter=new ExtentSparkReporter(".\\reports\\" + repName); //specify location of the report
  sparkReporter.config().setDocumentTitle("Mcch Admin Automation Report"); //Title of the report
  sparkReporter.config().setReportName("Mcch Admin Functional Testing"); // name of the report
  sparkReporter.config().setTheme(Theme.DARK);
  
  extent=new ExtentReports();
  extent.attachReporter(sparkReporter);
  extent.setSystemInfo("Application", "Mcch");
  extent.setSystemInfo("Module", "Admin");
  extent.setSystemInfo("Sub Module", "Login");
  extent.setSystemInfo("operating System",System.getProperty("os.name"));
  extent.setSystemInfo("User Name",System.getProperty("user.name"));
  extent.setSystemInfo("Environement", "QA");
    }
    public void onTestSuccess(ITestResult result) {
    	test=extent.createTest(result.getName());
    	test.log(Status.PASS,"Test Passed");
    }
  
  public void onTestFailure(ITestResult result) {
	  test=extent.createTest(result.getName());
  
  test.log(Status.FAIL,"Test Failed");
  test.log(Status.FAIL,result.getThrowable().getMessage());
  try {
	  
	  String  impath=new BaseClass().capturesScreen(result.getName());
  
 test.addScreenCaptureFromPath(impath);
 }catch(IOException e1) {
	 e1.printStackTrace();
 }
  
  }
  public void onTestSkipped(ITestResult result) {
	  test=extent.createTest(result.getName());
	 // test.createNode(result.getName());
	 // test.assignCategory(result.getMethod().getGroups());
	  test.log(Status.SKIP,"Test Skipped");
	  test.log(Status.SKIP,result.getThrowable().getMessage());
  
  }
  public void onFinish(ITestContext testContext) {
	  extent.flush();
  
    /*   try {URL url=new
    		   
    	URL("file:///"+System.getProperty("user.dir")+"\\reports\\+repName");
      // create the email message
       ImageHtmlEmail email=new ImageHtmlEmail();
       email.setDataSourceResolver(new DataSourceUrlResolver(url));
       email.setHostName("smtp.googleemail.com");
       email.setSmtPort(465);
       email.setAuthenticator(new DefaultAuthenticator("vijayach.digital@gmail.com","password"));
       email.setSSLOnConnect(true);
       email.sentFrom("vijayach.digital@gmail.com"); //sender
       email.setSubject("Test Result");
       email.setMsg("Please find Attached Report.....");
       email.addTo("vijayadurgachintareddy@gmail.com"); //Receiver 
       email.attach(url,"extent report","Please Check report....");
       email.send(); //send the mail
       }
       catch(Exception e) {
    	   e.printStackTrace();
       }*/
       
       
       
       
       
       
       
       }
  
  
  
  
    }



