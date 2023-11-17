package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h4[@class='mb-0 font-size-18']")
	WebElement heading;
	
	public boolean isMyDashboardPageExists() {
		
		try {
			
			
			
			return(heading.isDisplayed());
		}catch(Exception e)
		
		{
			
		return(false);	
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
