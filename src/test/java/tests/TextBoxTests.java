package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static testdata.TestData.*;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void succesfulFillFormTest_dsl() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitFormButton()
                .checkField("name", userName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
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
                .typePermanentAddress(permanentAddress)
                .submitFormButton()
                .checkUserEmailHasErrorClass();

    }

}

