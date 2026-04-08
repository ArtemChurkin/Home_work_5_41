package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static testdata.TestData.*;

public class CalendarComponent {
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement yearPicker = $(".react-datepicker__year-select");
    private SelenideElement monthPicker = $(".react-datepicker__month-select");
    private SelenideElement dayPicker = $(".react-datepicker__day.react-datepicker__day--0" + userBirthDay + ":not(.react-datepicker__day--outside-month)");

    public void setBirthDay(String day, String month, String year){
        dateOfBirthInput.click();
        yearPicker.selectOption(userBirthdayYear);
        monthPicker.selectOption(userBirthdayMonth);
        dayPicker.click();
    }
}
