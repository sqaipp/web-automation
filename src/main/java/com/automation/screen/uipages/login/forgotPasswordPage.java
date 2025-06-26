package com.automation.screen.uipages.login;

import com.automation.base.base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Slf4j
public class forgotPasswordPage extends BasePage {
    public forgotPasswordPage(WebDriver driver) {
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
