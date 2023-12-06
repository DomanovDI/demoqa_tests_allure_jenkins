import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormTests extends TestBase{

    @Test
    @Tag("remote")
    @Feature("Check modal")
    @Story("Fill form and verify results")
    @Owner("domanovdi")
    @DisplayName("Check form test")
    void automationPracticeFormTest() {
        TestData data = new TestData();

        automationPracticeFormPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setPhoneNumber(data.phoneNumber)
                .setGender(data.sex)
                .setBirthDate(data.day,data.month,data.year)
                .setSubject(data.subject)
                .setHobbies(data.hobbies)
                .setFile(data.fileName)
                .setAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .submit();

        automationPracticeFormPage.verifyResultsModalAppears()
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Student Email", data.email)
                .verifyResult("Gender", data.sex)
                .verifyResult("Mobile", data.phoneNumber)
                .verifyResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                .verifyResult("Subjects", data.subject)
                .verifyResult("Hobbies", data.hobbies)
                .verifyResult("Picture", data.fileName)
                .verifyResult("Address", data.address)
                .verifyResult("State and City", data.state + " " + data.city);
    }
}
