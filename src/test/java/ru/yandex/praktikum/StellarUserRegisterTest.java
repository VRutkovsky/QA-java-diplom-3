package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class StellarUserRegisterTest {
    private final WebDriver driver;

    private final String useBrowser; // Use "Chrome" or "FireFox"

    public StellarUserRegisterTest(String useBrowser) { //String useBrowser
        this.useBrowser = useBrowser;
        this.driver = StellarDriver.initDriver(useBrowser);
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }

    @Parameterized.Parameters(name = "Use breowser: {0}")
    public static Object[] GetData(){
        return new Object[] {"Chrome", "EDGE"};
    }

    @Test
    public void stellarUserRegisterPositiveTest(){
        int i = (int) (Math.random() * 9999);
        String userEmail = "Test_User_" + i + "@yandex.ru";
        String userPassword = "Password" + i;
        String userName = "Ivan" + i;

        driver.get(StellarPageRegister.pageURL);

        StellarPageRegister stellarPageRegister = new StellarPageRegister(driver);

        stellarPageRegister.userRegister(userEmail, userPassword, userName);

        driver.get(StellarPageLogin.pageURL);

        StellarPageLogin stellarPageLogin = new StellarPageLogin(driver);

        stellarPageLogin.checkUserLoginTitleVisible();
    }

    @Test
    public void stellarUserRegisterWrongPasswordTest(){
        int i = (int) (Math.random() * 9999);
        String userEmail = "Test_User_" + i + "@yandex.ru";
        String userPassword = "ttt";
        String userName = "Ivan" + i;

        driver.get(StellarPageRegister.pageURL);

        StellarPageRegister stellarPageRegister = new StellarPageRegister(driver);

        stellarPageRegister.userRegister(userEmail, userPassword, userName);

        stellarPageRegister.checkWrongPasswordMessageVisible();
    }

}
