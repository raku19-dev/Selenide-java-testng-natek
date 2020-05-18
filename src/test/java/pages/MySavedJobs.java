package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class MySavedJobs {
    public void mySavedJobs(){
        SelenideElement element = $(byLinkText("My Job Search"));
        actions().moveToElement(element).perform();
        $(byLinkText("Saved Jobs")).click();
    }

    public void correctNumberOfSavedAndPossibleSavedJobsDisplayed(double savedJobs, double noPossibleSavedJobs){
        $(byXpath("//div[@class='alert alert-info ng-binding']")).
                shouldHave(Condition.exactText("You have saved "+(int) savedJobs+" of "+(int) noPossibleSavedJobs+" possible jobs."));
    }
}
