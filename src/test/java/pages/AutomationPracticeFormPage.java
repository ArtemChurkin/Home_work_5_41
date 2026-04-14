package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.ResultTableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;


public class AutomationPracticeFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    // Elements
    private SelenideElement firstNameInput = $("#firstName");  // "[id=firstName]"
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement userGenderRadioButton = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement userSubjectsInput = $("#subjectsInput");
    private SelenideElement userHobbiesCheckBox = $("#hobbiesWrapper");
    private SelenideElement userPictureUpload = $("#uploadPicture");
    private SelenideElement userCurrentAddressInput = $("#currentAddress");
    private SelenideElement stateSelectList = $("#state");
    private SelenideElement stateChoose = $("#react-select-3-input");
    private SelenideElement citySelectList = $("#city");
    private SelenideElement cityChoose = $("#react-select-4-input");
    private SelenideElement submitButton = $("#submit");

    private SelenideElement closeButton = $("#closeLargeModal");

    // Actions
    public AutomationPracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);



        return this;
    }

    public AutomationPracticeFormPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public AutomationPracticeFormPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public AutomationPracticeFormPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public AutomationPracticeFormPage typeUserGender(String value) {
        userGenderRadioButton.$(byText(value)).click();

        return this;
    }

    public AutomationPracticeFormPage typeUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public AutomationPracticeFormPage setBirthDay(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setBirthDay(day, month, year);

        return this;
    }

    public AutomationPracticeFormPage typeSubject(String value) {
        userSubjectsInput.setValue(value).pressEnter();

        return this;
    }

    public AutomationPracticeFormPage typeHobbie(String value) {
        userHobbiesCheckBox.$(byText(value)).click();

        return this;
    }

    public AutomationPracticeFormPage typePicture(String value) {
        userPictureUpload.uploadFromClasspath(value);

        return this;
    }

    public AutomationPracticeFormPage typeCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);

        return this;
    }

    public AutomationPracticeFormPage stateSelectList() {
        stateSelectList.click();

        return this;
    }

    public AutomationPracticeFormPage citySelectList() {
        citySelectList.click();

        return this;
    }

    public AutomationPracticeFormPage submitFormButton() {
        submitButton.click();

        return this;
    }

    public AutomationPracticeFormPage closeFormButton() {
        closeButton.click();

        return this;
    }

    public AutomationPracticeFormPage typeState(String value) {
        stateChoose.setValue(value).pressEnter();

        return this;
    }

    public AutomationPracticeFormPage typeCity(String value) {
        cityChoose.setValue(value).pressEnter();

        return this;
    }

    public ResultTableComponent resultTable() {
        return resultTableComponent;
    }

    public AutomationPracticeFormPage checkFirstNameErrorBorder() {
        firstNameInput.shouldHave(cssValue(borderColor, red));

        return this; //
    }

    public AutomationPracticeFormPage checkEmailErrorBorder() {
        userEmailInput.shouldHave(cssValue(borderColor, red));

        return this;
    }

    public AutomationPracticeFormPage checkNumberErrorBorder() {
        userNumberInput.shouldHave(cssValue(borderColor, red));

        return this;
    }

    public AutomationPracticeFormPage checkFirstNameErrorIcon() {
        firstNameInput.shouldHave(cssValue(backroundImage, errorIcon));

        return this;

    }

    public AutomationPracticeFormPage checkEmailErrorIcon() {
        userEmailInput.shouldHave(cssValue(backroundImage,
                errorIcon));

        return this;

    }

    public AutomationPracticeFormPage checkNumberErrorIcon() {
        userNumberInput.shouldHave(cssValue(backroundImage,
                errorIcon));

        return this;
    }


}
