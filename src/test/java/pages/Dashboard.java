package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class Dashboard {

    public Dashboard(){

        $(byLinkText("Philips Jobs")).waitUntil(Condition.visible,10000);
    }

    public void openLinkText(String linkText){
        SelenideElement element = $(byLinkText(linkText));
        element.scrollIntoView(true);
        element.click();
    }
}
