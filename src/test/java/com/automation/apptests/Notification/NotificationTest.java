package com.automation.apptests.Notification;

import com.automation.apptests.LoginTest.LoginTest;
import com.automation.listeners.TestAllureListener;
import com.automation.screen.uicomponent.CheckScreen;
import com.automation.screen.uipages.homepages.homePage;
import com.automation.screen.uipages.profile.profilePage;
import com.automation.utils.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;
import static org.testng.AssertJUnit.assertTrue;

@Slf4j
@Listeners({TestAllureListener.class})
public class NotificationTest extends BaseTest {
    LoginTest LoginTest = new LoginTest();
    homePage homePage = new homePage(driver);
    profilePage profilePage = new profilePage(driver);

    @Title("Notification test")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "go to notification", groups = "Profile", priority = 1)
    public void goToNotificationTest() throws Exception {
        homePage = new homePage(driver);
        profilePage = new profilePage(driver);
        // login
        LoginTest.validLoginTest();
        // click button notofication
        homePage.clickButtonNotification();
        // verify if the notification popup is appearing
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Notifikasi", 3));
    }

    @Title("Go to detil info & promo test")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Go to detil info & promo test", groups = "Profile", priority = 1)
    public void goToDetilInfoPromoTest() throws Exception {
        homePage = new homePage(driver);
        profilePage = new profilePage(driver);
        // login
        LoginTest.validLoginTest();
        // click button notofication
        homePage.clickButtonNotification();
        // verify if the notification popup is appearing
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Notifikasi", 3));
        // click button info & promo
        homePage.clickButtonInfoPromo();
        // click button detil notification
        homePage.clickButtonDetilNotification();
    }

    @Title("Go to status paket test")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Go to status paket test", groups = "Profile", priority = 1)
    public void goToStatusPaketTest() throws Exception {
        homePage = new homePage(driver);
        profilePage = new profilePage(driver);
        // login
        LoginTest.validLoginTest();
        // click button notofication
        homePage.clickButtonNotification();
        // verify if the notification popup is appearing
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Notifikasi", 3));
        // click button status paket
        homePage.clickButtonSTatusPaket();
    }

    @Title("Delete notification")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Delete notification", groups = "Profile", priority = 1)
    public void  deleteNotification() throws Exception {
        homePage = new homePage(driver);
        profilePage = new profilePage(driver);
        // login
        LoginTest.validLoginTest();
        // click button notofication
        homePage.clickButtonNotification();
        // verify if the notification popup is appearing
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Notifikasi", 3));
        // click button info & promo
        homePage.clickButtonInfoPromo();
        // click checkbox notification
        homePage.clickCheckboxNotification();
        // click button delete notification
        homePage.clickButtonDeleteNotification();
        // verify delete notification
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Yakin menghapus notifikasi?", 3));
        // click button confirm delete notification
        homePage.clickButtonConfirmDeleteNotification();
        // verify success delete notification
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Berhasil menghapus notifikasi", 3));
        // click button OK for success delete notification
        homePage.clickButtonSuccessDeleteNotification();
    }

    @Title("Show all notification")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Show all notification", groups = "Profile", priority = 1)
    public void  showAllNotification() throws Exception {
        homePage = new homePage(driver);
        profilePage = new profilePage(driver);
        // login
        LoginTest.validLoginTest();
        // click button notification
        homePage.clickButtonNotification();
        // click button show all notification
        homePage.clickButtonLihatSemuaNotifikasi();
        // verify if the notification popup is appearing
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Notifikasi", 3));

    }

}
