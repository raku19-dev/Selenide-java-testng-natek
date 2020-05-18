package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public NewAccount createAccount()    {
        $(byLinkText("CREATE ACCOUNT")).click();
        return new NewAccount();
    }

    public void verifyIfUserIsLoggedIn() {
        $(byId("dropdown-scrollable-container")).shouldHave(text("Profile"));
    }
}
