package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.HomePage;
import pageObjects.Membership;
import pageObjects.ResultPage;
import resources.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@RunWith(Cucumber.class)
public class stepDefinition extends base {
	static ExtentReports report;
	static ExtentTest test;
	private static Logger log= LogManager.getLogger(stepDefinition.class.getName());
	

    @Given("^driver is initialised$")
    public void driver_is_initialised() throws Throwable {
    	report= new ExtentReports("./Reports/ExtentReport.html");
    	test=report.startTest("stepDefinitions");
    	log.info("initialised");
        initialiseDriver();
    }

    @When("^user clicks on our brands$")
    public void user_clicks_on_our_brands() throws Throwable {
        HomePage hp = new HomePage(driver);
        hp.returnOurBrand().click();
        log.info("clicked on button");
    }

    @Then("^jwmarriot should be present$")
    public void jwmarriot_should_be_present() throws Throwable {
        HomePage hp1=new HomePage(driver);
        Thread.sleep(5000L);
        Assert.assertTrue(hp1.checkjvm());
        test.log(LogStatus.PASS, "jw marriot is present");
    	report.endTest(test);
        report.flush();
        driver.close();
    }

    @And("^user enters \"([^\"]*)\"$")
    public void user_enters_something(String strArg1) throws Throwable {
        driver.get(strArg1);
    }
    
    @When("^user enters \"([^\"]*)\" and search$")
    public void user_enters_something_and_search(String strArg1) throws Throwable {
        HomePage hp= new HomePage(driver);
        hp.returnDestination().clear();
        String k= Keys.chord(strArg1,Keys.ENTER);
        hp.returnDestination().sendKeys(k);
        hp.returnfindhotels().click();
    }

    @Then("^the first result address should contain \"([^\"]*)\"$")
    public void the_first_result_address_should_contain_something(String strArg1) throws Throwable {
        ResultPage rp=new ResultPage(driver);
        if(rp.returnAddress().getText().contains(strArg1))
        {
        	Assert.assertTrue(true);
        	test.log(LogStatus.PASS, "Result contains the word");
        	report.endTest(test);
            report.flush();
        }
        else {
        	test.log(LogStatus.FAIL, "Result doesn't contain the word");
        	report.endTest(test);
            report.flush();
        	Assert.assertTrue(false);
        }
        driver.close();
        
    }
    
    @When("^user clicks on member benefits$")
    public void user_clicks_on_member_benefits() throws Throwable {
        HomePage hp=new HomePage(driver);
        hp.returnMemBenifits().click();
    }

    @Then("^the page should contain the text$")
    public void the_page_should_contain_the_text() throws Throwable {
        Membership m=new Membership(driver);
        Assert.assertTrue(m.checkheading());
        test.log(LogStatus.PASS, "page contains the text");
        report.endTest(test);
        report.flush();
        driver.close();
    }

}