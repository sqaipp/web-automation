package com.automation.apptests.Profile;

import com.automation.apptests.LoginTest.LoginTest;
import com.automation.listeners.TestAllureListener;
import com.automation.screen.uicomponent.CheckScreen;
import com.automation.screen.uipages.homepages.homePage;
import com.automation.screen.uipages.profile.profilePage;
import com.automation.screen.uipages.profile.riwayatPage;
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
public class RiwayatTest extends BaseTest {
    LoginTest LoginTest = new LoginTest();
    homePage homePage = new homePage(driver);
    profilePage profilePage = new profilePage(driver);
    riwayatPage riwayatPage = new riwayatPage(driver);

    @Title("Riwayat")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Go to riwayat", groups = "Profile", priority = 1)
    public void goToRiwayat() throws Exception {
        homePage = new homePage(driver);
        profilePage = new profilePage(driver);
        riwayatPage = new riwayatPage(driver);
        // login
        LoginTest.validLoginTest();
        // click button profile
        homePage.clickButtonProfile();
        // click button edit profile
        homePage.clickButtonRiwayat();
        // verify on the profile page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getRiwayatPage().fieldSearchRiwayat, 3));
    }

    @Title("Search Riwayat")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Search riwayat", groups = "Profile", priority = 1)
    public void searchRiwayat() throws Exception {
        homePage = new homePage(driver);
        profilePage = new profilePage(driver);
        riwayatPage = new riwayatPage(driver);
        // login
        LoginTest.validLoginTest();
        // click button profile
        homePage.clickButtonProfile();
        // click button edit profile
        homePage.clickButtonRiwayat();
        // verify on the profile page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getRiwayatPage().fieldSearchRiwayat, 3));
        // input nomor resi for searching riwayat
        riwayatPage.setFieldSearchRiwayat("IP4250515152712");
        // click icon search
        riwayatPage.clickButtonIconSearch(); // === resp 404 ON DEV ===
    }

    @Title("Filter Riwayat")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Filter riwayat", groups = "Profile", priority = 1)
    public void filterRiwayat() throws Exception {
        homePage = new homePage(driver);
        profilePage = new profilePage(driver);
        riwayatPage = new riwayatPage(driver);
        // login
        LoginTest.validLoginTest();
        // click button profile
        homePage.clickButtonProfile();
        // click button edit profile
        homePage.clickButtonRiwayat();
        // verify on the profile page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getRiwayatPage().fieldSearchRiwayat, 3));
        // click button filter
        riwayatPage.clickButtonFilter();
        // click button filter semua
        riwayatPage.clickButtonFilterSemua();
        // click button filter mulai
        riwayatPage.clickButtonFilterMulai();
        // click button filter diterima dari pengirim
        riwayatPage.clickButtonFilterDiterimaDariPengirim();
        // click button filter proses pengiriman
        riwayatPage.clickButtonFilterProsesPengiriman();
        // click button filter siap diambil/diantar
        riwayatPage.clickButtonFilterSiapDiambilDiantar();
        // click button filter sudah diambil
        riwayatPage.clickButtonFilterSudahDiambil();
        // click button filter sedang diantar
        riwayatPage.clickButtonFilterSedangDiantar();
        // click button filter sudah diantar
        riwayatPage.clickButtonFilterSudahDiantar();
        // click button filter retur
        riwayatPage.clickButtonFilterRetur();
        // === resp 500 on DEV ===
    }

    @Title("Detil Riwayat")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "go to detil riwayat", groups = "Profile", priority = 1)
    public void goToDetilRiwayat() throws Exception {
        homePage = new homePage(driver);
        profilePage = new profilePage(driver);
        riwayatPage = new riwayatPage(driver);
        // login
        LoginTest.validLoginTest();
        // click button profile
        homePage.clickButtonProfile();
        // click button edit profile
        homePage.clickButtonRiwayat();
        // verify on the profile page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getRiwayatPage().fieldSearchRiwayat, 3));
        // go to detil riwayat
        riwayatPage.clickButtonDetilRiwayat();
//        // get detil transaction
//        riwayatPage.getDetilServiceName();
        // click button lihat detail
        riwayatPage.clickButtonLihatDetail();
        // check jam penjemputan
        riwayatPage.checkJamPenjemputan();
    }

    @Title("Undul Label Resi")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "undul label resi", groups = "Profile", priority = 1)
    public void unduhLabelResi() throws Exception {
        homePage = new homePage(driver);
        profilePage = new profilePage(driver);
        riwayatPage = new riwayatPage(driver);
        // login
        LoginTest.validLoginTest();
        // click button profile
        homePage.clickButtonProfile();
        // click button edit profile
        homePage.clickButtonRiwayat();
        // verify on the profile page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getRiwayatPage().fieldSearchRiwayat, 3));
        // go to detil riwayat
        riwayatPage.clickButtonDetilRiwayat();
        // click button unduh label resi
        riwayatPage.clickButtonUnduhResi();
    }
}
