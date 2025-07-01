package com.automation.screen.uipages.desktop.registration;

import com.automation.base.BasePage;
import com.automation.screen.uipages.interfaces.registration.RegistrationPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class RegistrationPageDesktop extends BasePage implements RegistrationPage {
    public RegistrationPageDesktop(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    public WebElement fieldEmail;
    @Step("Insert email for registration")
    public void inputEmail(String email) {
        log.info("Insert email for registration");
        clickElementandSendKeys(fieldEmail,email);
    }

    @Step("Insert email for registration")
    public void inputInvalidEmail() {
        log.info("Insert invalid email for registration");
        clickElementandSendKeys(fieldEmail, "invalidEmail");
    }

    @FindBy(id = "password")
    public WebElement fieldPassword;
    public void inputPassword(String password) {
        log.info("Insert password for registration");
        clickElementandSendKeys(fieldPassword, password);
    }

    public void inputPassword2(String password) {
        log.info("Insert password for registration");
//        clickElementandSendKeys(fieldPassword, password);
        typeLikeHumanWithActions(driver, fieldPassword, password);
    }

    @FindBy(id = "konfirmasi_password")
    public WebElement fieldKonfirmasiPassword;
    public void inputKonfirmasiPassword(String konfirmasiPassword) {
        log.info("Insert konfirmasi password for registration");
        typeLikeHumanWithActions(driver, fieldKonfirmasiPassword, konfirmasiPassword);
    }

    public void inputKonfirmasiPassword2(String konfirmasiPassword) {
        log.info("Insert konfirmasi password for registration");
        clickElementandSendKeys(fieldKonfirmasiPassword, konfirmasiPassword);
    }

    @FindBy(id = "submitButton")
    public WebElement buttonDaftarSekarang;
    public void clickButtonDaftarSekarang() {
        log.info("Klik button daftar sekarang for registration");
        clickElement(buttonDaftarSekarang);
    }

}
