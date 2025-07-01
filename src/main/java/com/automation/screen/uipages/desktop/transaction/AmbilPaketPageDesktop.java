package com.automation.screen.uipages.desktop.transaction;

import com.automation.base.BasePage;
import com.automation.screen.uipages.interfaces.transaction.AmbilPaketPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class AmbilPaketPageDesktop extends BasePage implements AmbilPaketPage {
    public AmbilPaketPageDesktop(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "proses")
    public WebElement menuProses;
    @Step("Clicking on menu proses")
    public void clickMenuProses() {
        log.info("Clicking on menu proses");
        clickElement(menuProses);
    }

    @FindBy(css = "option[value='DOP']")
    public WebElement chooseProses;
    @Step("Clicking on menu proses")
    public void chooseProses() {
        log.info("Choose menu proses");
        clickElement(chooseProses);
    }

    @FindBy(id = "kode_toko")
    public WebElement fieldKodetoko;
    @Step("click and insert on filed kodetoko")
    public void insertKodetoko(String kodetoko) {
        log.info("click and insert on filed kodetoko");
        clickElementandSendKeys(fieldKodetoko, kodetoko);
    }

    @FindBy(id = "pin")
    public WebElement fieldPin;
    @Step("click and insert on filed pin")
    public void insertPin(String pin) {
        log.info("click and insert on filed pin");
        clickElementandSendKeys(fieldPin, pin);
    }

    @FindBy(xpath = "//*[@id=\"select_generate\"]/center/button")
    public WebElement buttonGenerate;
    @Step("click button generate")
    public void clickButtonGenerate() {
        log.info("click button generate");
        clickElement(buttonGenerate);
    }

}