package com.automation.apptests.Profile;

import com.automation.apptests.LoginTest.LoginTest;
import com.automation.helpers.LoginSteps;
import com.automation.listeners.TestAllureListener;
import com.automation.screen.uicomponent.CheckScreen;
import com.automation.screen.uipages.desktop.homepages.HomePageDesktop;
import com.automation.screen.uipages.desktop.profile.ProfilePageDesktop;
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
public class ProfileTest extends BaseTest {

    @Title("Profile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Edit profile", groups = "Profile", priority = 1)
    public void editProfileTest() throws Exception {
        CheckScreen checkScreen = new CheckScreen(driver);
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // click button profile
        homePage.clickButtonProfile();
        // click button edit profile
        homePage.clickDropdownMenuEditProfile();
        // verify on the profile page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getHomePage().buttonEditProfile, 3));
        loadingWait(5);
        // click on button edit profile
        profilePage.clickButtonEditProfile();
        // set insert nama pengirim
        profilePage.setInsertNamaPengirim(ConfigFileReader.getNamaPengirim());
        // set insert nomor HP pengirim
        profilePage.setInsertNomorHpPengirim(ConfigFileReader.getNomorHpPengirim());
        // set insert alamat pengirim
        profilePage.setInsertAlamatPengirim(ConfigFileReader.getAlamatPengirim());
        // choose province
        profilePage.chooseProvince(ConfigFileReader.getProvince());
        // choose city
        profilePage.chooseCity(ConfigFileReader.getCity());
        // choose district
        profilePage.chooseDistrict(ConfigFileReader.getDistrict());
        // choose subdistrict
        profilePage.chooseSubDistrict(ConfigFileReader.getSubdistrict());
        // choose postal code
        profilePage.choosePostalCode(ConfigFileReader.getPostalCode());
        // click button simpan
        profilePage.clickButtonSimpan();
        // Verify edit profile success
        assertTrue(checkScreen.isEnabledText("Kode Verifikasi", 10));

        // ==== hit API for verification code than click button verifikasi ====
    }

    @Title("Close Account")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Close account", groups = "Profile", priority = 1)
    public void closeAccountFailureBlankPassword() throws Exception {
        CheckScreen checkScreen = new CheckScreen(driver);
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // click button profile
        homePage.clickButtonProfile();
        // click button edit profile
        homePage.clickDropdownMenuEditProfile();
        // verify on the profile page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getHomePage().buttonEditProfile, 3));
        loadingWait(5);
        // click button edit profile
        profilePage.clickButtonEditProfile();
        // click button tutup akun
        profilePage.clickButtonTutupAkun();
        // click button konfirmasi tutup akun
        profilePage.clickButtonKonfirmasiTutupAkun();
        // Verify tutup akun failed
        assertTrue(checkScreen.isEnabledText("Akun belum diaktivasi atau password salah!", 10));
    }

    @Title("Calcel Close Account")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Cancel Close account", groups = "Profile", priority = 1)
    public void closeAccountCancel() throws Exception {
        CheckScreen checkScreen = new CheckScreen(driver);
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // click button profile
        homePage.clickButtonProfile();
        // click button edit profile
        homePage.clickDropdownMenuEditProfile();
        // verify on the profile page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getHomePage().buttonEditProfile, 3));
        loadingWait(5);
        // click button edit profile
        profilePage.clickButtonEditProfile();
        // click button tutup akun
        profilePage.clickButtonTutupAkun();
        // click button batal tutup akun
        profilePage.clickButtonBatalTutupAkun();
    }

    @Ignore // password baru tidak boleh sama dengan password lama
    @Title("Profile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Edit password", groups = "Profile", priority = 1)
    public void editPasswordTest() throws Exception {
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // click button profile
        homePage.clickButtonProfile();
        // click button edit password
        homePage.clickDropdownMenuEditPassword();
        // insert current password
        profilePage.setInsertCurrentPassword(ConfigFileReader.getCurrentPassword());
        // insert new password
        profilePage.setInsertNewPassword(ConfigFileReader.getNewPassword());
        // insert confirm new password
        profilePage.setInsertConfirmNewPassword(ConfigFileReader.getConfirmNewPassword());
        // click button simpan
        profilePage.clickButtonSimpan();
    }

}
