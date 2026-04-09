package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;


public class AutomationPracticeFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
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
    private SelenideElement checkModalDialog = $(".modal-dialog");
    private SelenideElement checkTitle = $("#example-modal-sizes-title-lg");
    private SelenideElement fieldTable = $(".table-responsive");

    private SelenideElement closeButton = $("#closeLargeModal");

    // Actions
    public void openPage() {open("/automation-practice-form");
    }
    public void typeFirstName (String value){
        firstNameInput.setValue(value);
    }
    public void typeLastName(String value){
        lastNameInput.setValue(value);
    }
    public void typeUserEmail(String value){
        userEmailInput.setValue(value);
    }
    public void typeUserGender(String value){
        userGenderRadioButton.$(byText(value)).click();
    }
    public void typeUserNumber (String value){
        userNumberInput.setValue(value);
    }
    public void setBirthDay(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setBirthDay( day, month, year);
    }
    public void typeSubject (String value){
        userSubjectsInput.setValue(value).pressEnter();
    }
    public void typeHobbie (String value){
        userHobbiesCheckBox.$(byText(value)).click();
    }
    public void typePicture (String value){
        userPictureUpload.uploadFromClasspath(value);
    }
    public void typeCurrentAdress (String value){
        userCurrentAddressInput.setValue(value);
    }
    public void stateSelectList() {
        stateSelectList.click();
    }
    public void citySelectList() {
        citySelectList.click();
    }
    public void submitFormButton() {
        submitButton.click();
    }
    public void closeFormButton() {
        closeButton.click();
    }
    public void typeState(String value) {
        stateChoose.setValue(value).pressEnter();
    }
    public void typeCity(String value) {
        cityChoose.setValue(value).pressEnter();
    }
    public void setCheckModalDialog (){
        checkModalDialog.should(appear);
    }
    public void setCheckTitle (String value){
        checkTitle.shouldHave(text(value));
    }
    public void setCheckTable (String value){
        fieldTable.shouldHave(text(value));}
    public void checkFirstNameErrorBorder() {
        firstNameInput.shouldHave(cssValue(borderColor, red)); //
    }
    public void checkEmailErrorBorder() {
        userEmailInput.shouldHave(cssValue(borderColor, red));
    }
        public void checkNumberErrorBorder() {
            userNumberInput.shouldHave(cssValue(borderColor, red));
    }
    public void checkFirstNameErrorIcon(){
        firstNameInput.shouldHave(cssValue(backroundImage,
                errorIcon));
    }
    public void checkEmailErrorIcon(){
        userEmailInput.shouldHave(cssValue(backroundImage,
                errorIcon));
    }
    public void checkNumberErrorIcon(){
        userNumberInput.shouldHave(cssValue(backroundImage,
                errorIcon));
    }


}
