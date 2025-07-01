package com.automation.apptests.Registration;

import com.automation.listeners.TestAllureListener;
import com.automation.utils.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static com.automation.utils.GenerateUtils.generateRandomEmail;
import static org.testng.AssertJUnit.assertTrue;

@Slf4j
@Listeners({TestAllureListener.class})
public class RegistrationTest extends BaseTest {

    @Title("Registration")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Registration", groups = "Registration", priority = 1)
    public void registrationValid() {
        String password = ConfigFileReader.getPassword();
        String konfirmasiPassword = ConfigFileReader.getPassword();
        // click button masuk for login
        homePage.clickBtnDaftar();
        // Verify registration page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Daftar", 3));
        // input email
        registrationPage.inputEmail(generateRandomEmail());
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
        registrationPage.inputKonfirmasiPassword(konfirmasiPassword);
        // klik button daftar sekarang
        registrationPage.clickButtonDaftarSekarang();
        // Verify failed registrtion invalid email
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Email tidak valid", 3));
    }
}
