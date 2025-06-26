package com.automation.screen.uipages.homepages;

import com.automation.base.base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;
import static com.automation.utils.BaseTest.ConfigFileReader;


@Slf4j
public class cariTokoPage extends BasePage {

    public cariTokoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "gm-fullscreen-control")
    public WebElement buttonFullscreen;

    @FindBy(id = "hasil")
    public WebElement filedCariToko;

    @FindBy(id = "modal_resi")
    public WebElement buttonSearch;

    @FindBy(className = "transparan")
    public List <WebElement> listResultSearchToko;
    // =====================================================

    public void clickButtonFullscreen() {
        log.info("Clicking on button fullscreen ");
        clickElement(buttonFullscreen);
    }

    public void insertSearchToko() {
        log.info("insert search toko");
        clickElementandSendKeys(filedCariToko, ConfigFileReader.getSearchToko());
    }

    public void clickButtonSearch() {
        log.info("click button search toko");
        clickElement(buttonSearch);
    }

    public void clickResultSearchToko() {
        log.info("click result search toko");
        clickElement(listResultSearchToko.getFirst());
    }

}