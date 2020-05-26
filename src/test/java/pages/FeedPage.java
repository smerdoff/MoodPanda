package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FeedPage extends BasePage {

    By updateButton = By.id("LinkUpdate");
    By accountButton = By.id("Settings");

    public BasePage openPage() {
        open("https://moodpanda.com/Feed/");
        return this;
    }

    public BasePage isPageOpened() {
        $(byText("Control my privacy")).waitUntil(Condition.visible,30000);
        return this;
    }

    public RateHappinessModal openRateHappinessModal() {
        $(updateButton).click();
        RateHappinessModal rateHappinessModal = new RateHappinessModal();
        rateHappinessModal.isModalOpened();
        return rateHappinessModal;
    }

    public EditProfilePage openEditProfile() {
        $(accountButton).click();
        $(byText("Edit profile")).click();
        EditProfilePage editProfilePage = new EditProfilePage();
        editProfilePage.isPageOpened();
        return editProfilePage;
    }

}
