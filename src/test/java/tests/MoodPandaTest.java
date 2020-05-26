package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class MoodPandaTest extends BaseTest {
    @Test(description = "Проверка входа в проект и работы Update mood")
    @Description("Проверка входа в проект и работы Update mood")
    public void login() {
        loginPage
                .openPage()
                .login("owissemme-1240@yopmail.com", "password")
                .openRateHappinessModal()
                .updateMood(8)
                .clickUpdate()
                .goToMyDiary();
    }

    @Test(description = "Проверка добавления текста в текстовое поле в Update mood")
    @Description("Проверка добавления текста в текстовое поле в Update mood")
    public void addText() {
       String text = "Nothing happens";
        loginPage
                .openPage()
                .login("owissemme-1240@yopmail.com", "password")
                .openRateHappinessModal()
                .updateMood(4)
                .enterWhatsHappening(text)
                .clickUpdate()
                .goToMyDiary()
                .enteredTextValidation(text);
    }

    @Test(description = "Проверка появления сообщения после изменений")
    @Description("Проверка появления сообщения после изменений")
    public void editMessageAppears() {
        loginPage
                .openPage()
                .login("owissemme-1240@yopmail.com", "password")
                .openEditProfile()
                .editName("Eug", "S")
                .changeMessageValidation();
    }

    @Test(description = "Проверка изменения имени")
    @Description("Проверка изменения имени")
    public void changeName() {
        String name = "Eugene";
        String surname = "S";
        loginPage
                .openPage()
                .login("owissemme-1240@yopmail.com", "password")
                .openEditProfile()
                .editName(name, surname)
                .openRateHappinessModal()
                .updateMood(6)
                .enterWhatsHappening("Nothing happens")
                .clickUpdate()
                .goToMyDiary()
                .nameValidation(name,surname);
    }
}
