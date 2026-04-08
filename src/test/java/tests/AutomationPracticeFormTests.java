package tests;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$;
import static testdata.TestData.*;



public class AutomationPracticeFormTests extends TestBase {
    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @Test
    void succesfulFillTest(){


        automationPracticeFormPage.openPage(); //open("/automation-practice-form");
        automationPracticeFormPage.typeFirstName(userFirstName); //$("#firstName").setValue(userFirstName);
        automationPracticeFormPage.typeLastName(userLastName); //$("#lastName").setValue(userLastName);
        automationPracticeFormPage.typeUserEmail(userEmail); //$("#userEmail").setValue(userEmail);
        automationPracticeFormPage.typeUserGender(userGender); //$("#genterWrapper").$(byText(userGender)).click();
        automationPracticeFormPage.typeUserNumber(userPhoneNumber); //$("#userNumber").setValue(userPhoneNumber);

        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption(userBirthdayMonth);
        $(".react-datepicker__year-select").selectOption(userBirthdayYear);
        $(".react-datepicker__day.react-datepicker__day--0" + userBirthDay + ":not(.react-datepicker__day--outside-month)").click();


        automationPracticeFormPage.typeSubject(subject); //$("#subjectsInput").setValue(subject).pressEnter();
        automationPracticeFormPage.typeHobbie(hobbie); //$("#hobbiesWrapper").$(byText(hobbie)).click();
        automationPracticeFormPage.typePicture(picturePath); //$("#uploadPicture").uploadFromClasspath(picturePath);
        automationPracticeFormPage.typeCurrentAdress(currentAddress); //$("#currentAddress").setValue(currentAddress);

        automationPracticeFormPage.stateSelectList();  //$("#state").click();
        automationPracticeFormPage.typeState(state);//$("#react-select-3-input").setValue(state).pressEnter();
        automationPracticeFormPage.citySelectList();//$("#city").click();
        automationPracticeFormPage.typeCity(city); //$("#react-select-4-input").setValue(city).pressEnter();
        automationPracticeFormPage.submitFormButton(); //$("#submit").click();

        automationPracticeFormPage.setCheckModalDialog(); //$(".modal-dialog").should(appear);
        automationPracticeFormPage.setCheckTitle(titleText); //$("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        automationPracticeFormPage.setCheckTable(userFirstName +" " + userLastName); //$(".table-responsive").shouldHave(text(userFirstName +" " + userLastName));
        automationPracticeFormPage.setCheckTable(userEmail);//$(".table-responsive").shouldHave(text(userEmail));
        automationPracticeFormPage.setCheckTable(userGender);//$(".table-responsive").shouldHave(text(userGender));
        automationPracticeFormPage.setCheckTable(userPhoneNumber);//$(".table-responsive").shouldHave(text(userPhoneNumber));
        automationPracticeFormPage.setCheckTable(userBirthDay +" " + userBirthdayMonth + "," + userBirthdayYear);//$(".table-responsive").shouldHave(text(userBirthDay +" " + userBirthdayMonth + "," + userBirthdayYear));
        automationPracticeFormPage.setCheckTable(subject);//$(".table-responsive").shouldHave(text(subject));
        automationPracticeFormPage.setCheckTable(hobbie);//$(".table-responsive").shouldHave(text(hobbie));
        automationPracticeFormPage.setCheckTable(pictureName);//$(".table-responsive").shouldHave(text(pictureName));
        automationPracticeFormPage.setCheckTable(currentAddress); //$(".table-responsive").shouldHave(text(currentAddress));
        automationPracticeFormPage.setCheckTable(state +" " + city);  //$(".table-responsive").shouldHave(text(state +" " + city));

        automationPracticeFormPage.closeFormButton(); //$("#closeLargeModal").click();
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
        automationPracticeFormPage.openPage();  //open("/automation-practice-form");
        automationPracticeFormPage.submitFormButton(); //$("#submit").click();
        //$("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));// проверяю что цвет бордера поменялся на красный
        automationPracticeFormPage.checkErrorBorder(borderColor, red);
//        $("#firstName").shouldHave(cssValue("background-image",
//                "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"
//        ));// проверяю что появилась иконка с восклицательным знаком
        automationPracticeFormPage.checkErrorIcon();


    }
    @Test
    void secondNegativeTest(){
        open("/automation-practice-form");
        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userErrorEmail); // Невалидный адрес почты
        $("#genterWrapper").$(byText(userGender)).click();
        $("#userNumber").setValue(userPhoneNumber);
        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption(userBirthdayMonth);
        $(".react-datepicker__year-select").selectOption(userBirthdayYear);
        $(".react-datepicker__day.react-datepicker__day--0" + userBirthDay + ":not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbie)).click();
        $("#uploadPicture").uploadFromClasspath(picturePath);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)")); // проверяю что цвет бордера поменялся на красный
        $("#userEmail").shouldHave(cssValue("background-image",
                "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"
        ));
    }
    @Test
    void thirdNegativeTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(userGender)).click();
        $("#userNumber").setValue(userErrorPhoneNumber);  // Невалидный номер
        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption(userBirthdayMonth);
        $(".react-datepicker__year-select").selectOption(userBirthdayYear);
        $(".react-datepicker__day.react-datepicker__day--0" + userBirthDay + ":not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbie)).click();
        $("#uploadPicture").uploadFromClasspath(picturePath);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)")); // проверяю что цвет бордера поменялся на красный
        $("#userNumber").shouldHave(cssValue("background-image",
                "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 12 12' width='12' height='12' fill='none' stroke='%23dc3545'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"
        ));
    }

}
