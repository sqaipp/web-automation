package com.automation.apptests.Transaction;

import com.automation.apptests.LoginTest.LoginTest;
import com.automation.listeners.TestAllureListener;
import com.automation.screen.uipages.homepages.homePage;
import com.automation.screen.uipages.transaction.ambilPaketPage;
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
public class AmbilPaketTest extends BaseTest {
    LoginTest LoginTest = new LoginTest();

    @Title("Ambil paket")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Ambil paket", groups = "Transaction", priority = 1)
    public void ambilPaket() throws Exception {
        homePage homePage = new homePage(driver);
        ambilPaketPage ambilPaketPage = new ambilPaketPage(driver);
        // login
        LoginTest.validLoginTest();
        // go to Kirim Sekarang
        homePage.clickButtonOTP();
        // Verify page OTP
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Ambil Paket", 5));
        // click on menu proses
        ambilPaketPage.clickMenuProses();
        // choose menu proses
        ambilPaketPage.chooseProses();
        // insert kodetoko
        ambilPaketPage.insertKodetoko(ConfigFileReader.getKodetoko());
        // insert pin
        ambilPaketPage.insertPin(ConfigFileReader.getTelponPenerima());
        // click button generate
        ambilPaketPage.clickButtonGenerate();
    }
}
