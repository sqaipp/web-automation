package com.automation.apptests.Profile;

import com.automation.helpers.LoginSteps;
import com.automation.listeners.TestAllureListener;
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

    @Title("Daftar Membership")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Daftar membership", groups = "Profile", priority = 1)
    public void daftarMembership() {
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // click button membership
        homePage.clickBtnMembership();
        // click button daftar membership
        membershipPage.clickButtonDaftarMembership();
    }

    @Title("Pelajari Membership")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Pelajari membership", groups = "Profile", priority = 1)
    public void clickButtonPelajariMembership() throws Exception {
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // click button membership
        homePage.clickBtnMembership();
        // click button daftar membership
        membershipPage.clickButtonPelajariMembership();
        // verify on the pelajari membership
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Seller Idaman?", 3));
    }
}
