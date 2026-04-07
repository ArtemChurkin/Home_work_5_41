package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.userName;

public class TextBoxPage {
    // Elements
    private SelenideElement userNameInput = $("#userName");  // "[id=userName]"
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement currentAddressInput = $("[id=currentAddress]");
    private SelenideElement permanentAddressInput = $("[id=currentAddress]");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResults = $("#utput");


    // Actions
    public void openPage() {
        open("/text-box");
    }

    public void submitFormButton() {
        submitButton.click();
    }

    public void typeUserName(String value) {
        userNameInput.setValue(value);
    }

    public void typeUserEmail(String value){
        userEmailInput.setValue(value);
    }

    public void typeCurrentAddress(String value){
        currentAddressInput.setValue(value);
    }

    public void typePermanentAddress(String value){
        permanentAddressInput.setValue(value);
    }

    public void checkField(String key, String value){
        outputResults.$( byId(key)).shouldHave(text(value)); // $("[id=output]".$("[id=name]").shouldHave(text(userName)) c $("[id=" + key + "]');
    }



}
