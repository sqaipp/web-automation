package com.automation.screen.uipages.registration;

import com.automation.base.base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.automation.utils.GenerateUtils.generateRandomEmail;

@Slf4j
public class registrationPage extends BasePage {
    public registrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    public WebElement fieldEmail;
    @Step("Insert email for registration")
    public void inputEmail(String email) {
        log.info("Insert email for registration");
        clickElementandSendKeys(fieldEmail, generateRandomEmail());
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

    @FindBy(id = "konfirmasi_password")
    public WebElement fieldKonfirmasiPassword;
    public void inputKonfirmasiPassword(String konfirmasiPassword) {
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
