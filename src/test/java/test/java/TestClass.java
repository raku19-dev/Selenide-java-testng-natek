package test.java;

import com.codeborne.selenide.Condition;
import com.mifmif.common.regex.Generex;
import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.HomePage;
import pages.JobSearchResults;
import pages.MySavedJobs;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class TestClass {

  @BeforeTest
  public void setup() {
    BasicConfigurator.configure();
    clearBrowserCookies();
    open("https://www.monsterworksdemo.com/home/");
    $(byId("search-panel")).waitUntil(Condition.visible, 10000);
  }

  @AfterTest
  public void teardown() {
    closeWebDriver();
  }

  @Test
  public void SimpleTest() {

    String regex = "\\w{10}\\@gmail\\.com";
    String eMail = new Generex(regex).random();
    String password = "@W3e4r5t";
    String jobCenter = "To edit the items in here change messages 389442-389565";

    double numberOfSavedJobs = 2;
    double numberOfPossibleSavedJobs = 25;

    HomePage homePage = new HomePage();
    homePage.createAccount().fillTheFormAndCreate
            (eMail, password, password, jobCenter);
    homePage.verifyIfUserIsLoggedIn();

    Dashboard dashBoard = new Dashboard();
    dashBoard.openLinkText("Philips Jobs");

    JobSearchResults job = new JobSearchResults();
    job.openSpecificJobOffer(2);
    job.saveJobOffer();

    job.openSpecificJobOffer(job.getTotalJobsFound());
    job.saveJobOffer();

    MySavedJobs savedJobs = new MySavedJobs();
    savedJobs.mySavedJobs();
    savedJobs.correctNumberOfSavedAndPossibleSavedJobsDisplayed
            (numberOfSavedJobs,numberOfPossibleSavedJobs);
  }
}
