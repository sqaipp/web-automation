package com.automation.apptests.LoginTest;

import com.automation.screen.uicomponent.CheckScreen;
import com.automation.utils.BaseTest;
import com.automation.dataProviders.ConfigFileReader;
import com.automation.screen.uipages.homepages.homePage;
import com.automation.screen.uipages.login.forgotPasswordPage;
import io.qameta.allure.Description;
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
public class ForgotPasswordTest extends BaseTest {
    ConfigFileReader ConfigFileReader = new ConfigFileReader();
    homePage homePage;
    forgotPasswordPage forgotPasswordPage;

    @Title("Forgot Password")
    @Description("Forgot Password Test")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = "Login", priority = 1)
    public void goToForgotPassword(){
        CheckScreen checkScreen = new CheckScreen(driver);
        homePage = new homePage(driver);
        // click button masuk
        homePage.clickBtnMasukForLogin();
        // click button forgot password
        homePage.clickBtnLupaPassword();
        // Verify that the user is logged in successfully
        assertTrue(checkScreen.isEnabledText("LUPA PASSWORD", 10));
    }

    @Title("Forgot Password Not Found")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Forgot Password Not Found Test", groups = "Login", priority = 1)
    public void forgotPasswordNotFound(){
        CheckScreen checkScreen = new CheckScreen(driver);
        homePage = new homePage(driver);
        forgotPasswordPage = new forgotPasswordPage(driver);
        // click button masuk
        homePage.clickBtnMasukForLogin();
        // click button forgot password
        homePage.clickBtnLupaPassword();
        // Verify that the user is logged in successfully
        assertTrue(checkScreen.isEnabledText("LUPA PASSWORD", 3));
        // insert email
        forgotPasswordPage.inputEmail(ConfigFileReader.getWrongEmail());
        // click button kirim
        forgotPasswordPage.clickButtonKirim();
        // Verify that data is not found
        assertTrue(checkScreen.isEnabledText("Tidak ditemukan", 3));
    }

    @Title("Forgot Password")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Forgot Password Test", groups = "Login", priority = 1)
    public void forgotPassword(){
        CheckScreen checkScreen = new CheckScreen(driver);
        homePage = new homePage(driver);
        forgotPasswordPage = new forgotPasswordPage(driver);
        // click button masuk
        homePage.clickBtnMasukForLogin();
        // click button forgot password
        homePage.clickBtnLupaPassword();
        // Verify that the user is logged in successfully
        assertTrue(checkScreen.isEnabledText("LUPA PASSWORD", 3));
        // insert email
        forgotPasswordPage.inputEmail(ConfigFileReader.getEmailForgotPassword());
        // click button kirim
        forgotPasswordPage.clickButtonKirim();
        // Verify that data is not found
        assertTrue(checkScreen.isEnabledText("Permintaan Berhasil", 3));
    }
}