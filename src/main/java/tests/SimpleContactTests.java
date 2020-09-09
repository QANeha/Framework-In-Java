package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import models.SimpleContactForm;
import pages.AuthorizationPage;
import pages.SimpleContactPage;

public class SimpleContactTests extends BaseTest {
	
	@BeforeMethod
	public void SetUp() {
		var authorizationPage = new AuthorizationPage(driver);
		authorizationPage.goToPage("http://qaauto.co.nz/simple-contact-form/");
	}

	@Test
	public void TestSimpleContact() throws Exception
	{
		SimpleContactForm simplecontact = new SimpleContactForm();
		SimpleContactPage contactPage = new SimpleContactPage(driver);
		contactPage.sendForm(simplecontact);
		Assert.assertEquals("Thanks for contacting us! We will be in touch with you shortly.", contactPage.submitMessage.getText());
	}
	
	@Test
	public void TC_With_Model() throws Exception
	{
		SimpleContactForm simplecontact = new SimpleContactForm();
		simplecontact.FirstName = "";
		simplecontact.LastName = "";
		simplecontact.Email = "";
		simplecontact.Message = "";
		
		SimpleContactPage contactPage = new SimpleContactPage(driver);
		contactPage.sendForm(simplecontact);
		//Thread.sleep(5000);
		Assert.assertEquals("This field is required.", contactPage.nameRequiredmessage.getText());
		Assert.assertEquals("This field is required.", contactPage.lastnameRequiredmessage.getText());
		Assert.assertEquals("This field is required.", contactPage.emailRequiredmessage.getText());
		Assert.assertEquals("This field is required.", contactPage.messageRequiredmessage.getText());
	}

	@Test
	public void TC_With_Values() throws Exception
	{
		SimpleContactPage contactPage = new SimpleContactPage(driver);
		contactPage.name.sendKeys("Hello");
		contactPage.last.sendKeys("World");
		contactPage.email.sendKeys("Hello@world.com");
		contactPage.comment.sendKeys("Hello World testing");
		contactPage.submitButton.click();
		Assert.assertEquals("Thanks for contacting us! We will be in touch with you shortly.", contactPage.submitMessage.getText());
	}
	
}
