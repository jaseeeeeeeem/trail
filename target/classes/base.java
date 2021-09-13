package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	public static WebDriver driver;
	Properties prop;
	
	public void initialiseDriver() throws IOException
	{
		prop= new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\Eclipse2\\MLA4\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Eclipse2\\MLA4\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else {
			System.out.println(prop.getProperty("browser"));
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void getScreenshot(String res) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/"+res+"-ss.png"));
	}
}
