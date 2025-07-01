package com.automation.apptests.HomePagesTest;

import com.automation.helpers.LoginSteps;
import com.automation.listeners.TestAllureListener;
import com.automation.screen.uicomponent.CheckScreen;
import com.automation.utils.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;
import static org.testng.AssertJUnit.assertTrue;

@Slf4j
@Listeners({TestAllureListener.class})
public class HomePageTest extends BaseTest {

    @Title("Verify home page")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify home page", groups = "Home Page", priority = 1)
    public void verifyHomePageGuest() {
        CheckScreen checkScreen = new CheckScreen(driver);
        // assert button menu and text on home page (without login)
        assertTrue(checkScreen.isEnabledText("BERANDA", 3));
        assertTrue(checkScreen.isEnabledText("TRACKING", 3));
        assertTrue(checkScreen.isEnabledText("CEK TARIF", 3));
        assertTrue(checkScreen.isEnabledText("KIRIM SEKARANG", 3));
        assertTrue(checkScreen.isEnabledText("CARI TOKO", 3));
        assertTrue(checkScreen.isEnabledText("TENTANG KAMI", 3));
        assertTrue(checkScreen.isEnabledText("MEMBERSHIP", 3));
        assertTrue(checkScreen.isEnabledText("Daftar", 3));
        assertTrue(checkScreen.isEnabledText("Masuk", 3));
    }

    @Title("Tracking")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Tracking Nomor Resi", groups = "Home Page", priority = 1)
    public void trackingResi() {
        // input nomor resi
        homePage.inputResi(ConfigFileReader.getNoResi());
        // click on button search
        homePage.clickBtnSearchResi();
        // insert capcha & terapkan
        homePage.insertCapcha();
    }

    @Title("Multi Tracking")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Multi Tracking Nomor Resi", groups = "Home Page", priority = 1)
    public void trackingMultiResi() {
        // click button multi resi
        homePage.clickButtonMultiResi();
        // input nomor resi
        homePage.inputMultiResi(ConfigFileReader.getNoMultiResi());
        // click on button search
        homePage.clickBtnSearchResi();
        // insert capcha & terapkan
        homePage.insertCapcha();
    }

    @Title("Failed Tracking")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Tracking Nomor Resi", groups = "Home Page", priority = 1)
    public void failedTrackingResi() {
        // input nomor resi
        homePage.inputResi(ConfigFileReader.getNoResiNotFound());
        // click on button search
        homePage.clickBtnSearchResi();
        // insert capcha & terapkan
        homePage.insertCapcha();
        // Verify that the tracking number is not found
        assertTrue(
                uiComponent().checkTextScreen()
                                .isEnabledText("Nomor resi tidak ditemukan", 5) ||
                        uiComponent().checkTextScreen()
                                .isEnabledText("Silahkan coba lagi dengan memasukkan kode/captcha.", 5));
    }

    @Title("Tracking Multi Resi")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Tracking Nomor Multi Resi", groups = "Home Page", priority = 1)
    public void failedTrackingMultiResi() {
        // click button multi resi
        homePage.clickButtonMultiResi();
        // input nomor resi
        homePage.inputMultiResi(ConfigFileReader.getNoMultiResiNotFound());
        // click on button search
        homePage.clickBtnSearchResi();
        // insert capcha & terapkan
        homePage.insertCapcha();
        // Verify that the tracking number is not found
        loadingWait(3);
        // Verify that the tracking number is not found
        assertTrue(
                uiComponent().checkTextScreen()
                                .isEnabledText("Tidak Ditemukan", 5) ||
                        uiComponent().checkTextScreen()
                                .isEnabledText(" Silahkan coba lagi dengan memasukkan kode/captcha.", 5));
    }

    @Title("Cek tarif")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Cek tarif paket", groups = "Home Page", priority = 1)
    public void checkTarif() {
        // input kota asal
        homePage.inputAsalKota(ConfigFileReader.getKotaAsal());
        // input kota tujuan
        homePage.inputTujuanKota(ConfigFileReader.getKotaTujuan());
        // input berat paket
        homePage.inputBerat();
        // input dimensi panjang
        homePage.inputDimensiPanjang();
        // input dimensi lebar
        homePage.inputDimensiLebar();
        // input dimensi tinggi
        homePage.inputDimensiTinggi();
        // click button cek tarif
        homePage.clickButtonCekTarif();
        // Verify cek tarif
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("JEMPUT DAN ANTAR KE ALAMAT", 3));
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("TOKO KE ALAMAT", 3));
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("JEMPUT DAN AMBIL DI TOKO", 3));
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("TOKO KE TOKO", 3));
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("TITIP PAKET", 3));
    }

    @Title("Kirim Sekarang")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Kirim sekarang", groups = "Home Page", priority = 1)
    public void kirimPaket() {
        // go to Kirim Sekarang
        homePage.clickBtnkirimPaket();
    }

    @Title("Cari toko")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Cari toko", groups = "Home Page", priority = 1)
    public void cariToko() {
        // go to Cari Toko
        homePage.clickBtnCariToko();
    }

    @Title("Tentang kami")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Tentang kami", groups = "Home Page", priority = 1)
    public void tentangKami() {
        // go to Tentang Kami
        homePage.clickBtnTentangKamiBeforeLogin();
    }

    @Title("Membership")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Membership", groups = "Home Page", priority = 1)
    public void membership() {
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // go to Membership
        homePage.clickBtnMembership();
    }
}