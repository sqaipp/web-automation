package com.automation.screen.uipages.desktop.profile;

import com.automation.base.BasePage;
import com.automation.screen.uipages.interfaces.profile.MembershipPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;

@Slf4j
public class MembershipPageDesktop extends BasePage implements MembershipPage {
    public MembershipPageDesktop(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "registerButton")
    public WebElement buttonDaftarMembership;
    @Step("click button daftar membership")
    public void clickButtonDaftarMembership() {
        log.info("click button daftar membership");
        performScroll(0.2);
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