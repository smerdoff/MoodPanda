package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RateHappinessModal extends BaseModal {

    By sliderCss = By.cssSelector(".ui-slider-handle");
    By updateButtonCss = By.cssSelector(".ButtonUpdate");
    By goToMyDiaryCSS = By.cssSelector(".ButtonMyDiary");
    By whatsHappeningArea = By.id("TextBoxUpdateMoodTag");

    public RateHappinessModal isModalOpened() {
        $(updateButtonCss).waitUntil(Condition.visible, 30000);
        return this;
    }

    public RateHappinessModal updateMood(int moodRating) {
        $(sliderCss).click();
        int currentMood = 5;
        int difference = moodRating - currentMood;
        Keys arrowValue;
        if (difference > 0) {
            arrowValue = Keys.ARROW_RIGHT;
        } else {
            arrowValue = Keys.ARROW_LEFT;
        }
        for (int i = 0; i<Math.abs(difference); i++) {
            $(sliderCss).sendKeys(arrowValue);
        }
        return this;
    }

    public RateHappinessModal enterWhatsHappening (String text) {
        $(whatsHappeningArea).click();
        $(whatsHappeningArea).sendKeys(text);
        return this;
    }
    public RateHappinessModal clickUpdate () {
        $(updateButtonCss).click();
        return this;
    }

    public MyDiaryPage goToMyDiary() {
        $(goToMyDiaryCSS).click();
        MyDiaryPage myDiaryPage = new MyDiaryPage();
        myDiaryPage.isPageOpened();
        return myDiaryPage;
    }
}
