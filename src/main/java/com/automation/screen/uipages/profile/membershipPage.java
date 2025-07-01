package com.automation.screen.uipages.profile;

import com.automation.base.base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;

@Slf4j
public class membershipPage extends BasePage {
    public membershipPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "registerButton")
    public WebElement buttonDaftarMembership;
    @Step("click button daftar membership")
    public void clickButtonDaftarMembership() {
        log.info("click button daftar membership");
        clickElement(buttonDaftarMembership);
    }

    @FindBy(id = "link-apa-itu-si")
    public WebElement buttonPelajariMembership;
    @Step("click button pelajari membership")
    public void clickButtonPelajariMembership() {
        log.info("click button pelajari membership");
        performScroll(0.2);
        clickElement(buttonPelajariMembership);
    }

}