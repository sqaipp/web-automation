package com.automation.apptests.HomePagesTest;

import com.automation.apptests.LoginTest.LoginTest;
import com.automation.listeners.TestAllureListener;
import com.automation.screen.uicomponent.CheckScreen;
import com.automation.screen.uipages.homepages.cariTokoPage;
import com.automation.screen.uipages.homepages.homePage;
import com.automation.utils.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

@Slf4j
@Listeners({TestAllureListener.class})
public class CariTokoTest extends BaseTest {

    homePage homePage;
    cariTokoPage cariTokoPage;
    LoginTest LoginTest = new LoginTest();

    @Title("Cari Toko")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Cari Toko", groups = "Home Page", priority = 1)
    public void cariToko() throws Exception {
        homePage = new homePage(driver);
        cariTokoPage = new cariTokoPage(driver);
        // login
        LoginTest.validLoginTest();
        // go to Membership
        homePage.clickBtnCariToko();
        // go to Fullscreen
        cariTokoPage.clickButtonFullscreen();
        // minimize Fullscreen
        cariTokoPage.clickButtonFullscreen();
        // search toko
        cariTokoPage.insertSearchToko();
        // click button search
        cariTokoPage.clickButtonSearch();
        // click result search toko
        cariTokoPage.clickResultSearchToko();
    }
}