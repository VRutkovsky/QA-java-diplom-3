package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class StellarPageLogin {
    private final WebDriver driver;

    public static final String pageURL = "https://stellarburgers.nomoreparties.site/login";
    // Кнопка входа в личный кабинет
    private final By buttonUserLK = new By.ByXPath(".//*[contains(@class,'header__link__3D_hX')]//*[contains(text(),'Личный Кабинет')]");
    // ссылка на форму регистрации нового пользователя
    private final By linkUserRegister = new By.ByXPath(".//*[contains(@href,'/register')]");

    private final By titleUserLogin = new By.ByXPath("//h2[contains(text(),'Вход')]");
    private final By fieldUserEmail = new By.ByXPath(".//*[contains(@class,'input__container')]//*[contains(text(),'Email')]/parent::div/input");
    private final By fieldUserPassword = new By.ByXPath(".//*[contains(@class,'input__container')]//*[contains(text(),'Пароль')]/parent::div/input");
    private final By buttonLogin = new By.ByXPath(".//button[contains(text(),'Войти')]");
    // заголовок "Профиль"
    private final By titleUserProfile = new By.ByXPath("//*[contains(text(),'Профиль')]");


    public StellarPageLogin(WebDriver driver) {
        this.driver = driver;
    }

    @Step(" Нажатие кнопки входа в личный кабинет")
    public void buttonUserLKClick() {
        driver.findElement(buttonUserLK).click();
    }

    @Step(" Нажатие линка регистрации нового пользователя")
    public void linkUserRegisterClick() {
        driver.findElement(linkUserRegister).click();
    }
    @Step(" Проверка, что видно лэйбл 'Вход'")
    public void checkUserLoginTitleVisible(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(titleUserLogin));

        assertTrue(driver.findElement(titleUserLogin).isDisplayed());
    }

    @Step("User Login Step")
    public void userLogin(String userEmail, String userPassword){

        // Ждать до появления поля Email
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(fieldUserEmail));

        driver.findElement(fieldUserEmail).clear();
        driver.findElement(fieldUserPassword).clear();

        driver.findElement(fieldUserEmail).sendKeys(userEmail);
        driver.findElement(fieldUserPassword).sendKeys(userPassword);

        WebElement element = driver.findElement(buttonLogin);
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click();", element);
        element.click();
    }

    @Step(" Проверка, что видно лэйбл 'Профиль'")
    public void checkUserProfilePageVisible(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(titleUserProfile));

        assertTrue(driver.findElement(titleUserProfile).isDisplayed());
    }

}
