package com.automation.apptests.Profile;

import com.automation.apptests.LoginTest.LoginTest;
import com.automation.listeners.TestAllureListener;
import com.automation.screen.uipages.homepages.homePage;
import com.automation.screen.uipages.profile.profilePage;
import com.automation.screen.uipages.profile.riwayatPage;
import com.automation.utils.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.AssertJUnit.assertTrue;

@Slf4j
@Listeners({TestAllureListener.class})
public class SurveyTest extends BaseTest {
    LoginTest LoginTest = new LoginTest();
    homePage homePage = new homePage(driver);
    profilePage profilePage = new profilePage(driver);

    @Title("Survey")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Go to survey page", groups = "Profile", priority = 1)
    public void goToSurvey() throws Exception {
        homePage = new homePage(driver);
        profilePage = new profilePage(driver);
        // login
        LoginTest.validLoginTest();
        // click button profile
        homePage.clickButtonProfile();
        // click button edit profile
        homePage.clickButtonSurveyPengiriman();
        // verify on the profile page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Survei Pengiriman Paket", 3));
    }
}
