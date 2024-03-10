package pageObjects.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObjects.Utils.BaseAndroidActions;

public class ProductsPage extends BaseAndroidActions{

	AndroidDriver driver;
	
	//create constructor
	public ProductsPage(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), driver);
		
	}
	
	//add 2 prod to cart
	//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> getProducts;	
	
	//go to cart
	//driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement goToCart;
	
	
	public void getProductsByIndex(int index) {
		
		getProducts.get(index).click();
		
	}
	
	public CartPage gotoCart() throws InterruptedException {
		
		goToCart.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}
	
	
	
	
	
	
	
}
