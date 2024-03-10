package pageObjects.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObjects.Utils.BaseAndroidActions;

public class FormPage extends BaseAndroidActions{
	
	AndroidDriver driver;
		
	public FormPage(AndroidDriver driver) {
		
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator (driver), driver);
		
	}
	
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Dwija");
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement submitButton;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryNamedd;
	//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
	//driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	
	
	public void setNameField(String name) {
		
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender) {
		
		if(gender.contains("female")) 
		femaleOption.click();
		else 
		maleOption.click();
	}
	
	public void setCountryNamedd(String country) throws InterruptedException {
	
		countryNamedd.click();
		scrollToText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
		Thread.sleep(2000);
		
	}
	
	public ProductsPage setSubmit() throws InterruptedException {
		
		submitButton.click();
		Thread.sleep(2000);
		return new ProductsPage(driver);
	}
	
	
}

