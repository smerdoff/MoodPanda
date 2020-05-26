package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class EditProfilePage extends BasePage {

    By firstNameField = By.id("ContentPlaceHolderContent_TextBoxFirstname");
    By surnameField = By.id("ContentPlaceHolderContent_TextBoxSurname");
    By confirmMessage = By.id("ContentPlaceHolderContent_MessageSuccess");
    By updateButton = By.id("LinkUpdate");


    @Override
    public BasePage openPage() {
        open("https://moodpanda.com/Account/");
        return this;
    }

    @Override
    public BasePage isPageOpened() {
        $(By.id("ContentPlaceHolderContent_TextBoxNewPassword")).waitUntil(Condition.visible,30000);
        return this;
    }

    public EditProfilePage editName(String name, String surname) {
        $((firstNameField)).click();
        $((firstNameField)).clear();
        $((firstNameField)).sendKeys(name);
        $((surnameField)).click();
        $((surnameField)).clear();
        $((surnameField)).sendKeys(surname);
        $(By.id("ContentPlaceHolderContent_TextBoxNewPassword")).clear();
        $(By.id("ContentPlaceHolderContent_ButtonSave")).click();
        EditProfilePage editProfilePage = new EditProfilePage();
        editProfilePage.isPageOpened();
        return this;
    }

    public EditProfilePage changeMessageValidation() {
        String expectedMessage = "×\n" +
                "Success! Your changes were saved";
        String actualMessage = $((confirmMessage)).getText();
        Assert.assertEquals(actualMessage,expectedMessage, "Сообщение о изменении персональной информации не найдено " +
                "или текст сообщения не соответствует ожидаемому" );
        return this;
    }

    public RateHappinessModal openRateHappinessModal() {
        $(updateButton).click();
        RateHappinessModal rateHappinessModal = new RateHappinessModal();
        rateHappinessModal.isModalOpened();
        return rateHappinessModal;
    }
}
