package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Membership {
	public WebDriver driver;
	
	public Membership(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By headings=By.xpath("//h3[@class='l-margin-top ']");
	
	public boolean checkheading()
	{
		boolean res=false;
		List<WebElement> l= driver.findElements(headings);
		for(int i=0;i<l.size();i++)
		{
			WebElement temp= l.get(i);
			if(temp.getText().equalsIgnoreCase("Mobile Check-In and Mobile Key"))
			{
				res=true;
				break;
			}
		}
		return res;
	}
	

}
