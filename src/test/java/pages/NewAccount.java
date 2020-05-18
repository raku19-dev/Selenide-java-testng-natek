package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class NewAccount {

    NewAccount(){
        $(byId("c_elem_0")).waitUntil(Condition.visible,10000);
    }
    public void enterEmail(String email)    {
        $(byId("c_elem_0")).setValue(email);
    }

    public void enterPassword(String password)    {
        $(byId("a_elem_1")).setValue(password);
    }

    public void confirmPassword(String confirmPassword)    {
        $(byId("a_elem_2")).setValue(confirmPassword);
    }

    public void selectJobCorpsCenter(String jobCenter)    {
        $(byId("elem_3")).selectOption(jobCenter);
    }

    public void checkTermsCondition()    {
        $(byXpath("//span[@class='checkbox-custom checkbox-toggle']")).click();
    }

    public void clickCreateAnAccount()    {
        $(byText("Create an account")).click();
    }

    public void fillTheFormAndCreate(String eMail, String password, String confirmPassword, String jobCenter)    {
        enterEmail(eMail);
        enterPassword(password);
        confirmPassword(confirmPassword);
        selectJobCorpsCenter(jobCenter);
        checkTermsCondition();
        clickCreateAnAccount();
    }

}
