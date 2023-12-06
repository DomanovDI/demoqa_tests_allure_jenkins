package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class AutomationPracticeFormPage {
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String HEADER_TEXT = "Practice Form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneNumberInput = $("#userNumber"),
            genderInput = $("#genterWrapper"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            fileNameLocator = $("#uploadPicture"),
            addressLocator = $("#currentAddress"),
            stateLocator = $("#state"),
            cityLocator = $("#city"),
            submitLocator = $("#submit");

    @Step("Open form page")
    public AutomationPracticeFormPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".main-header").shouldHave(text(HEADER_TEXT));
        return this;
    }

    @Step("Set first name {value}")
    public AutomationPracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Set lastname {value}")
    public AutomationPracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Set date")
    public AutomationPracticeFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day,month,year);
        return this;
    }

    @Step("Verify modal")
    public AutomationPracticeFormPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    @Step("Verify modal results")
    public AutomationPracticeFormPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    @Step("Set user email {value}")
    public AutomationPracticeFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Set user phonenumber {value}")
    public AutomationPracticeFormPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    @Step("Set user gender {value}")
    public AutomationPracticeFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    @Step("Set subject {value}")
    public AutomationPracticeFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Set hobby {value}")
    public AutomationPracticeFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    @Step("Set file")
    public AutomationPracticeFormPage setFile(String value) {
        fileNameLocator.uploadFile(new File("src/test/resources/" + value));
        return this;
    }

    @Step("Set address {value}")
    public AutomationPracticeFormPage setAddress(String value) {
        addressLocator.setValue(value);
        return this;
    }

    @Step("Set state {value}")
    public AutomationPracticeFormPage setState(String value) {
        stateLocator.click();
        $(byText(value)).click();
        return this;
    }

    @Step("Set city {value}")
    public AutomationPracticeFormPage setCity(String value) {
        cityLocator.click();
        $(byText(value)).click();
        return this;
    }

    @Step("Press submit")
    public AutomationPracticeFormPage submit() {
        submitLocator.click();
        return this;
    }
}
