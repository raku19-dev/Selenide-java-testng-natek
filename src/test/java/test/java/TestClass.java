package test.java;

import com.codeborne.selenide.Condition;
import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.HomePage;
import pages.JobSearchResults;
import pages.MySavedJobs;

import java.util.concurrent.TimeoutException;

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
  public void SimpleTest() throws TimeoutException {

    String eMail = "tst@gmail.cad";
    String password = "@W3e4r5t";
    String jobCenter = "To edit the items in here change messages 389442-389565";

    double noSavedJobs = 2;
    double noPossibleSavedJobs = 25;

    HomePage homePage = new HomePage();
    homePage.createAccount().fillTheFormAndCreate
            (eMail, password, password, jobCenter, true);

    Dashboard dashBoard = new Dashboard();
    dashBoard.openLinkText("Philips Jobs");

    JobSearchResults job = new JobSearchResults();
    job.openSpecificJobOffer("2");
    job.saveCurrentlyOpenJobOffer();

    job.openSpecificJobOffer(job.getTotalJobsFound());
    job.saveCurrentlyOpenJobOffer();

    MySavedJobs savedJobs = new MySavedJobs();
    savedJobs.openMySavedJob();
    savedJobs.correctNumberOfSavedAndPossibleSavedJobsDisplayed(noSavedJobs,noPossibleSavedJobs);

  }
}
