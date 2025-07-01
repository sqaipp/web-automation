package com.automation.apptests.Transaction;

import com.automation.apptests.HomePagesTest.HomePageTest;
import com.automation.apptests.LoginTest.LoginTest;
import com.automation.base.BasePage;
import com.automation.helpers.LoginSteps;
import com.automation.listeners.TestAllureListener;
import com.automation.screen.uipages.desktop.homepages.HomePageDesktop;
import com.automation.screen.uipages.desktop.profile.RiwayatPageDesktop;
import com.automation.screen.uipages.desktop.transaction.KirimPaketPageDesktop;
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
public class CancelTransactionTest extends BaseTest {

    @Title("Cancel transaction Toko ke toko")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Cancel transaction Pengiriman paket melalui toko ke toko.", groups = "Transaction", priority = 1)
    public void cancelTokoAntarKeToko() throws Exception {
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // go to Kirim Sekarang
        homePage.clickBtnkirimPaket();
        // click button kirim sekarang toko antar ke alamat
        kirimPaketPage.clickButtonKirimPaketSekarang(1); // index kirim paket toko ke alamat
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("INFORMASI BARANG YANG TIDAK BOLEH DIKIRIM", 5));
        // click checkbox S&K
        kirimPaketPage.clickCheckboxSyaratDanKetentuan2();
        // click button Lanjut
        kirimPaketPage.clickButtonLanjut();
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("TOKO KE TOKO", 5));
        // insert nomor telpon pengirim
        kirimPaketPage.setInsertNomorHpPengirim(ConfigFileReader.getNomorHpPengirim());
        // insert nama penerima
        kirimPaketPage.setInsertNamaPenerima(ConfigFileReader.getNamaPenerima());
        // insert nomor telpon penerima
        kirimPaketPage.setInsertTelponPenerima(ConfigFileReader.getTelponPenerima());
        // insert email penerima
        kirimPaketPage.setInsertEmailPenerima(ConfigFileReader.getEmailPenerima());
        // insert kodetoko
        kirimPaketPage.setInsertKodetoko(ConfigFileReader.getKodetoko());
        // choose toko penerima
        kirimPaketPage.chooseKodetokoPenerima();
        // click button lanjut
        kirimPaketPage.clickButtonLanjut();
        // click button pilih kategori
        kirimPaketPage.clickPilihKategori();
        // click button pilih kategori elektronik
        kirimPaketPage.clickListKategoriElektronik();
        // click button mengerti
        kirimPaketPage.clickButtonMengerti();
        // insert deskripsi barang
        kirimPaketPage.setInsertDeskripsiBarang(ConfigFileReader.getDeskripsiBarang());
        // insert harga barang
        kirimPaketPage.setInsertHargaBarang(ConfigFileReader.getHargaBarang());
        // insert berat barang
        kirimPaketPage.setInsertBeratBarang(ConfigFileReader.getBeratBarang());
        // insert panjang barang
        kirimPaketPage.setInsertPanjangBarang(ConfigFileReader.getPanjangBarang());
        // insert lebar barang
        kirimPaketPage.setInsertLebarBarang(ConfigFileReader.getLebarBarang());
        // insert tinggi barang
        kirimPaketPage.setInsertTinggiBarang(ConfigFileReader.getTinggiBarang());
        // get text total biaya
        kirimPaketPage.getTotalTransaksi();
        // click button Lanjut
        kirimPaketPage.clickButtonLanjut();
        // Verify pengiriman
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("KONFIRMASI PENGIRIMAN ANDA", 5));
        // get total transaksi final
        kirimPaketPage.getTotalTransaksiFinal();
        // click button konfirmasi ringkasan
        kirimPaketPage.clickButtonKonfirmasiRingkasan();
        // switch browser tab
        kirimPaketPage.switchBrowserTab(0);
        // click button profile
        homePage.clickButtonProfile();
        // click button edit profile
        homePage.clickButtonRiwayat();
        // verify on the profile page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getRiwayatPage().fieldSearchRiwayat, 5));
        // click button batalkan AWB
        riwayatPage.clickButtonBatalkanAWB();
        // choose reason pembatalan AWB
        riwayatPage.clickReasonBatalkanAWB();
        // click button confirm batalkan AWB
        riwayatPage.clickButtonKonfirmasiBatalkanAWB();
        // Verify batalkan AWB success
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Berhasil Membatalkan resi", 5));
    }

    @Title("Cancel Titip paket")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Cancel Titip paket ke toko.", groups = "Transaction", priority = 1)
    public void cencelTitipPaketKeToko() throws Exception {
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // go to Kirim Sekarang
        homePage.clickBtnkirimPaket();
        // click button kirim sekarang toko antar ke alamat
        kirimPaketPage.clickButtonKirimPaketSekarang(2); // index titip paket
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("INFORMASI BARANG YANG TIDAK BOLEH DIKIRIM", 5));
        // click checkbox S&K
        kirimPaketPage.clickCheckboxSyaratDanKetentuan3();
        // click button Lanjut
        kirimPaketPage.clickButtonLanjut();
        // insert nomor telpon pengirim
        kirimPaketPage.setInsertNomorHpPengirim(ConfigFileReader.getNomorHpPengirim());
        // click checkbox penerima
        kirimPaketPage.clickCheckboxPenerima();
        // insert kodetoko
        kirimPaketPage.insertKodetokoPilihan(ConfigFileReader.getKodetokoPilihan());
        // choose toko penerima
        kirimPaketPage.chooseKodetokoPilihan();
        // click button lanjut
        kirimPaketPage.clickButtonLanjut();
        // click button pilih kategori
        kirimPaketPage.clickPilihKategori();
        // click button pilih kategori elektronik
        kirimPaketPage.clickListKategoriElektronik();
        // click button mengerti
        kirimPaketPage.clickButtonMengerti();
        // insert deskripsi barang
        kirimPaketPage.setInsertDeskripsiBarang(ConfigFileReader.getDeskripsiBarang());
        // insert harga barang
        kirimPaketPage.setInsertHargaBarang(ConfigFileReader.getHargaBarang());
        // insert berat barang
        kirimPaketPage.setInsertBeratBarang(ConfigFileReader.getBeratBarang());
        // insert panjang barang
        kirimPaketPage.setInsertPanjangBarang(ConfigFileReader.getPanjangBarang());
        // insert lebar barang
        kirimPaketPage.setInsertLebarBarang(ConfigFileReader.getLebarBarang());
        // insert tinggi barang
        kirimPaketPage.setInsertTinggiBarang(ConfigFileReader.getTinggiBarang());
        // get text total biaya
        kirimPaketPage.getTotalTransaksi();
        // click button Lanjut
        kirimPaketPage.clickButtonLanjut();
        // Verify pengiriman
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("KONFIRMASI PENGIRIMAN ANDA", 5));
        // get total transaksi final
        kirimPaketPage.getTotalTransaksiFinal();
        // click button konfirmasi ringkasan
        kirimPaketPage.clickButtonKonfirmasiRingkasan();
        // switch browser tab
        kirimPaketPage.switchBrowserTab(0);
        // click button profile
        homePage.clickButtonProfile();
        // click button edit profile
        homePage.clickButtonRiwayat();
        // verify on the profile page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getRiwayatPage().fieldSearchRiwayat, 3));
        // click button batalkan AWB
        riwayatPage.clickButtonBatalkanAWB();
        // choose reason pembatalan AWB
        riwayatPage.clickReasonBatalkanAWB();
        // click button confirm batalkan AWB
        riwayatPage.clickButtonKonfirmasiBatalkanAWB();
        // Verify batalkan AWB success
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Berhasil Membatalkan resi", 5));
    }

    @Title("Cancel Toko dan Antar ke Alamat")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Cancel Pengiriman paket melalui toko ke rumah.", groups = "Transaction", priority = 1)
    public void cancelTokoAntarKeAlamat() throws Exception {
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // go to Kirim Sekarang
        homePage.clickBtnkirimPaket();
        // click button kirim sekarang toko antar ke alamat
        kirimPaketPage.clickButtonKirimPaketSekarang(0); // index kirim paket toko ke alamat
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("INFORMASI BARANG YANG TIDAK BOLEH DIKIRIM", 5));
        // click checkbox S&K
        kirimPaketPage.clickCheckboxSyaratDanKetentuan1();
        // click button Lanjut
        kirimPaketPage.clickButtonLanjut();
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("TOKO & ANTAR KE ALAMAT", 5));
        // insert nomor telpon pengirim
        kirimPaketPage.setInsertNomorHpPengirim(ConfigFileReader.getNomorHpPengirim());

        // insert nama penerima
        kirimPaketPage.setInsertNamaPenerima(ConfigFileReader.getNamaPenerima());
        // insert nomor telpon penerima
        kirimPaketPage.setInsertTelponPenerima(ConfigFileReader.getTelponPenerima());
        // insert email penerima
        kirimPaketPage.setInsertEmailPenerima(ConfigFileReader.getEmailPenerima());
        // insert kota
        kirimPaketPage.setInsertKotaPenerima(ConfigFileReader.getKotaPenerima());
        // insert kodepos/kelurahan
        kirimPaketPage.chooseKelurahanPenerima(ConfigFileReader.getKelurahanPenerima());
        // insert alamat
        kirimPaketPage.setInsertAlamatPenerima(ConfigFileReader.getAlamatPenerima());
        // set insert alamat pengirim
        kirimPaketPage.setInsertAlamatPenerima(ConfigFileReader.getAlamatPenerima());
        // click button lanjut
        kirimPaketPage.clickButtonLanjut();
        // click button konfirmasi alamat
        kirimPaketPage.clickButtonKonfirmasiAlamat();
        // click button pilih kategori
        kirimPaketPage.clickPilihKategori();
        // click button pilih kategori elektronik
        kirimPaketPage.clickListKategoriElektronik();
        // click button mengerti
        kirimPaketPage.clickButtonMengerti();
        // insert deskripsi barang
        kirimPaketPage.setInsertDeskripsiBarang(ConfigFileReader.getDeskripsiBarang());
        // insert harga barang
        kirimPaketPage.setInsertHargaBarang(ConfigFileReader.getHargaBarang());
        // insert berat barang
        kirimPaketPage.setInsertBeratBarang(ConfigFileReader.getBeratBarang());
        // insert panjang barang
        kirimPaketPage.setInsertPanjangBarang(ConfigFileReader.getPanjangBarang());
        // insert lebar barang
        kirimPaketPage.setInsertLebarBarang(ConfigFileReader.getLebarBarang());
        // insert tinggi barang
        kirimPaketPage.setInsertTinggiBarang(ConfigFileReader.getTinggiBarang());
        // get text total biaya
        kirimPaketPage.getTotalTransaksi();
        // click button Lanjut
        kirimPaketPage.clickButtonLanjut();
        // Verify pengiriman
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("KONFIRMASI PENGIRIMAN ANDA", 10));
        // get total transaksi final
        kirimPaketPage.getTotalTransaksiFinal();
        // click button konfirmasi ringkasan
        kirimPaketPage.clickButtonKonfirmasiRingkasan();
        // switch browser tab
        kirimPaketPage.switchBrowserTab(0);
        // click button profile
        homePage.clickButtonProfile();
        // click button edit profile
        homePage.clickButtonRiwayat();
        // verify on the profile page
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledElement(screen().getRiwayatPage().fieldSearchRiwayat, 3));
        // click button batalkan AWB
        riwayatPage.clickButtonBatalkanAWB();
        // choose reason pembatalan AWB
        riwayatPage.clickReasonBatalkanAWB();
        // click button confirm batalkan AWB
        riwayatPage.clickButtonKonfirmasiBatalkanAWB();
        // Verify batalkan AWB success
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Berhasil Membatalkan resi", 5));
    }
}
