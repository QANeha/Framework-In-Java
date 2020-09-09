package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import models.SimpleContactForm;

public class SimpleContactPage extends BasePage {
	
	public SimpleContactPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@Step("Submit form value")
	public SimpleContactPage sendForm(String firstName, String lastName, String email, String comment)
			throws Exception {
		name.sendKeys(firstName);
		name.sendKeys(lastName);
		name.sendKeys(email);
		name.sendKeys(comment);
		//clickSubmitButton();
		submitButton.click();
		return this;
	}
	
	@Step("Submit form value")
	public SimpleContactPage sendForm(SimpleContactForm form)
			throws Exception {
		name.sendKeys(form.FirstName);
		last.sendKeys(form.LastName);
		email.sendKeys(form.Email);
		comment.sendKeys(form.Message);
		//clickSubmitButton();
		submitButton.click();
		return this;
	}
	
	@FindBy(id = "wpforms-13359-field_0")
	public WebElement name;

	@FindBy(id = "wpforms-13359-field_0-last")
	public WebElement last;

	@FindBy(id = "wpforms-13359-field_1")
	public WebElement email;

	@FindBy(id = "wpforms-13359-field_2")
	public WebElement comment;

	@FindBy(id = "wpforms-submit-13359")
	public WebElement submitButton;
	
	@FindBy(id = "wpforms-confirmation-13359")
	public WebElement submitMessage;
	
	@FindBy(id = "wpforms-13359-field_0-error")
	public WebElement nameRequiredmessage;
	
	@FindBy(id = "wpforms-13359-field_0-last-error")
	public WebElement lastnameRequiredmessage;
	
	@FindBy(id = "wpforms-13359-field_1-error")
	public WebElement emailRequiredmessage;
	
	@FindBy(id = "wpforms-13359-field_2-error")
	public WebElement messageRequiredmessage;
}
