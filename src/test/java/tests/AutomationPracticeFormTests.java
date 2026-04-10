package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;
import static testdata.TestData.*;


public class AutomationPracticeFormTests extends TestBase {
    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();


    @Test
    void succesfulFillTest(){

        automationPracticeFormPage.openPage()//open("/automation-practice-form");
        .typeFirstName(userFirstName) //$("#firstName").setValue(userFirstName);
        .typeLastName(userLastName) //$("#lastName").setValue(userLastName);
        .typeUserEmail(userEmail)//$("#userEmail").setValue(userEmail);
        .typeUserGender(userGender) //$("#genterWrapper").$(byText(userGender)).click();
        .typeUserNumber(userPhoneNumber)
                .setBirthDay(userBirthDay, userBirthdayMonth, userBirthdayYear)

        .typeSubject(subject) //$("#subjectsInput").setValue(subject).pressEnter();
        .typeHobbie(hobbie) //$("#hobbiesWrapper").$(byText(hobbie)).click();
        .typePicture(picturePath) //$("#uploadPicture").uploadFromClasspath(picturePath);
        .typeCurrentAdress(currentAddress) //$("#currentAddress").setValue(currentAddress);

        .stateSelectList()  //$("#state").click();
        .typeState(state)//$("#react-select-3-input").setValue(state).pressEnter();
        .citySelectList()//$("#city").click();
        .typeCity(city) //$("#react-select-4-input").setValue(city).pressEnter();
        .submitFormButton() //$("#submit").click();

        .setCheckModalDialog() //$(".modal-dialog").should(appear);
        .setCheckTitle(titleText)//$("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        .setCheckTable(userFirstName +" " + userLastName) //$(".table-responsive").shouldHave(text(userFirstName +" " + userLastName));
        .setCheckTable(userEmail)//$(".table-responsive").shouldHave(text(userEmail));
        .setCheckTable(userGender)//$(".table-responsive").shouldHave(text(userGender));
        .setCheckTable(userPhoneNumber)//$(".table-responsive").shouldHave(text(userPhoneNumber));
        .setCheckTable(userBirthDay +" " + userBirthdayMonth + "," + userBirthdayYear)//$(".table-responsive").shouldHave(text(userBirthDay +" " + userBirthdayMonth + "," + userBirthdayYear));
        .setCheckTable(subject)//$(".table-responsive").shouldHave(text(subject));
        .setCheckTable(hobbie)//$(".table-responsive").shouldHave(text(hobbie));
        .setCheckTable(pictureName)//$(".table-responsive").shouldHave(text(pictureName));
        .setCheckTable(currentAddress) //$(".table-responsive").shouldHave(text(currentAddress));
        .setCheckTable(state +" " + city)  //$(".table-responsive").shouldHave(text(state +" " + city));

        .closeFormButton(); //$("#closeLargeModal").click();
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
    void firstNegativeTest(){
        automationPracticeFormPage.openPage()
                .submitFormButton() //$("#submit").click();
        //$("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));// проверяю что цвет бордера поменялся на красный
        .checkFirstNameErrorBorder()
//        $("#firstName").shouldHave(cssValue("background-image",
//                "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"
//        ));// проверяю что появилась иконка с восклицательным знаком
        .checkFirstNameErrorIcon();


    }
    @Test
    void secondNegativeTest(){

        automationPracticeFormPage.openPage()    //open("/automation-practice-form");
        .typeFirstName(userFirstName) //$("#firstName").setValue(userFirstName);
        .typeLastName(userLastName)  //$("#lastName").setValue(userLastName);
        .typeUserEmail(userErrorEmail) //  $("#userEmail").setValue(userErrorEmail); // Невалидный адрес почты
        .typeUserGender(userGender)  //  $("#genterWrapper").$(byText(userGender)).click();
        .typeUserNumber(userPhoneNumber)  //$("#userNumber").setValue(userPhoneNumber);

        .setBirthDay(userBirthDay, userBirthdayMonth, userBirthdayYear)

        .typeSubject(subject)
        .typeHobbie(hobbie)
        .typePicture(picturePath)
        .typeCurrentAdress(currentAddress)
        .stateSelectList()
        .typeState(state)
        .citySelectList()
        .typeCity(city)
        .submitFormButton()

        .checkEmailErrorBorder()//$("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)")); // проверяю что цвет бордера поменялся на красный
        .checkEmailErrorIcon();
        //$("#userEmail").shouldHave(cssValue("background-image",
                //"url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
    }
    @Test
    void thirdNegativeTest() {
        automationPracticeFormPage.openPage() //open("/automation-practice-form");
        .typeFirstName(userFirstName) //$("#firstName").setValue(userFirstName);
        .typeLastName(userLastName) //$("#lastName").setValue(userLastName);
        .typeUserEmail(userEmail) //$("#userEmail").setValue(userEmail);
        .typeUserGender(userGender) //$("#genterWrapper").$(byText(userGender)).click();
        .typeUserNumber(userErrorPhoneNumber)

        .setBirthDay(userBirthDay, userBirthdayMonth, userBirthdayYear)

        .typeSubject(subject) //$("#subjectsInput").setValue(subject).pressEnter();
        .typeHobbie(hobbie) //$("#hobbiesWrapper").$(byText(hobbie)).click();
        .typePicture(picturePath) //$("#uploadPicture").uploadFromClasspath(picturePath);
        .typeCurrentAdress(currentAddress) //$("#currentAddress").setValue(currentAddress);

        .stateSelectList()  //$("#state").click();
        .typeState(state)//$("#react-select-3-input").setValue(state).pressEnter();
        .citySelectList()//$("#city").click();
        .typeCity(city) //$("#react-select-4-input").setValue(city).pressEnter();
        .submitFormButton()

        .checkNumberErrorBorder()//$("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)")); // проверяю что цвет бордера поменялся на красный
        .checkNumberErrorIcon();
    }

}
