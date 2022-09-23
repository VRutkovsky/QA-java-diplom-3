package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class StellarUserProfile {
    private final WebDriver driver;

    public static final String pageURL = "https://stellarburgers.nomoreparties.site/account/profile";
    // Кнопка входа в личный кабинет
    private final By buttonUserLK = new By.ByXPath(".//*[contains(@class,'header__link__3D_hX')]//*[contains(text(),'Личный Кабинет')]");
    // заголовок "Профиль"
    private final By titleUserProfile = new By.ByXPath("//*[contains(text(),'Профиль')]");
    private final By buttonConstructor = new By.ByXPath(".//*[contains(@class,'AppHeader_header')and(@href='/')]");
    private final By buttonExit = new By.ByXPath(".//button[contains(text(),'Выход')]");

    public StellarUserProfile(WebDriver driver){
        this.driver = driver;
        //Страница профиля пользователя
    }

    @Step(" Нажатие кнопки выхода")
    public void buttonUserExitClick() {
        driver.findElement(buttonExit).click();
    }

    @Step(" Нажатие кнопки конструктор")
    public void buttonConstructorClick() {
        driver.findElement(buttonConstructor).click();
    }

    @Step(" Проверка, что видно лэйбл 'Профиль'")
    public void checkUserProfilePageVisible(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(titleUserProfile));

        assertTrue(driver.findElement(titleUserProfile).isDisplayed());
    }

}
