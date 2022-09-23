package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class StellarMainPage {
    private final WebDriver driver;

    public static final String pageURL = "https://stellarburgers.nomoreparties.site";
    // Кнопка входа в личный кабинет
    private final By divOverlay = new By.ByXPath(".//div[contains(@class,'Modal_modal_overlay__x2ZCr')]");
    private final By buttonUserLK = new By.ByXPath(".//*[@href='/account']");
    // Кнопка логина
    private final By buttonUserLogin = new By.ByXPath(".//button[contains(text(),'Войти в аккаунт')]");
    // заголовок "Соберите бургер"
    private final By titleMainPageBurger = new By.ByXPath("//h1[contains(text(),'Соберите бургер')]");

    private final By titleUserProfile = new By.ByXPath("//*[contains(text(),'Профиль')]");

    private final By tabBar = new By.ByXPath(".//div[contains(@style,'display:')]");
    private final By tabBulka = new By.ByXPath(".//span[contains(text(),'Булки')]/parent::div");
    private final By tabSouce = new By.ByXPath(".//span[contains(text(),'Соусы')]/parent::div");
    private final By tabFilling = new By.ByXPath(".//span[contains(text(),'Начинки')]/parent::div");
    private final By headerBulka = new By.ByXPath(".//h2[contains(text(),'Булки')]");
    private final By frameIngredients = new By.ByXPath(".//h2[contains(text(),'Булки')]/parent::div");
    private final By headerSouce = new By.ByXPath(".//h2[contains(text(),'Соусы')]");
    private final By headerFilling = new By.ByXPath(".//h2[contains(text(),'Начинки')]");
    public StellarMainPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Нажатие кнопки входа в личный кабинет")
    public void buttonUserLKClick() {

        WebElement element = driver.findElement(buttonUserLK);
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click();", element);

        element.click();
    }

    @Step(" Нажатие кнопки логина")
    public void buttonUserMainLoginClick() {
        WebElement element = driver.findElement(buttonUserLogin);
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click();", element);

        element.click();
    }

    @Step(" Нажатие закладки Булки")
    public void tabBulkaClick() throws InterruptedException {
        WebElement element = driver.findElement(tabBulka);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        Thread.sleep(3000);
    }

    @Step(" Нажатие закладки Соусы")
    public void tabSouceClick() throws InterruptedException {
        WebElement element = driver.findElement(tabSouce);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        Thread.sleep(3000);
    }

    @Step(" Нажатие закладки Начинки")
    public void tabFillingClick() throws InterruptedException {
        WebElement element = driver.findElement(tabFilling);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(3000);
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(3000);

    }

    @Step(" Проверка, что видно лэйбл 'Соберите бургер'")
    public void checkMainPageOpenedVisible(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(titleMainPageBurger));

        assertTrue(driver.findElement(titleMainPageBurger).isDisplayed());
    }

    @Step(" Проверка, что видно лэйбл 'Профиль' ")
    public void checkUserProfilePageVisible(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(titleUserProfile));

        assertTrue(driver.findElement(titleUserProfile).isDisplayed());
    }

    @Step(" Проверка, что заголовок 'Булки' находится на верху фрэйма ингридиентов")
    public void checkHeaderBulkaIsOnTopOfFrame(){

        WebElement element = driver.findElement(frameIngredients);
        int frame_top = element.getLocation().getY();

        element = driver.findElement(headerBulka);
        int header_top = element.getLocation().getY();
        int header_height = element.getSize().height;

        assertTrue((header_top >= frame_top)&&(header_top < frame_top + 5 * header_height));
    }

    @Step(" Проверка, что заголовок 'Соусы'  находится на верху фрэйма ингридиентов")
    public void checkHeaderSouceIsOnTopOfFrame(){

        WebElement element = driver.findElement(frameIngredients);
        int frame_top = element.getLocation().getY();

        element = driver.findElement(headerSouce);
        int header_top = element.getLocation().getY();
        int header_height = element.getSize().height;

        //System.out.println(frame_top);
        //System.out.println(header_top);
        //System.out.println(header_height);

        assertTrue((header_top >= frame_top)&&(header_top < frame_top + 5 * header_height));
    }

    @Step(" Проверка, что заголовок 'Начинки'  находится на верху фрэйма ингридиентов")
    public void checkHeaderFillingIsOnTopOfFrame(){
        WebElement element = driver.findElement(frameIngredients);
        int frame_top = element.getLocation().getY();

        element = driver.findElement(headerFilling);
        int header_top = element.getLocation().getY();
        int header_height = element.getSize().height;

        //System.out.println(frame_top);
        //System.out.println(header_top);
        //System.out.println(header_height);

        assertTrue((header_top >= frame_top)&&(header_top < frame_top + 5 * header_height));
    }

}
