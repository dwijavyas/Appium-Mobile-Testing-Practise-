package package1.AppiumPOM;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.Pages.CartPage;
import pageObjects.Pages.FormPage;
import pageObjects.Pages.ProductsPage;

public class TC1 extends BaseTest2{
	
	@Test
	public void FillForm() throws InterruptedException {
		
		formPage = new FormPage(driver);
		//enter name
		formPage.setNameField("Dwija");
		//select gender
		formPage.setGender("female");
		//select country
		formPage.setCountryNamedd("Argentina");
		//lets shop
		ProductsPage productsPage = formPage.setSubmit();
		
		//add 2 prods to cart
		productsPage.getProductsByIndex(0);
		productsPage.getProductsByIndex(0);
		//go to cart
		CartPage cartPage = productsPage.gotoCart();
		
		//verify the page title
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id(
		 * "com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));
		 */

		//get the sum of the prices
		double totalSum = cartPage.sumOfPrices();
		double formattedSum = cartPage.getActualSumofPrices();
		Assert.assertEquals(totalSum, formattedSum);
		
		//longpress t&c and close 
		cartPage.getTrmsCond();
		//checkbox & //submit
		cartPage.getSubmitBtn();
		
		//webbrowser within the app
		Set<String> contexts = driver.getContextHandles();
		for(String contextName :contexts) {
			
			System.out.println(contextName);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		//native app web brower - same automation inspect ele as of web app
		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//go back to native app from web(native) app
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//still driver does not have knowledge about native app so switch context
		driver.context("NATIVE_APP");
		
}

		
	}

