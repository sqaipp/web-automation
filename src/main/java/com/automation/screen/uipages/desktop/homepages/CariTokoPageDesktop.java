package com.automation.screen.uipages.desktop.homepages;

import com.automation.base.BasePage;
import com.automation.screen.uipages.interfaces.home.CariTokoPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.automation.utils.BaseTest.ConfigFileReader;


@Slf4j
public class CariTokoPageDesktop extends BasePage implements CariTokoPage {

    public CariTokoPageDesktop(WebDriver driver) {
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