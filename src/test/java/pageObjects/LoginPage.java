package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


	public class LoginPage extends BasePage  {

		public LoginPage(WebDriver driver) {
			super(driver);
			
		}

		//Elements
		
		@FindBy(name="email")
		WebElement txtEmail;
		
		@FindBy(name="password")
	    WebElement txtPassword;


		@FindBy(xpath="//button[@type='submit']")
	    WebElement btnLogin;

		@FindBy(xpath="//span[normalize-space()='Dashboard']")
		WebElement msgConfirmation;
		
		@FindBy(xpath="//span[@class='d-none d-xl-inline-block ms-2 me-1']")
		WebElement profile;
		
		@FindBy(xpath="(//span)[4]")
		WebElement logout;

	    //Action Methods
		
	   public void setEmail(String email) {
		   
		   txtEmail.sendKeys(email);
	   }
		
		public void setPassword(String pwd) {
			
			txtPassword.sendKeys(pwd);
		}
		
		public void ClickLogin() {
			
			btnLogin.click();
		}
		public void clickProfile() {
			profile.click();
		}
		
		public void clickLogout()
		{
			logout.click();
		}
		
		
		
		public String getConfirmationMsg() {
			try {
				
				return(msgConfirmation.getText());
			}catch(Exception e) {
				return(e.getMessage());
			
			}
		}
		
		
}
