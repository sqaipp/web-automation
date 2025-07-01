package com.automation.screen.uipages.desktop.login;

import com.automation.base.BasePage;
import com.automation.screen.uipages.interfaces.login.ForgotPasswordPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class ForgotPasswordPageDesktop extends BasePage implements ForgotPasswordPage {
    public ForgotPasswordPageDesktop(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "submitButton")
    public WebElement buttonKirim;

    @Step("input email")
    public void inputEmail(String wrongEmail) {
        log.info("input email forgot password");
        clickElementandSendKeys(inputEmail, wrongEmail);
    }
    @Step("click button Kirim")
    public void clickButtonKirim() {
        log.info("click button kirim");
        clickElement(buttonKirim);
    }



}
