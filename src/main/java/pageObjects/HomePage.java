package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By navlinks= By.xpath("//a[contains(@class,'m-nav-link')]");
	
	
	By jwm= By.xpath("//div[contains(@class,'sizeHandler')] //a[contains(@href,'jw-marriot')]");
	
	By destination= By.xpath("//input[contains(@class,'single-search-destination')]");
	
	By findhotels= By.xpath("(//button[contains(@class,'js-is-roomkey')])[2]");
	
//	By address= By.xpath("(//div[contains(@class,'m-hotel-address')])[1]");
	
	By membenifits= By.xpath("//a[@title='Member Benefits ']");
	
	public WebElement returnMemBenifits()
	{
		return driver.findElement(membenifits);
	}
	
	public WebElement returnDestination()
	{
		return driver.findElement(destination);
	}
	
//	public WebElement returnAddress()
//	{
//		return driver.findElement(address);
//	}
	
	public WebElement returnfindhotels()
	{
		return driver.findElement(findhotels);
	}
	
	public WebElement returnOurBrand()
	{
		List<WebElement> l= driver.findElements(navlinks);
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).findElement(By.tagName("p")).getText().equalsIgnoreCase("Our Brands"))
			{
				return l.get(i);
			}
		}
		return l.get(0);
	}
	
	public boolean checkjvm()
	{
		if(driver.findElements(jwm).size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
