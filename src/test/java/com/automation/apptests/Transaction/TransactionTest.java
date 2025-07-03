package com.automation.apptests.Transaction;

import com.automation.apptests.HomePagesTest.HomePageTest;
import com.automation.apptests.LoginTest.LoginTest;
import com.automation.apptests.Profile.RiwayatTest;
import com.automation.base.base.BasePage;
import com.automation.listeners.TestAllureListener;
import com.automation.screen.uipages.homepages.homePage;
import com.automation.screen.uipages.profile.riwayatPage;
import com.automation.screen.uipages.transaction.kirimSekarangPage;
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
public class TransactionTest extends BaseTest {
    HomePageTest HomePageTest = new HomePageTest();
    LoginTest LoginTest = new LoginTest();
    RiwayatTest RiwayatTest = new RiwayatTest();

    @Title("Toko dan Antar ke Alamat")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Pengiriman paket melalui toko ke rumah.", groups = "Transaction", priority = 1)
    public void tokoAntarKeAlamat() throws Exception {
        kirimSekarangPage kirimSekarangPage = new kirimSekarangPage(driver);
        // login
        LoginTest.validLoginTest();
        // go to Kirim Sekarang
        HomePageTest.kirimSekarang();
        // click button kirim sekarang toko antar ke alamat
        kirimSekarangPage.clickButtonKirimPaketSekarang(0); // index kirim paket toko ke alamat
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("INFORMASI BARANG YANG TIDAK BOLEH DIKIRIM", 5));
        // click checkbox S&K
        kirimSekarangPage.clickCheckboxSyaratDanKetentuan1();
        // click button Lanjut
        kirimSekarangPage.clickButtonLanjut();
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("TOKO & ANTAR KE ALAMAT", 5));
        // insert nomor telpon pengirim
        kirimSekarangPage.setInsertNomorHpPengirim(ConfigFileReader.getNomorHpPengirim());

        // insert nama penerima
        kirimSekarangPage.setInsertNamaPenerima(ConfigFileReader.getNamaPenerima());
        // insert nomor telpon penerima
        kirimSekarangPage.setInsertTelponPenerima(ConfigFileReader.getTelponPenerima());
        // insert email penerima
        kirimSekarangPage.setInsertEmailPenerima(ConfigFileReader.getEmailPenerima());
        // insert kota
        kirimSekarangPage.setInsertKotaPenerima(ConfigFileReader.getKotaPenerima());
        // insert kodepos/kelurahan
        kirimSekarangPage.chooseKelurahanPenerima(ConfigFileReader.getKelurahanPenerima());
        // insert alamat
        kirimSekarangPage.setInsertAlamatPenerima(ConfigFileReader.getAlamatPenerima());
        // set insert alamat pengirim
        kirimSekarangPage.setInsertAlamatPenerima(ConfigFileReader.getAlamatPenerima());
        // click button lanjut
        kirimSekarangPage.clickButtonLanjut();
        // click button konfirmasi alamat
        kirimSekarangPage.clickButtonKonfirmasiAlamat();
        // click button pilih kategori
        kirimSekarangPage.clickPilihKategori();
        // click button pilih kategori elektronik
        kirimSekarangPage.clickListKategoriElektronik();
        // click button mengerti
        kirimSekarangPage.clickButtonMengerti();
        // insert deskripsi barang
        kirimSekarangPage.setInsertDeskripsiBarang(ConfigFileReader.getDeskripsiBarang());
        // insert harga barang
        kirimSekarangPage.setInsertHargaBarang(ConfigFileReader.getHargaBarang());
        // insert berat barang
        kirimSekarangPage.setInsertBeratBarang(ConfigFileReader.getBeratBarang());
        // insert panjang barang
        kirimSekarangPage.setInsertPanjangBarang(ConfigFileReader.getPanjangBarang());
        // insert lebar barang
        kirimSekarangPage.setInsertLebarBarang(ConfigFileReader.getLebarBarang());
        // insert tinggi barang
        kirimSekarangPage.setInsertTinggiBarang(ConfigFileReader.getTinggiBarang());
        // get text total biaya
        kirimSekarangPage.getTotalTransaksi();
        // click button Lanjut
        kirimSekarangPage.clickButtonLanjut();
        // Verify pengiriman
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("KONFIRMASI PENGIRIMAN ANDA", 10));
        // get total transaksi final
        kirimSekarangPage.getTotalTransaksiFinal();
        // click button konfirmasi ringkasan
        kirimSekarangPage.clickButtonKonfirmasiRingkasan();
        // check warning illegal activity
        kirimSekarangPage.checkWarningIllegalActivity();
        // Verify success transaction
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Pembuatan Nomor Resi Berhasil", 5));
        // get text nomor resi
        kirimSekarangPage.getTextNomorResiSuccessTransaction();
    }

    @Title("Toko ke toko")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Pengiriman paket melalui toko ke toko.", groups = "Transaction", priority = 1)
    public void tokoAntarKeToko() throws Exception {
        kirimSekarangPage kirimSekarangPage = new kirimSekarangPage(driver);
        // login
        LoginTest.validLoginTest();
        // go to Kirim Sekarang
        HomePageTest.kirimSekarang();
        // click button kirim sekarang toko antar ke alamat
        kirimSekarangPage.clickButtonKirimPaketSekarang(1); // index kirim paket toko ke alamat
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("INFORMASI BARANG YANG TIDAK BOLEH DIKIRIM", 5));
        // click checkbox S&K
        kirimSekarangPage.clickCheckboxSyaratDanKetentuan2();
        // click button Lanjut
        kirimSekarangPage.clickButtonLanjut();
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("TOKO KE TOKO", 5));
        // insert nama pengirim
        kirimSekarangPage.setInsertNamaPengirim(ConfigFileReader.getNamaPengirim());
        // insert nomor telpon pengirim
        kirimSekarangPage.setInsertNomorHpPengirim(ConfigFileReader.getNomorHpPengirim());
        // insert kota kecamatan pengirim
        kirimSekarangPage.setInsertKotaKecamatanPengirim(ConfigFileReader.getKotaKecamatanPengirim());
        // choose kota kecamatan pengirim
        kirimSekarangPage.chooseKotaKecamatanPengirim();
        // insert nama penerima
        kirimSekarangPage.setInsertNamaPenerima(ConfigFileReader.getNamaPenerima());
        // insert nomor telpon penerima
        kirimSekarangPage.setInsertTelponPenerima(ConfigFileReader.getTelponPenerima());
        // insert email penerima
        kirimSekarangPage.setInsertEmailPenerima(ConfigFileReader.getEmailPenerima());
        // insert kodetoko
        kirimSekarangPage.setInsertKodetoko(ConfigFileReader.getKodetoko());
        // choose toko penerima
        kirimSekarangPage.chooseKodetokoPenerima();
        // click button lanjut
        kirimSekarangPage.clickButtonLanjut();
        // click button pilih kategori
        kirimSekarangPage.clickPilihKategori();
        // click button pilih kategori elektronik
        kirimSekarangPage.clickListKategoriElektronik();
        // click button mengerti
        kirimSekarangPage.clickButtonMengerti();
        // insert deskripsi barang
        kirimSekarangPage.setInsertDeskripsiBarang(ConfigFileReader.getDeskripsiBarang());
        // insert harga barang
        kirimSekarangPage.setInsertHargaBarang(ConfigFileReader.getHargaBarang());
        // insert berat barang
        kirimSekarangPage.setInsertBeratBarang(ConfigFileReader.getBeratBarang());
        // insert panjang barang
        kirimSekarangPage.setInsertPanjangBarang(ConfigFileReader.getPanjangBarang());
        // insert lebar barang
        kirimSekarangPage.setInsertLebarBarang(ConfigFileReader.getLebarBarang());
        // insert tinggi barang
        kirimSekarangPage.setInsertTinggiBarang(ConfigFileReader.getTinggiBarang());
        // get text total biaya
        kirimSekarangPage.getTotalTransaksi();
        // click button Lanjut
        kirimSekarangPage.clickButtonLanjut();
        // Verify pengiriman
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("KONFIRMASI PENGIRIMAN ANDA", 5));
        // get total transaksi final
        kirimSekarangPage.getTotalTransaksiFinal();
        // click button konfirmasi ringkasan
        kirimSekarangPage.clickButtonKonfirmasiRingkasan();
        // check warning illegal activity
        kirimSekarangPage.checkWarningIllegalActivity();
        // Verify success transaction
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Pembuatan Nomor Resi Berhasil", 5));
        // get text nomor resi
        kirimSekarangPage.getTextNomorResiSuccessTransaction();
    }

    @Title("Titip paket")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Titip paket ke toko.", groups = "Transaction", priority = 1)
    public void titipPaketKeToko() throws Exception {
        kirimSekarangPage kirimSekarangPage = new kirimSekarangPage(driver);
        // login
        LoginTest.validLoginTest();
        // go to Kirim Sekarang
        HomePageTest.kirimSekarang();
        // click button kirim sekarang toko antar ke alamat
        kirimSekarangPage.clickButtonKirimPaketSekarang(2); // index titip paket
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("INFORMASI BARANG YANG TIDAK BOLEH DIKIRIM", 5));
        // click checkbox S&K
        kirimSekarangPage.clickCheckboxSyaratDanKetentuan3();
        // click button Lanjut
        kirimSekarangPage.clickButtonLanjut();
        // insert nama pengirim
        kirimSekarangPage.setInsertNamaPengirim(ConfigFileReader.getNamaPengirim());
        // insert nomor telpon pengirim
        kirimSekarangPage.setInsertNomorHpPengirim(ConfigFileReader.getNomorHpPengirim());
        // click checkbox penerima
        kirimSekarangPage.clickCheckboxPenerima();
        // insert kodetoko
        kirimSekarangPage.insertKodetokoPilihan(ConfigFileReader.getKodetokoPilihan());
        // choose toko penerima
        kirimSekarangPage.chooseKodetokoPilihan();
        // click button lanjut
        kirimSekarangPage.clickButtonLanjut();
        // click button pilih kategori
        kirimSekarangPage.clickPilihKategori();
        // click button pilih kategori elektronik
        kirimSekarangPage.clickListKategoriElektronik();
        // click button mengerti
        kirimSekarangPage.clickButtonMengerti();
        // insert deskripsi barang
        kirimSekarangPage.setInsertDeskripsiBarang(ConfigFileReader.getDeskripsiBarang());
        // insert harga barang
        kirimSekarangPage.setInsertHargaBarang(ConfigFileReader.getHargaBarang());
        // insert berat barang
        kirimSekarangPage.setInsertBeratBarang(ConfigFileReader.getBeratBarang());
        // insert panjang barang
        kirimSekarangPage.setInsertPanjangBarang(ConfigFileReader.getPanjangBarang());
        // insert lebar barang
        kirimSekarangPage.setInsertLebarBarang(ConfigFileReader.getLebarBarang());
        // insert tinggi barang
        kirimSekarangPage.setInsertTinggiBarang(ConfigFileReader.getTinggiBarang());
        // get text total biaya
        kirimSekarangPage.getTotalTransaksi();
        // click button Lanjut
        kirimSekarangPage.clickButtonLanjut();
        // Verify pengiriman
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("KONFIRMASI PENGIRIMAN ANDA", 5));
        // get total transaksi final
        kirimSekarangPage.getTotalTransaksiFinal();
        // click button konfirmasi ringkasan
        kirimSekarangPage.clickButtonKonfirmasiRingkasan();
        // check warning illegal activity
        kirimSekarangPage.checkWarningIllegalActivity();
        // Verify success transaction
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Pembuatan Nomor Resi Berhasil", 5));
        // get text nomor resi
        kirimSekarangPage.getTextNomorResiSuccessTransaction();
    }

    @Title("Jemput paket & antar ke alamat")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Jemput paket & antar ke alamat", groups = "Transaction", priority = 1)
    public void jemputDanAntarKeAlamat() throws Exception {
        kirimSekarangPage kirimSekarangPage = new kirimSekarangPage(driver);
        // login
        LoginTest.validLoginTest();
        // go to Kirim Sekarang
        HomePageTest.kirimSekarang();
        // click button kirim sekarang toko antar ke alamat
        kirimSekarangPage.clickButtonKirimPaketSekarang(3); // index titip paket
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("JEMPUT & ANTAR KE ALAMAT", 5));
        System.out.println("Jemput & antar paket hanya bisa melalui aplikasi Indompaket");
    }

    @Title("Jemput paket & ambil di toko")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Jemput paket & ambil di toko", groups = "Transaction", priority = 1)
    public void jemputDanAmbilDiToko() throws Exception {
        kirimSekarangPage kirimSekarangPage = new kirimSekarangPage(driver);
        BasePage BasePage = new BasePage(driver);
        // login
        LoginTest.validLoginTest();
        // go to Kirim Sekarang
        HomePageTest.kirimSekarang();
        // click button kirim sekarang toko antar ke alamat
        kirimSekarangPage.clickButtonKirimPaketSekarang(4); // index titip paket
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("INFORMASI BARANG YANG TIDAK BOLEH DIKIRIM", 5));
        // click checkbox S&K
        kirimSekarangPage.clickCheckboxSyaratDanKetentuan1();
        // click button Lanjut
        kirimSekarangPage.clickButtonLanjut();
        // Verify page Jemput & ambil di toko
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("JEMPUT & AMBIL DI TOKO", 5));
        // insert nama pengirim
        kirimSekarangPage.setInsertNomorHpPengirim(ConfigFileReader.getNamaPengirim());
        // insert nomor telpon pengirim
        kirimSekarangPage.setInsertNomorHpPengirim(ConfigFileReader.getNomorHpPengirim());
        // insert kota/kecamatan pengirim
        kirimSekarangPage.setInsertKotaKecamatanPengirim(ConfigFileReader.getKotaKecamatanPengirim());
        // choose kota/kecamatan pengirim
        kirimSekarangPage.chooseKotaKecamatanPengirim();
        // choose kodepos/kelurahan pengirim
        kirimSekarangPage.chooseKelurahanPengirim();
        // set insert alamat pengirim
        kirimSekarangPage.setInsertAlamatPengirim(ConfigFileReader.getAlamatPengirim());
        // insert catatan pengiriman
        kirimSekarangPage.setInsertCatatanPengirim(ConfigFileReader.getCatatanPengirim());
        // click button pilih waktu jemput
        kirimSekarangPage.clickButtonPilihWaktuJemput();
        // click button konfirmasi waktu jemput
        kirimSekarangPage.clickButtonKonfirmasiWaktuJemput();
        // insert nama penerima
        kirimSekarangPage.setInsertNamaPenerima(ConfigFileReader.getNamaPenerima());
        // insert nomor telpon penerima
        kirimSekarangPage.setInsertTelponPenerima(ConfigFileReader.getTelponPenerima());
        // insert email penerima
        kirimSekarangPage.setInsertEmailPenerima(ConfigFileReader.getEmailPenerima());
        // insert kodetoko
        kirimSekarangPage.setInsertKodetokoPenerima(ConfigFileReader.getKodetokoPenerimaPaketJemput());
        // choose toko penerima
        kirimSekarangPage.chooseKodetokoPenerima();
        // click button Lanjut
        kirimSekarangPage.clickButtonLanjut();
        // click button pilih kategori
        kirimSekarangPage.clickPilihKategori();
        // click button pilih kategori elektronik
        kirimSekarangPage.clickListKategoriElektronik();
        // click button mengerti
        kirimSekarangPage.clickButtonMengerti();
        // insert deskripsi barang
        kirimSekarangPage.setInsertDeskripsiBarang(ConfigFileReader.getDeskripsiBarang());
        // insert harga barang
        kirimSekarangPage.setInsertHargaBarang(ConfigFileReader.getHargaBarang());
        // insert berat barang
        kirimSekarangPage.setInsertBeratBarang(ConfigFileReader.getBeratBarang());
        // insert panjang barang
        kirimSekarangPage.setInsertPanjangBarang(ConfigFileReader.getPanjangBarang());
        // insert lebar barang
        kirimSekarangPage.setInsertLebarBarang(ConfigFileReader.getLebarBarang());
        // insert tinggi barang
        kirimSekarangPage.setInsertTinggiBarang(ConfigFileReader.getTinggiBarang());
        // get text total biaya
        kirimSekarangPage.getTotalTransaksi();
        // click button Lanjut
        kirimSekarangPage.clickButtonLanjut();
        // Verify pengiriman
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("KONFIRMASI PENGIRIMAN ANDA", 5));
        // get total transaksi final
        kirimSekarangPage.getTotalTransaksiFinal();
        // click button konfirmasi ringkasan
        kirimSekarangPage.clickButtonKonfirmasiRingkasan();
        // check warning illegal activity
        kirimSekarangPage.checkWarningIllegalActivity();
        // check warning illegal activity
        kirimSekarangPage.checkWarningIllegalActivity();
        // Verify success transaction
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Pembuatan Nomor Resi Berhasil", 5));
        // get text nomor resi
        kirimSekarangPage.getTextNomorResiSuccessTransaction();
