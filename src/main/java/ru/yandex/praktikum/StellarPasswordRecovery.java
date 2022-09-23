package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StellarPasswordRecovery {
    private final WebDriver driver;

    public static final String pageURL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final By linkUserLogin = new By.ByXPath(".//*[contains(@href,'/login')]");

    public StellarPasswordRecovery(WebDriver driver){
        this.driver = driver;
    }

    @Step("Нажатие ссылки на логин")
    public void buttonUserLoginClick() {
        WebElement element = driver.findElement(linkUserLogin);
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click();", element);
        element.click();
    }

}
