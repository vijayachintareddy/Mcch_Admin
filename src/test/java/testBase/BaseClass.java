package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 public static WebDriver driver;
	 public Logger logger; //for logging
	 
	 public ResourceBundle rb;
		@Parameters("browser")
		@BeforeClass(groups= {"Master","Sanity","Regression"})
		 public  void setup(String br)
		  {
			
			rb=ResourceBundle.getBundle("config");  // load config.properties file
			logger=LogManager.getLogger(this.getClass()) ; //logging
			//WebDriverManager.chromedriver().setup(); //latest selenium 4.0 above versions webdrivermanager not requied
			if(br.equals("chrome"))
			{
				
				driver=new ChromeDriver();
			}
			
			else if(br.equals("edge")) {
				
				driver=new EdgeDriver();
			}
			
			else
			{
				driver=new FirefoxDriver();
			}
			
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		     driver.get(rb.getString("appURL"));
		     driver.manage().window().maximize();
		     
		     
		  }
		
		
		@AfterClass(groups= {"Master","Sanity","Regression"})
	public	void tearDown()
		{
			driver.quit();
		}


	public String capturesScreen(String tname) throws IOException{
	
	
	
	
	String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
	File source=takesScreenshot.getScreenshotAs(OutputType.FILE);	
	String destination=System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timestamp + ".png";		
	try {
		FileUtils.copyFile(source, new File(destination));}
		catch(Exception e) {
			e.getMessage();
		}
	return destination;
		
		
	}
}
