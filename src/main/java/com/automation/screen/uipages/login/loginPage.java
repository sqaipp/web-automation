package com.automation.screen.uipages.login;

import com.automation.base.base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;

@Slf4j
public class loginPage extends BasePage {
    public loginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    public WebElement usernameLogin;
    @Step("Clicking on User Name for Login")
    public void clickandSendKeysUsername(String username) throws InterruptedException {
        log.info("Clicking Username for Login: {}",username);
        clickElementandClear(usernameLogin);
        loadingWait(2);
        clickElementandSendKeys(usernameLogin,username);
    }

    @FindBy(id = "password")
    public WebElement passwordLogin;
    @Step("Clicking on User Name for Login")
    public void clickandSendKeysPassword(String password) {
        log.info("Clicking Username for Login");
        clickElementandSendKeys(passwordLogin,password);
    }

    @FindBy(id = "submitButton")
    public WebElement buttonMasuk;
    public void clickMasukLogin() {
        log.info("Clicking Button Masuk");
        clickElement(buttonMasuk);
    }

    @FindBy(id = "logoutButton")
    public WebElement buttonLogout;
    public void clickButtonLogout() {
        log.info("Clicking Button Logout");
        clickElement(buttonLogout);
    }

    @FindBy(className = "swal2-confirm")
    public WebElement buttonConfirmLogout;
    public void clickConfirmLogout() {
        log.info("Click button confirm logout");
        clickElement(buttonConfirmLogout);
    }

    public void checkPopupMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String validationMessage = (String) js.executeScript(
                "return arguments[0].validationMessage;", passwordLogin);
        loadingWait(5);
        System.out.println("Validation Message: " + validationMessage);
        Assert.assertTrue(validationMessage.contains("6 characters or more"));
    }
}