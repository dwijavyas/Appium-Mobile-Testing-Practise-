package package1.AppiumPOM;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObjects.Pages.FormPage;

public class BaseTest2 {
	
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	public FormPage formPage;
	
	@BeforeClass
	public void ConfigAppium() throws MalformedURLException {
		
		//to start appium
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//dwija//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();		
		
		service.start();
		
		//to give path for app-sdk and set device name -emulator
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("DwijaEmulator");
		options.setApp("C://Users//dwija//Documents//Eclipse IDE//eclipse-java-2020-09-R-win32-x86_64//Appium//src//test//java//resources//General-Store.apk");
		options.setChromedriverExecutable("C:\\Users\\dwija\\Documents\\Selenium\\chromedriver 113\\chromedriver.exe");
		
		//to set above in the android class
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);	
	}
	
	public void longPressAction(WebElement ele) {
		
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId()
				, "duration", 2000));
	}

	public Double amountWoDollar(String priceString) {
		
		Double priceDouble = Double.parseDouble(priceString.substring(1));
		return priceDouble;
	}
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		service.stop();
	}
}
