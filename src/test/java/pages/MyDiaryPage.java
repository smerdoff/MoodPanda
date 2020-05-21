package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;


public class MyDiaryPage extends BasePage {



    public BasePage openPage() {
        return null;
    }

    public BasePage isPageOpened() {
        $(By.id("ContentPlaceHolderContent_MyMoodPandaNav1_UserStats")).waitUntil(Condition.visible, 30000);
        return this;
    }

    public MyDiaryPage nameValidation(String name, String surname) {
        String actualName = $(".name.pull-left").getText();
        String expectedName = name + " " + surname;
        Assert.assertEquals(actualName, expectedName, "Имя не изменилось или не совпадает с ожидаемым");
        return this;
    }

    public MyDiaryPage enteredTextValidation(String expectedText) {
        String actualText = $(".MoodPostItem.media-content").getText();
        Assert.assertEquals(actualText, expectedText, "текст не введён или не совпадает с ожидаемым");
        return this;
    }

}
