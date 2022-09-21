package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class StellarUserLoginTest {
    private final WebDriver driver;

    private String userEmail;
    private String  userPassword;
    private String  userName;

    private final String useBrowser; // Use "Chrome" or "FireFox"

    public StellarUserLoginTest(String useBrowser) { //String useBrowser
        this.useBrowser = useBrowser;
        this.driver = StellarDriver.initDriver(useBrowser);
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

    @Parameterized.Parameters
    public static Object[] GetData(){
        return new Object[] { "Chrome", "EDGE"};
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void stellarUserLoginLKTest() {
        driver.get(StellarMainPage.pageURL);

        StellarMainPage stellarMainPage = new  StellarMainPage(driver);

        //Открыть страницу логина через ЛК
        stellarMainPage.buttonUserLKClick();

        //Открыть страницу логина, сделать успешеый логин
        StellarPageLogin stellarPageLogin = new StellarPageLogin(driver);

        stellarPageLogin.userLogin(userEmail, userPassword);

        //Проверить, что открылась главная страница

        stellarMainPage.checkMainPageOpenedVisible();

        //Перейти на страницу профиля
        stellarMainPage.buttonUserLKClick();

        //Проверить, что профиль виден
        StellarUserProfile stellarUserProfile = new StellarUserProfile(driver);

        stellarUserProfile.checkUserProfilePageVisible();
    }

    @Test
    public void stellarUserLoginMainLoginTest() {
        driver.get(StellarMainPage.pageURL);

        StellarMainPage stellarMainPage = new  StellarMainPage(driver);

        //Открыть страницу логина через «Войти в аккаунт»
        stellarMainPage.buttonUserMainLoginClick();

        //Открыть страницу логина, сделать успешеый логин
        StellarPageLogin stellarPageLogin = new StellarPageLogin(driver);

        stellarPageLogin.userLogin(userEmail, userPassword);

        //Проверить, что открылась главная страница

        stellarMainPage.checkMainPageOpenedVisible();

        //Перейти на страницу профиля
        stellarMainPage.buttonUserLKClick();

        //Проверить, что профиль виден
        StellarUserProfile stellarUserProfile = new StellarUserProfile(driver);

        stellarUserProfile.checkUserProfilePageVisible();
    }

    @Test
    public void stellarUserLoginRegisterLoginTest() {
        driver.get(StellarPageRegister.pageURL);

        StellarPageRegister stellarPageRegister = new  StellarPageRegister(driver);

        //Открыть страницу логина со чтраницы регистрации
        stellarPageRegister.buttonUserLoginClick();

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
    }

    @Test
    public void stellarUserLoginPasswordRecoveryTest() {
        driver.get(StellarPasswordRecovery.pageURL);

        StellarPasswordRecovery stellarPasswordRecovery = new StellarPasswordRecovery(driver);

        //Открыть страницу логина со страницы восстановления пароля
        stellarPasswordRecovery.buttonUserLoginClick();

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
    }

}
