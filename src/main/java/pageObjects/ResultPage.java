package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
	
	public WebDriver driver;
	public ResultPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By address= By.xpath("(//div[contains(@class,'m-hotel-address')])[1]");
	
	public WebElement returnAddress()
	{
		return driver.findElement(address);
	}

}
