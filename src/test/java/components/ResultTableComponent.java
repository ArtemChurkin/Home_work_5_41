package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultTableComponent {
    private final SelenideElement modalDialog = $(".modal-dialog");
    private final SelenideElement modalTitle = $(".modal-title");
    private final SelenideElement closeButton = $("#closeLargeModal");

    public ResultTableComponent setCheckModalDialog() {
        modalDialog.shouldBe(visible);

        return this;
    }

    public ResultTableComponent setCheckTitle(String expectedTitle) {
        modalTitle.shouldHave(com.codeborne.selenide.Condition.text(expectedTitle));
        return this;
    }

    public ResultTableComponent setCheckTable(String expectedValue) {
        $$("table tbody tr").findBy(com.codeborne.selenide.Condition.text(expectedValue))
                .shouldBe(visible);
        return this;
    }

    public void closeFormButton() {
        closeButton.click();
    }

}
