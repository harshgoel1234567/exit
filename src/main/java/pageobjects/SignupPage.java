package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	
	WebDriver driver;
	public SignupPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="input[class='r4vIwl BV+Dqf']")
	WebElement emailField;
	
	public WebElement emailField() {
		return emailField;
	}
	
	@FindBy(xpath="//button[normalize-space()='Request OTP']")
	WebElement otpButton;
	
	public WebElement otpButton() {
		return otpButton;
	}
	
	@FindBy(xpath="//button[normalize-space()='Verify']")
	WebElement verifyButton;
	
	public WebElement verifyButton() {
		return verifyButton;
	}
	
	@FindBy(xpath="(//a[normalize-space()='New to Flipkart? Create an account'])[1]")
	WebElement signup;
	
	public WebElement signup() {
		return signup;
	}
	
	@FindBy(css="button[class='QqFHMw twnTnD _7Pd1Fp']")
	WebElement continueButton;
	
	public WebElement continueButton() {
		return continueButton;
	}
	
	@FindBy(css="button[class='QqFHMw twnTnD _7Pd1Fp']")
	WebElement signUpButton;
	
	public WebElement signUpButton() {
		return signUpButton;
	}


}