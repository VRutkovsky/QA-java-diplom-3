package ru.yandex.praktikum;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class StellarPageRegister {
    private final WebDriver driver;

    public static final String pageURL = "https://stellarburgers.nomoreparties.site/register";
    private final By fieldUserEmail = new By.ByXPath(".//*[contains(@class,'input__container')]//*[contains(text(),'Email')]/parent::div/input");
    private final By fieldUserPassword = new By.ByXPath(".//*[contains(@class,'input__container')]//*[contains(text(),'Пароль')]/parent::div/input");
    private final By fieldUserName = new By.ByXPath(".//*[contains(@class,'input__container')]//*[contains(text(),'Имя')]/parent::div/input");
    private final By buttonRegister = new By.ByXPath(".//button[contains(text(),'Зарегистрироваться')]");
    private final By linkUserLogin = new By.ByXPath(".//*[contains(@href,'/login')]");
    private final By messageWrongPassword = new By.ByXPath(".//*[contains(text(),'Некорректный пароль')]");
    //Конструктор
    public StellarPageRegister(WebDriver driver){
        this.driver = driver;
    }

    //Ввод данных для регистрации
    public void userRegister(String userEmail, String userPassword, String userName){

        // Ждать до появления поля Email
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(fieldUserEmail));

        driver.findElement(fieldUserEmail).clear();
        driver.findElement(fieldUserPassword).clear();
        driver.findElement(fieldUserName).clear();

        driver.findElement(fieldUserEmail).sendKeys(userEmail);
        driver.findElement(fieldUserPassword).sendKeys(userPassword);
        driver.findElement(fieldUserName).sendKeys(userName);

        driver.findElement(buttonRegister).click();
    }

    public void checkWrongPasswordMessageVisible(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(messageWrongPassword));

        assertTrue(driver.findElement(messageWrongPassword).isDisplayed());
    }
    // Нажатие ссылки на логин
    public void buttonUserLoginClick() {
        WebElement element = driver.findElement(linkUserLogin);
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click();", element);
        element.click();
    }

}
