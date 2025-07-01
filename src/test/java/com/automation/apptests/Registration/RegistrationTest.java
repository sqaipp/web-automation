package com.automation.apptests.Registration;

import com.automation.dataProviders.ConfigFileReader;
import com.automation.listeners.TestAllureListener;
import com.automation.screen.uicomponent.CheckScreen;
import com.automation.screen.uipages.homepages.homePage;
import com.automation.screen.uipages.login.loginPage;
import com.automation.screen.uipages.registration.registrationPage;
import com.automation.utils.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.AssertJUnit.assertTrue;

@Slf4j
@Listeners({TestAllureListener.class})
public class RegistrationTest extends BaseTest {
    ConfigFileReader ConfigFileReader = new ConfigFileReader();
    registrationPage registrationPage;
    homePage homePage;

    @Title("Registration")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Registration", groups = "Registration", priority = 1)
    public void registrationValid() {
        homePage = new homePage(driver);
        registrationPage = new registrationPage(driver);
        String email = ConfigFileReader.getEmail();
        String password = ConfigFileReader.getPassword();
        String konfirmasiPassword = ConfigFileReader.getPassword();
        // click button masuk for login
        homePage.clickBtnDaftar();
        // Verify registration page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Daftar", 3));
        // input email
        registrationPage.inputEmail(email);
        // input password
        registrationPage.inputPassword(password);
        // input konfirmasi password
        registrationPage.inputKonfirmasiPassword(konfirmasiPassword);
        // klik button daftar sekarang
        registrationPage.clickButtonDaftarSekarang();
    }

    @Title("Registration Confirm Password Wrong")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Registration confirm password wrong", groups = "Registration", priority = 1)
    public void registrationWrongConfirmPass() {
        homePage = new homePage(driver);
        registrationPage = new registrationPage(driver);
        String email = ConfigFileReader.getEmail();
        String password = ConfigFileReader.getPassword();
        // click button masuk for login
        homePage.clickBtnDaftar();
        // Verify registration page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Daftar", 3));
        // input email
        registrationPage.inputEmail(email);
        // input password
        registrationPage.inputPassword(password);
        // input konfirmasi password
        registrationPage.inputKonfirmasiPassword("wrong password !123");
        // klik button daftar sekarang
        registrationPage.clickButtonDaftarSekarang();
        // Verify wrong password confirmation
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Password dan konfirmasi password harus sama!", 3));
    }

    @Title("Registration invalid email")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Registration", groups = "Registration", priority = 1)
    public void registrationEmailNotValid() {
        homePage = new homePage(driver);
        registrationPage = new registrationPage(driver);
        String email = ConfigFileReader.getEmail();
        String password = ConfigFileReader.getPassword();
        String konfirmasiPassword = ConfigFileReader.getPassword();
        // click button masuk for login
        homePage.clickBtnDaftar();
        // Verify registration page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Daftar", 3));
        // input email
        registrationPage.inputInvalidEmail();
        // input password
        registrationPage.inputPassword2(password);
        // input konfirmasi password
        registrationPage.inputKonfirmasiPassword2(konfirmasiPassword);
        // klik button daftar sekarang
        registrationPage.clickButtonDaftarSekarang();
        // Verify failed registrtion invalid email
        assertTrue(
                uiComponent().checkTextScreen()
                                .isEnabledText("Email tidak valid", 5) ||
                        uiComponent().checkTextScreen()
                                .isEnabledText("Silahkan coba lagi, terdeteksi aktivitas ilegal.", 5));
    }
}
