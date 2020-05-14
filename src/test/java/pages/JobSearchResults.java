package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class JobSearchResults {

    public JobSearchResults(){
        $(byXpath("//div[@id='SearchResults']")).waitUntil(Condition.visible,10000);
    }

    public void openSpecificJobOffer(String index) {

        double page = Math.ceil(Double.parseDouble(index)/Double.parseDouble(getResultsPerPage()));
        open("https://browse.monsterworksdemo.com/search/?cn=Philips&stpage=1&page=" + ((int) page));

        double indexOnPage = Double.parseDouble(index)%Double.parseDouble(getResultsPerPage());
        indexOnPage--; //index on page starts from 0, that is -1 is needed
        $$(byXpath("//div[@id='SearchResults']/section[contains(@class,'card-content')]")).get((int) indexOnPage).click();
    }

    public String getTotalJobsFound() {
        return $(byXpath("//*[@class='mux-search-results']")).getAttribute("data-total-search-results");
    }

    public String getResultsPerPage(){
        return $(byXpath("//*[@class='mux-search-results']")).getAttribute("data-results-per-page");
    }

    public void saveCurrentlyOpenJobOffer(){
        $(byLinkText("Save")).click();
    }
}
