package ru.yandex.praktikum;

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

    @Parameterized.Parameters
    public static Object[] GetData(){
        return new Object[] {"Chrome", "EDGE"};
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void stellarTabBulkaTest() throws InterruptedException {
        driver.get(StellarMainPage.pageURL);

        StellarMainPage stellarMainPage = new  StellarMainPage(driver);

        //Нажать на закладку Булки
        stellarMainPage.tabBulkaClick();

        //Проверить, что заголовк булки наверху фрэйма
        stellarMainPage.checkHeaderBulkaIsOnTopOfFrame();
    }

    @Test
    public void stellarTabSouceTest() throws InterruptedException {
        driver.get(StellarMainPage.pageURL);

        StellarMainPage stellarMainPage = new  StellarMainPage(driver);

        //Нажать на закладку Соусы
        stellarMainPage.tabSouceClick();

        //Проверить, что заголовк Соусы наверху фрэйма
        stellarMainPage.checkHeaderSouceIsOnTopOfFrame();
    }

    @Test
    public void stellarTabFillingTest() throws InterruptedException {
        driver.get(StellarMainPage.pageURL);

        StellarMainPage stellarMainPage = new  StellarMainPage(driver);

        //Нажать на закладку Начинки
        stellarMainPage.tabFillingClick();

        //Проверить, что заголовк Начинки наверху фрэйма
        stellarMainPage.checkHeaderFillingIsOnTopOfFrame();
    }

}
