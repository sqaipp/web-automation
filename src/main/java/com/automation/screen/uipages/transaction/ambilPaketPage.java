package com.automation.screen.uipages.transaction;

import com.automation.base.base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;

@Slf4j
public class ambilPaketPage extends BasePage {
    public ambilPaketPage(WebDriver driver) {
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