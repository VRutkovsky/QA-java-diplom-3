package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;


@RunWith(Parameterized.class)
public class StellarContructorTest {
    private final WebDriver driver;

    private final String useBrowser; // Use "Chrome" or "FireFox"

    public StellarContructorTest(String useBrowser) { //String useBrowser
        this.useBrowser = useBrowser; //"Chrome";
        this.driver = StellarDriver.initDriver(useBrowser);
    }

    @Parameterized.Parameters(name = "Use breowser: {0}")
    public static Object[] GetData(){
        return new Object[] {"Chrome", "EDGE"};
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }

    @Test
    @DisplayName("Тест нажатия на закладку Булки")
    public void stellarTabBulkaTest() throws InterruptedException {
        driver.get(StellarMainPage.pageURL);

        StellarMainPage stellarMainPage = new  StellarMainPage(driver);

        //Нажать на закладку Булки
        stellarMainPage.tabBulkaClick();

        //Проверить, что заголовк булки наверху фрэйма
        stellarMainPage.checkHeaderBulkaIsOnTopOfFrame();
    }

    @Test
    @DisplayName("Тест нажатия на закладку Соусы")
    public void stellarTabSouceTest() throws InterruptedException {
        driver.get(StellarMainPage.pageURL);

        StellarMainPage stellarMainPage = new  StellarMainPage(driver);

        //Нажать на закладку Соусы
        stellarMainPage.tabSouceClick();

        //Проверить, что заголовк Соусы наверху фрэйма
        stellarMainPage.checkHeaderSouceIsOnTopOfFrame();
    }

    @Test
    @DisplayName("Тест нажатия на закладку Начинки")
    public void stellarTabFillingTest() throws InterruptedException {
        driver.get(StellarMainPage.pageURL);

        StellarMainPage stellarMainPage = new  StellarMainPage(driver);

        //Нажать на закладку Начинки
        stellarMainPage.tabFillingClick();

        //Проверить, что заголовк Начинки наверху фрэйма
        stellarMainPage.checkHeaderFillingIsOnTopOfFrame();
    }

}
