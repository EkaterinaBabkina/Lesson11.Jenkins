package pages;

import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
        open("/automation-practice-form");
    }

    public void typeFirstName(String value) {
        $("#firstName").setValue(value);
    }

    public void typeLastName(String value) {
        $("#lastName").setValue(value);
    }

    public void typeEmail() {
        $("#userEmail").setValue("chbmptbnp@kalinkin.ru");
    }

    public void typeGender() {
        $("#genterWrapper").$(byText("Male")).click();
    }

    public void typePhoneNumber() {
        $("#userNumber").setValue("4654586274");
    }

    public void typeSubjectFirst() {
        $("#subjectsInput").setValue("Commerce").pressEnter();
    }

    public void typeSubjectSecond() {
        $("#subjectsInput").setValue("Eco").pressEnter();
    }

}
