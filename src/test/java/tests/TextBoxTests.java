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
    void succesfulFillFormTest_dsl() {    // _dsl даёт возможность вызывать метод за методом

        textBoxPage.openPage()
        .typeUserName(userName)
        .typeUserEmail(userEmail)
        .typeCurrentAddress(currentAddress) //$("[id=currentAddress]").setValue(currentAddress);
        .typePermanentAddress(permanentAddress) //$("[id=permanentAddress]").setValue(permanentAddress);
                .submitFormButton() // клик на кнопку Submit
                .checkField("name", userName)
                .checkField("email", userEmail)
        .checkField("currentAddress", currentAddress)
        .checkField("permanentAddress", permanentAddress);
        //$("[id=output] [id=name]").shouldHave(text(userName));
        //$("[id=output] [id=email]").shouldHave(text(userEmail));
        //$("[id=output] [id=currentAddress]").shouldHave(text(currentAddress));
        //$("[id=output] [id=permanentAddress]").shouldHave(text(permanentAddress));
    }

    @Test
    void onlyRequiredFieldSuccesfulTest2_dsl() {

        textBoxPage.openPage()

        .typeUserName(userName)
        .typeUserEmail(userEmail)
                .submitFormButton()
                .checkField("name", userName)
                .checkField("email", userEmail);
    }

    @Test
    void firstNegativeTest_dsl() {

        textBoxPage.openPage()

        .typeUserName(userName)
        .typeUserEmail(userErrorEmail)
        .typeCurrentAddress(currentAddress)
        .typePermanentAddress(permanentAddress) //$("[id=permanentAddress]").setValue(permanentAddress);
                .submitFormButton()
                .checkUserEmailHasErrorClass(); //$("#userEmail").shouldHave(Condition.cssClass("field-error"));

    }

}
//    @Test
//    void succesfulFillFormTest(){
//
//        open("/text-box");
//
//        typeUserName(userName);
//        typeUserEmail(userEmail);}