//        // switch to previous browser tab
//        BasePage.switchBrowserTab(0);
//        // check on riwayat transaksi
//        RiwayatTest.goToDetilRiwayat();
    }

    @Title("Check jam jemput & asuransi on transaction Jemput paket & ambil di toko")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Check jam jemput & asuransi on transaction Jemput paket & ambil di toko", groups = "Transaction", priority = 1)
    public void checkJamJemputAndAsuransiTransactionJemputDanAmbilDiToko() throws Exception {
        kirimSekarangPage kirimSekarangPage = new kirimSekarangPage(driver);
        homePage homePage = new homePage(driver);
        riwayatPage riwayatPage = new riwayatPage(driver);
        // login
        LoginTest.validLoginTest();
        // go to Kirim Sekarang
        HomePageTest.kirimSekarang();
        // click button kirim sekarang toko antar ke alamat
        kirimSekarangPage.clickButtonKirimPaketSekarang(4); // index titip paket
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("INFORMASI BARANG YANG TIDAK BOLEH DIKIRIM", 5));
        // click checkbox S&K
        kirimSekarangPage.clickCheckboxSyaratDanKetentuan1();
        // click button Lanjut
        kirimSekarangPage.clickButtonLanjut();
        // Verify page Jemput & ambil di toko
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("JEMPUT & AMBIL DI TOKO", 5));
        // insert nama pengirim
        kirimSekarangPage.setInsertNomorHpPengirim(ConfigFileReader.getNamaPengirim());
        // insert nomor telpon pengirim
        kirimSekarangPage.setInsertNomorHpPengirim(ConfigFileReader.getNomorHpPengirim());
        // insert kota/kecamatan pengirim
        kirimSekarangPage.setInsertKotaKecamatanPengirim(ConfigFileReader.getKotaKecamatanPengirim());
        // choose kota/kecamatan pengirim
        kirimSekarangPage.chooseKotaKecamatanPengirim();
        // choose kodepos/kelurahan pengirim
        kirimSekarangPage.chooseKelurahanPengirim();
        // set insert alamat pengirim
        kirimSekarangPage.setInsertAlamatPengirim(ConfigFileReader.getAlamatPengirim());
        // insert catatan pengiriman
        kirimSekarangPage.setInsertCatatanPengirim(ConfigFileReader.getCatatanPengirim());
        // click button pilih waktu jemput
        kirimSekarangPage.clickButtonPilihWaktuJemput();
        // click button konfirmasi waktu jemput
        kirimSekarangPage.clickButtonKonfirmasiWaktuJemput();
        // insert nama penerima
        kirimSekarangPage.setInsertNamaPenerima(ConfigFileReader.getNamaPenerima());
        // insert nomor telpon penerima
        kirimSekarangPage.setInsertTelponPenerima(ConfigFileReader.getTelponPenerima());
        // insert email penerima
        kirimSekarangPage.setInsertEmailPenerima(ConfigFileReader.getEmailPenerima());
        // insert kodetoko
        kirimSekarangPage.setInsertKodetokoPenerima(ConfigFileReader.getKodetokoPenerimaPaketJemput());
        // choose toko penerima
        kirimSekarangPage.chooseKodetokoPenerima();
        // click button Lanjut
        kirimSekarangPage.clickButtonLanjut();
        // click button pilih kategori
        kirimSekarangPage.clickPilihKategori();
        // click button pilih kategori elektronik
        kirimSekarangPage.clickListKategoriElektronik();
        // click button mengerti
        kirimSekarangPage.clickButtonMengerti();
        // insert deskripsi barang
        kirimSekarangPage.setInsertDeskripsiBarang(ConfigFileReader.getDeskripsiBarang());
        // insert harga barang
        kirimSekarangPage.setInsertHargaBarang(ConfigFileReader.getHargaBarang());
        // insert berat barang
        kirimSekarangPage.setInsertBeratBarang(ConfigFileReader.getBeratBarang());
        // insert panjang barang
        kirimSekarangPage.setInsertPanjangBarang(ConfigFileReader.getPanjangBarang());
        // insert lebar barang
        kirimSekarangPage.setInsertLebarBarang(ConfigFileReader.getLebarBarang());
        // insert tinggi barang
        kirimSekarangPage.setInsertTinggiBarang(ConfigFileReader.getTinggiBarang());
        // click checkbox asuransi
        kirimSekarangPage.clickCheckboxAsuransi();
        // get text total biaya
        kirimSekarangPage.getTotalTransaksi();
        // click button Lanjut
        kirimSekarangPage.clickButtonLanjut();
        // Verify pengiriman
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("KONFIRMASI PENGIRIMAN ANDA", 5));
        // get total transaksi final
        kirimSekarangPage.getTotalTransaksiFinal();
        // click button konfirmasi ringkasan
        kirimSekarangPage.clickButtonKonfirmasiRingkasan();
        // check warning illegal activity
        kirimSekarangPage.checkWarningIllegalActivity();
        // Verify success transaction
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Pembuatan Nomor Resi Berhasil", 5));
        // get text nomor resi
        kirimSekarangPage.getTextNomorResiSuccessTransaction();
        // switch to previous browser tab
        kirimSekarangPage.switchBrowserTab(0);
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
        // click button lihat detail
        riwayatPage.clickButtonLihatDetail();
        // check jam penjemputan
        riwayatPage.checkJamPenjemputan();
        // verify text jadwal jemput
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Jadwal Jemput", 3));
        // verify text biaya asuransi
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Asuransi", 3));
    }

}
