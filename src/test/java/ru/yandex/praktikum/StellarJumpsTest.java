package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class StellarJumpsTest {
    private final WebDriver driver;
    private String userEmail;
    private String  userPassword;
    private String  userName;

    private final String useBrowser; // Use "Chrome" or "FireFox"

    public StellarJumpsTest(String useBrowser) { //String useBrowser
        this.useBrowser = useBrowser; //"Chrome";
        this.driver = StellarDriver.initDriver(useBrowser);
    }

    @Parameterized.Parameters(name = "Use breowser: {0}")
    public static Object[] GetData(){
        return new Object[] {"Chrome", "EDGE"};
    }

    @Before
    public void userCreate(){
        int i = (int) (Math.random() * 9999);
        userEmail = "Test_User_" + i + "@yandex.ru";
        userPassword = "Password" + i;
        userName = "Ivan" + i;

        System.out.println(userEmail);

        driver.get(StellarPageRegister.pageURL);

        StellarPageRegister stellarPageRegister = new StellarPageRegister(driver);

        stellarPageRegister.userRegister(userEmail, userPassword, userName);
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }

    @Test
    @DisplayName("Тест перехода в ЛК и в конструктор")
    public void stellarUserLoginLKTest() {
        driver.get(StellarPageLogin.pageURL);

        //Открыть страницу логина, сделать успешеый логин
        StellarPageLogin stellarPageLogin = new StellarPageLogin(driver);

        stellarPageLogin.userLogin(userEmail, userPassword);

        //Проверить, что открылась главная страница

        StellarMainPage stellarMainPage = new StellarMainPage(driver);

        stellarMainPage.checkMainPageOpenedVisible();

        //Перейти на страницу профиля
        stellarMainPage.buttonUserLKClick();

        //Проверить, что профиль виден
        StellarUserProfile stellarUserProfile = new StellarUserProfile(driver);

        stellarUserProfile.checkUserProfilePageVisible();

        //Перейти в конструктор
        stellarUserProfile.buttonConstructorClick();

        //Проверить, что открылся конструктор
        stellarMainPage.checkMainPageOpenedVisible();
    }

    @Test
    @DisplayName("Тест логаута")
    public void stellarUserExitTest() {
        driver.get(StellarPageLogin.pageURL);

        //Открыть страницу логина, сделать успешеый логин
        StellarPageLogin stellarPageLogin = new StellarPageLogin(driver);

        stellarPageLogin.userLogin(userEmail, userPassword);


        //Перейти на страницу профиля
        StellarMainPage stellarMainPage = new StellarMainPage(driver);

        stellarMainPage.buttonUserLKClick();

        //Проверить, что профиль виден
        StellarUserProfile stellarUserProfile = new StellarUserProfile(driver);

        stellarUserProfile.checkUserProfilePageVisible();

        //Нажать на кнопку выход
        stellarUserProfile.buttonUserExitClick();

        //Проверить, что перешли на страницу логина
        stellarPageLogin.checkUserLoginTitleVisible();
    }

}
