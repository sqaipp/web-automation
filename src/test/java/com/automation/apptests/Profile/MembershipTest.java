package com.automation.apptests.Profile;

import com.automation.apptests.LoginTest.LoginTest;
import com.automation.listeners.TestAllureListener;
import com.automation.screen.uipages.homepages.homePage;
import com.automation.screen.uipages.profile.membershipPage;
import com.automation.screen.uipages.profile.profilePage;
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
public class MembershipTest extends BaseTest {
    LoginTest LoginTest = new LoginTest();
    homePage homePage = new homePage(driver);
    membershipPage membershipPage = new membershipPage(driver);

    @Title("Daftar Membership")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Daftar membership", groups = "Profile", priority = 1)
    public void goToSurvey() throws Exception {
        homePage = new homePage(driver);
        membershipPage = new membershipPage(driver);
        // login
        LoginTest.validLoginTest();
        // click button membership
        homePage.clickButtonProfile();
        // click button daftar membership
        membershipPage.clickButtonDaftarMembership();
    }

    @Title("Pelajari Membership")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Pelajari membership", groups = "Profile", priority = 1)
    public void clickButtonPelajariMembership() throws Exception {
        homePage = new homePage(driver);
        membershipPage = new membershipPage(driver);
        // login
        LoginTest.validLoginTest();
        // click button membership
        homePage.clickButtonProfile();
        // click button daftar membership
        membershipPage.clickButtonPelajariMembership();
        // verify on the pelajari membership
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Seller Idaman?", 3));
    }
}
