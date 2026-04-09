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

        automationPracticeFormPage.openPage();
        //$("#firstName").setValue(userFirstName);
        automationPracticeFormPage.typeFirstName(userFirstName);
        //$("#lastName").setValue(userLastName);
        automationPracticeFormPage.typeLastName(userLastName);
        //$("#userEmail").setValue(userEmail);
        automationPracticeFormPage.typeUserEmail(userEmail);
        //$("#genterWrapper").$(byText(userGender)).click();
        automationPracticeFormPage.typeUserGender(userGender);
        //$("#userNumber").setValue(userPhoneNumber);
        automationPracticeFormPage.typeUserNumber(userPhoneNumber);
        automationPracticeFormPage.submitFormButton();
        automationPracticeFormPage.closeFormButton();
//        open("/automation-practice-form");
//        $("#firstName").setValue(userFirstName);
//        $("#lastName").setValue(userLastName);
//        $("#userEmail").setValue(userEmail);
//        $("#genterWrapper").$(byText(userGender)).click();
//        $("#userNumber").setValue(userPhoneNumber);
//        $("#submit").click();
//        $("#closeLargeModal").click();
    }
    @Test
    void firstNegativeTest(){
        automationPracticeFormPage.openPage();//open("/automation-practice-form");

        automationPracticeFormPage.submitFormButton(); //$("#submit").click();
        //$("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));// проверяю что цвет бордера поменялся на красный
        automationPracticeFormPage.checkFirstNameErrorBorder();
//        $("#firstName").shouldHave(cssValue("background-image",
//                "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"
//        ));// проверяю что появилась иконка с восклицательным знаком
        automationPracticeFormPage.checkFirstNameErrorIcon();


    }
    @Test
    void secondNegativeTest(){

        automationPracticeFormPage.openPage();     //open("/automation-practice-form");
        automationPracticeFormPage.typeFirstName(userFirstName); //$("#firstName").setValue(userFirstName);
        automationPracticeFormPage.typeLastName(userLastName);  //$("#lastName").setValue(userLastName);
        automationPracticeFormPage.typeUserEmail(userErrorEmail); //  $("#userEmail").setValue(userErrorEmail); // Невалидный адрес почты
        automationPracticeFormPage.typeUserGender(userGender);  //  $("#genterWrapper").$(byText(userGender)).click();
        automationPracticeFormPage.typeUserNumber(userPhoneNumber);  //$("#userNumber").setValue(userPhoneNumber);

        automationPracticeFormPage.setBirthDay(userBirthDay, userBirthdayMonth, userBirthdayYear); //$("#dateOfBirthInput").click();
//      $(".react-datepicker__month-select").selectOption(userBirthdayMonth);
//        $(".react-datepicker__year-select").selectOption(userBirthdayYear);
//        $(".react-datepicker__day.react-datepicker__day--0" + userBirthDay + ":not(.react-datepicker__day--outside-month)").click();

        automationPracticeFormPage.typeSubject(subject);//$("#subjectsInput").setValue(subject).pressEnter();
        automationPracticeFormPage.typeHobbie(hobbie); //$("#hobbiesWrapper").$(byText(hobbie)).click();
        automationPracticeFormPage.typePicture(picturePath); //$("#uploadPicture").uploadFromClasspath(picturePath);
        automationPracticeFormPage.typeCurrentAdress(currentAddress); //$("#currentAddress").setValue(currentAddress);
        automationPracticeFormPage.stateSelectList();  //$("#state").click();
        automationPracticeFormPage.typeState(state);//$("#react-select-3-input").setValue(state).pressEnter();
        automationPracticeFormPage.citySelectList();//$("#city").click();
        automationPracticeFormPage.typeCity(city); //$("#react-select-4-input").setValue(city).pressEnter();
        automationPracticeFormPage.submitFormButton();

        automationPracticeFormPage.checkEmailErrorBorder();//$("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)")); // проверяю что цвет бордера поменялся на красный
        automationPracticeFormPage.checkEmailErrorIcon();
        //$("#userEmail").shouldHave(cssValue("background-image",
                //"url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"));
    }
    @Test
    void thirdNegativeTest() {
        automationPracticeFormPage.openPage(); //open("/automation-practice-form");
        automationPracticeFormPage.typeFirstName(userFirstName); //$("#firstName").setValue(userFirstName);
        automationPracticeFormPage.typeLastName(userLastName); //$("#lastName").setValue(userLastName);
        automationPracticeFormPage.typeUserEmail(userEmail); //$("#userEmail").setValue(userEmail);
        automationPracticeFormPage.typeUserGender(userGender); //$("#genterWrapper").$(byText(userGender)).click();
        automationPracticeFormPage.typeUserNumber(userErrorPhoneNumber);

        automationPracticeFormPage.setBirthDay(userBirthDay, userBirthdayMonth, userBirthdayYear);

        automationPracticeFormPage.typeSubject(subject); //$("#subjectsInput").setValue(subject).pressEnter();
        automationPracticeFormPage.typeHobbie(hobbie); //$("#hobbiesWrapper").$(byText(hobbie)).click();
        automationPracticeFormPage.typePicture(picturePath); //$("#uploadPicture").uploadFromClasspath(picturePath);
        automationPracticeFormPage.typeCurrentAdress(currentAddress); //$("#currentAddress").setValue(currentAddress);

        automationPracticeFormPage.stateSelectList();  //$("#state").click();
        automationPracticeFormPage.typeState(state);//$("#react-select-3-input").setValue(state).pressEnter();
        automationPracticeFormPage.citySelectList();//$("#city").click();
        automationPracticeFormPage.typeCity(city); //$("#react-select-4-input").setValue(city).pressEnter();
        automationPracticeFormPage.submitFormButton();

        automationPracticeFormPage.checkNumberErrorBorder();//$("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)")); // проверяю что цвет бордера поменялся на красный
        automationPracticeFormPage.checkNumberErrorIcon();
    }

}
