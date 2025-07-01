package com.automation.apptests.LoginTest;

import com.automation.screen.uicomponent.CheckScreen;
import com.automation.screen.uipages.desktop.homepages.HomePageDesktop;
import com.automation.utils.BaseTest;
import com.automation.dataProviders.ConfigFileReader;
import com.automation.screen.uipages.desktop.login.LoginPageDesktop;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import com.automation.listeners.TestAllureListener;

import static org.testng.AssertJUnit.assertTrue;

@Slf4j
@Listeners({TestAllureListener.class})
public class LoginTest extends BaseTest {
    com.automation.dataProviders.ConfigFileReader ConfigFileReader = new ConfigFileReader();

    @Title("Login")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Login test valid", groups = "Login", priority = 1)
    public void validLoginTest() throws Exception {
        // click button masuk for login
        homePage.clickBtnMasukForLogin();
        // input username
        loginPage.clickandSendKeysUsername(ConfigFileReader.getUsername());
        // input password
        loginPage.clickandSendKeysPassword(ConfigFileReader.getPassword());
        // click button masuk
        loginPage.clickMasukLogin();
        // Verify that the user is logged in successfully
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getHomePage().buttonProfile, 5));
    }

    @Title("Login")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Login test valid", groups = "Login", priority = 1)
    public void logoutTest() throws Exception {
        // click button masuk for login
        homePage.clickBtnMasukForLogin();
        // input username
        loginPage.clickandSendKeysUsername(ConfigFileReader.getUsername());
        // input password
        loginPage.clickandSendKeysPassword(ConfigFileReader.getPassword());
        // click button masuk
        loginPage.clickMasukLogin();
        // click button Profile
        homePage.clickButtonProfile();
        // click button Logout
        loginPage.clickButtonLogout();
        // click button confirm logout
        loginPage.clickConfirmLogout();
    }

    @Title("Login wrong email / phone number")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Login test using wrong password", groups = "Login", priority = 1)
    public void loginFailureWrongPassword() {
        CheckScreen checkScreen = new CheckScreen(driver);
        // click button masuk for login
        homePage.clickBtnMasukForLogin();
        // input username
        loginPage.clickandSendKeysUsername(ConfigFileReader.getUsername());
        // input password
        loginPage.clickandSendKeysPassword(ConfigFileReader.getWrongPassword());
        // click button masuk
        loginPage.clickMasukLogin();
        // Verify that the user is logged in successfully
        assertTrue(checkScreen.isEnabledText("Email / Telp / Password salah", 10));
    }

    @Title("Login wrong username")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Login test using wrong username", groups = "Login", priority = 1)
    public void loginFailureWrongUsername() throws Exception {
        CheckScreen checkScreen = new CheckScreen(driver);
        // click button masuk for login
        homePage.clickBtnMasukForLogin();
        // input username
        loginPage.clickandSendKeysUsername(ConfigFileReader.getWrongUsername());
        // input password
        loginPage.clickandSendKeysPassword(ConfigFileReader.getPassword());
        // click button masuk
        loginPage.clickMasukLogin();
        // Verify that the user is logged in successfully
        assertTrue(checkScreen.isEnabledText("User login tidak valid", 10));
    }

    @Title("Login using password less than general requirement")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Login test using password less than general requirement", groups = "Login", priority = 1)
    public void loginFailurePasswordLessThan() {
        // click button masuk for login
        homePage.clickBtnMasukForLogin();
        // input username
        loginPage.clickandSendKeysUsername(ConfigFileReader.getUsername());
        // input password
        loginPage.clickandSendKeysPassword(ConfigFileReader.getPasswordLessThan());
        // click button masuk
        loginPage.clickMasukLogin();
        // Verify that the user is logged in successfully
//        assertTrue(checkScreen.isEnabledText("Please lengthen this text", 10));
        loginPage.checkPopupMessage();
    }
}
