package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static tests.TestData.firstName;
import static tests.TestData.lastName;

public class PracticeFormTestsFaker extends TestBase {
        RegistrationPage registrationPage = new RegistrationPage();
        Faker faker = new Faker();
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                phone = faker.phoneNumber().subscriberNumber(10),
                currentAddress = faker.address().fullAddress();

        @Test
        void selenidePracticeTestFaker() {
                step("Открытие регистрационной формы", () -> {
                        registrationPage.openPage();
                        });
                step("Ввод имени студента", () -> {
                        $("#firstName").setValue(firstName);
                        $("#lastName").setValue(lastName);
                });
                step("Ввод почты студента", () -> {
                        $("#userEmail").setValue(userEmail);
                });
                step("Выбор пола студента", () -> {
                        $("#genterWrapper").$(byText("Male")).click();
                });
                step("Ввод номера телефона студента", () -> {
                        $("#userNumber").setValue(phone);
                });
                step("Ввод даты рождения студента", () -> {
                        $("#dateOfBirthInput").click();
                        registrationPage.calendar.setDate();
                });
                step("Ввод предметов студента", () -> {
                        $("#subjectsInput").setValue("Commerce").pressEnter();
                        $("#subjectsInput").setValue("Eco").pressEnter();
                });
                step("Ввод хобби студента", () -> {
                        $("#hobbiesWrapper").$(byText("Reading")).click();
                        $("#hobbiesWrapper").$(byText("Music")).click();
                });
                step("Загрузка фотографии студента", () -> {
                        $("#uploadPicture").uploadFromClasspath("img/1.png");
                });
                step("Ввод адреса студента", () -> {
                        $("#currentAddress").setValue(currentAddress);
                        $("#stateCity-wrapper").$(byText("Select State")).click();
                        $("#stateCity-wrapper").$(byText("NCR")).click();
                        $("#stateCity-wrapper").$(byText("Select City")).click();
                        $("#stateCity-wrapper").$(byText("Delhi")).click();
                });
                step("Отправка формы", () -> {
                        $("#submit").click();
                });

                step("Проверка формы", () -> {
                        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
                        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                                text(userEmail), text("Male"), text(phone), text("06 October,1993"),
                                text("Commerce, Economics"), text("Reading, Music"), text("1.png"), text(currentAddress), text("NCR Delhi"));
                });


        }
}