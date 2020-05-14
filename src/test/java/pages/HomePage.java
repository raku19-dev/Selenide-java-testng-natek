package pages;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public NewAccount createAccount()    {
        $(byLinkText("CREATE ACCOUNT")).click();
        return new NewAccount();
    }
}
