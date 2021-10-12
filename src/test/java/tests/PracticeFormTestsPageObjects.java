package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.firstName;
import static tests.TestData.lastName;

public class PracticeFormTestsPageObjects extends TestBase {

        RegistrationPage registrationPage = new RegistrationPage();

        @Test
        void selenidePracticeTest() {
                registrationPage.openPage();
                registrationPage.typeFirstName(firstName);
                registrationPage.typeLastName(lastName);
                registrationPage.typeEmail();
                registrationPage.typeGender();
                registrationPage.typePhoneNumber();
                registrationPage.calendar.setDate();
                registrationPage.typeSubjectFirst();
                registrationPage.typeSubjectSecond();
                $("#hobbiesWrapper").$(byText("Reading")).click();
                $("#hobbiesWrapper").$(byText("Music")).click();
                $("#uploadPicture").uploadFromClasspath("img/1.png");
                $("#currentAddress").setValue("Moscow, Kalinkina str, 75");
                $("#stateCity-wrapper").$(byText("Select State")).click();
                $("#stateCity-wrapper").$(byText("NCR")).click();
                $("#stateCity-wrapper").$(byText("Select City")).click();
                $("#stateCity-wrapper").$(byText("Delhi")).click();
                $("#submit").click();

                $(".modal-title").shouldHave(text("Thanks for submitting the form"));
                $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                        text("chbmptbnp@kalinkin.ru"), text("Male"), text("4654586274"), text("06 October,1993"),
                        text("Commerce, Economics"), text("Reading, Music"), text("1.png"), text("Moscow, Kalinkina str, 75"), text("NCR Delhi"));
        }
}


