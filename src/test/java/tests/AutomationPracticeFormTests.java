package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;

import static testdata.TestData.*;


public class AutomationPracticeFormTests extends TestBase {
    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();


    @Test
    void succesfulFillTest() {

        automationPracticeFormPage.openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(userEmail)
                .typeUserGender(userGender)
                .typeUserNumber(userPhoneNumber)
                .setBirthDay(userBirthDay, userBirthdayMonth, userBirthdayYear)

                .typeSubject(subject)
                .typeHobbie(hobbie)
                .typePicture(picturePath)
                .typeCurrentAddress(currentAddress)

                .stateSelectList()
                .typeState(state)
                .citySelectList()
                .typeCity(city)
                .submitFormButton()

                .resultTable()

                .closeFormButton();
    }

    @Test
    void onlyRequiredFieldSuccesfulTest() {

        automationPracticeFormPage.openPage()

                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(userEmail)
                .typeUserGender(userGender)
                .typeUserNumber(userPhoneNumber)
                .submitFormButton()
                .closeFormButton();

    }

    @Test
    void firstNegativeTest() {
        automationPracticeFormPage.openPage()
                .submitFormButton()
                .checkFirstNameErrorBorder()
                .checkFirstNameErrorIcon();


    }

    @Test
    void secondNegativeTest() {

        automationPracticeFormPage.openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(userErrorEmail)
                .typeUserGender(userGender)
                .typeUserNumber(userPhoneNumber)

                .setBirthDay(userBirthDay, userBirthdayMonth, userBirthdayYear)

                .typeSubject(subject)
                .typeHobbie(hobbie)
                .typePicture(picturePath)
                .typeCurrentAddress(currentAddress)
                .stateSelectList()
                .typeState(state)
                .citySelectList()
                .typeCity(city)
                .submitFormButton()

                .checkEmailErrorBorder()
                .checkEmailErrorIcon();


    }

    @Test
    void thirdNegativeTest() {
        automationPracticeFormPage.openPage()
                .typeFirstName(userFirstName)
                .typeLastName(userLastName)
                .typeUserEmail(userEmail)
                .typeUserGender(userGender)
                .typeUserNumber(userErrorPhoneNumber)

                .setBirthDay(userBirthDay, userBirthdayMonth, userBirthdayYear)

                .typeSubject(subject)
                .typeHobbie(hobbie)
                .typePicture(picturePath)
                .typeCurrentAddress(currentAddress)

                .stateSelectList()
                .typeState(state)
                .citySelectList()
                .typeCity(city)
                .submitFormButton()

                .checkNumberErrorBorder()
                .checkNumberErrorIcon();
    }

}
