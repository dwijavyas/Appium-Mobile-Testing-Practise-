package pageObjects.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObjects.Utils.BaseAndroidActions;

public class CartPage extends BaseAndroidActions{

	AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), driver);
	}
	
	//List<WebElement> priceList = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> pricesList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement ActualSumofPrices;
	
	//longpress
	//WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	//longPressAction(ele);
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsCond;
	
	//close
	//driver.findElement(By.id("android:id/button1")).click();
	@AndroidFindBy(id="android:id/button1")
	private WebElement closeTC;
	
	//checkbox
	//driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
	@AndroidFindBy(id="android.widget.CheckBox")
	private WebElement checkbox;
	
	//submit
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	//Thread.sleep(3000);
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement submitBtn;
	
	public List<WebElement> getPricesList() {
		
		return pricesList;
	}
	
	public double sumOfPrices() {
		
		int countList = pricesList.size();
		double totalSum = 0;
		
		for(int i=0;i<countList;i++)
		{
			String priceString = pricesList.get(i).getText();
			Double priceDouble = amountWoDollar(priceString);
			totalSum = totalSum+priceDouble;
												
		}
	
		return totalSum;
	}
	
	
	public Double getActualSumofPrices() {
		
		return amountWoDollar(ActualSumofPrices.getText());
		
	}
	
	
	public void getTrmsCond() {
		
		longPressAction(termsCond);
		closeTC.click();
			}
	
	
public void getSubmitBtn() {
		
	checkbox.click();
	submitBtn.click();
		
	}
}
