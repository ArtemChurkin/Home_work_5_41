package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void succesfulFillFormTest() {

        textBoxPage.openPage();

        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);
        textBoxPage.typeCurrentAddress(currentAddress);
        textBoxPage.typePermanentAddress(permanentAddress);
        //$("[id=currentAddress]").setValue(currentAddress);
        //$("[id=permanentAddress]").setValue(permanentAddress);

        textBoxPage.submitFormButton(); // клик на кнопку Submit

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
        textBoxPage.checkField("currentAddress", currentAddress);
        textBoxPage.checkField("permanentAddress", permanentAddress);
        //$("[id=output] [id=name]").shouldHave(text(userName));
        //$("[id=output] [id=email]").shouldHave(text(userEmail));
        //$("[id=output] [id=currentAddress]").shouldHave(text(currentAddress));
        //$("[id=output] [id=permanentAddress]").shouldHave(text(permanentAddress));
    }

    @Test
    void onlyRequiredFieldSuccesfulTest2() {

        textBoxPage.openPage();

        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);

        textBoxPage.submitFormButton();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
    }

    @Test
    void firstNegativeTest() {

        open("/text-box");

        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userErrorEmail);
        textBoxPage.typeCurrentAddress(currentAddress);
        textBoxPage.typePermanentAddress(permanentAddress);
//        $("[id=currentAddress]").setValue(currentAddress);
//        $("[id=permanentAddress]").setValue(permanentAddress);

        textBoxPage.submitFormButton();

        textBoxPage.checkUserEmailHasErrorClass();
        //$("#userEmail").shouldHave(Condition.cssClass("field-error"));
    }

}
//    @Test
//    void succesfulFillFormTest(){
//
//        open("/text-box");
//
//        typeUserName(userName);
//        typeUserEmail(userEmail);}


