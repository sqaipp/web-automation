package com.automation.apptests.HomePagesTest;

import com.automation.apptests.LoginTest.LoginTest;
import com.automation.base.base.BasePage;
import com.automation.listeners.TestAllureListener;
import com.automation.screen.uicomponent.CheckScreen;
import com.automation.screen.uipages.homepages.homePage;
import com.automation.utils.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Slf4j
@Listeners({TestAllureListener.class})
public class InformasiTest extends BaseTest {

    homePage homePage;
    LoginTest LoginTest = new LoginTest();
    BasePage BasePage;

    @Title("Tentang kami")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "go to Tentang kami", groups = "Home Page", priority = 1)
    public void tentangKami() throws Exception {
        homePage = new homePage(driver);
        // login
        LoginTest.validLoginTest();
        // click on button tentang kami
        homePage.clickBtnTentangKamiAfterLogin();
        // verify on the page tentang kami
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("TENTANG APLIKASI INDOPAKET", 5));
    }

    @Title("Layanan & Program")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "go to layanan & program", groups = "Home Page", priority = 1)
    public void layananDanProgram() throws Exception {
        homePage = new homePage(driver);
        // login
        LoginTest.validLoginTest();
        // click on button layanan & program
        homePage.clickBtnLayananProgram();
        // verify on the page layanan & program
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Layanan & Program", 3));
    }

    @Title("Tutorial")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "go to Tutorial", groups = "Home Page", priority = 1)
    public void tutorial() throws Exception {
        homePage = new homePage(driver);
        // login
        LoginTest.validLoginTest();
        // click on button tutorial
        homePage.clickBtnTutorial();
        // verify on the page tutorial
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("TUTORIAL", 3));
    }

    @Title("FAQ")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "go to Tutorial", groups = "Home Page", priority = 1)
    public void faq() throws Exception {
        homePage = new homePage(driver);
        // login
        LoginTest.validLoginTest();
        // click on button faq
        homePage.clickBtnFAQ();
        // verify on the page faq
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Frequently Ask Question", 5));
    }

    @Title("Syarat & Ketentuan")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "go to Syarat & Ketentuan", groups = "Home Page", priority = 1)
    public void syaratDanKetentuan() throws Exception {
        homePage = new homePage(driver);
        // login
        LoginTest.validLoginTest();
        // click on button syarat & ketentuan
        homePage.clickBtnSyaratKetentuan();
        // verify on the page syarat & ketentuan
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("SYARAT & KETENTUAN", 3));
    }

    @Title("Kebijakan")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "go to Kebijakan", groups = "Home Page", priority = 1)
    public void kebijakan() throws Exception {
        homePage = new homePage(driver);
        // login
        LoginTest.validLoginTest();
        // click on button kebijakan
        homePage.clickBtnKebijakan();
        // verify on the page kebijakan
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Kebijakan", 3));
    }

    @Title("Verify social media")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify social media", groups = "Home Page", priority = 1)
    public void verifySocialMedia() throws Exception {
        homePage = new homePage(driver);
        BasePage = new BasePage(driver);
        // login
        LoginTest.validLoginTest();
        // scroll to bottom
        BasePage.scrollToEOP();
        // verify instagram
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getHomePage().iconInstagram, 3));
        // print URL Instagram
        homePage.getURLInstagram();
        // verify Facebook
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getHomePage().iconFacebook, 3));
        // print URL Facebook
        homePage.getURLFacebook();
        // verify Tiktok
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getHomePage().iconTiktok, 3));
        // print URL Tiktok
        homePage.getURLTiktok();
        // verify YouTube
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getHomePage().iconYoutube, 3));
        // print URL YouTube
        homePage.getURLYoutube();
        // verify office address
        assertEquals(ConfigFileReader.getOfficeAddress(), homePage.getTextOfficeAddress());
    }

}