package com.automation.apptests.Transaction;

import com.automation.helpers.LoginSteps;
import com.automation.listeners.TestAllureListener;
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
public class TransactionTest extends BaseTest {

    @Title("Toko dan Antar ke Alamat")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Pengiriman paket melalui toko ke rumah.", groups = "Transaction", priority = 1)
    public void tokoAntarKeAlamat() throws Exception {
        KirimPaketPageDesktop kirimPaketPage = new KirimPaketPageDesktop(driver);
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
        // Verify success transaction
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Pembuatan Nomor Resi Berhasil", 5));
        // get text nomor resi
        kirimPaketPage.getTextNomorResiSuccessTransaction();
    }

    @Title("Toko ke toko")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Pengiriman paket melalui toko ke toko.", groups = "Transaction", priority = 1)
    public void tokoAntarKeToko() throws Exception {
        KirimPaketPageDesktop kirimPaketPage = new KirimPaketPageDesktop(driver);
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
        // Verify success transaction
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Pembuatan Nomor Resi Berhasil", 5));
        // get text nomor resi
        kirimPaketPage.getTextNomorResiSuccessTransaction();
    }

    @Title("Titip paket")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Titip paket ke toko.", groups = "Transaction", priority = 1)
    public void titipPaketKeToko() throws Exception {
        KirimPaketPageDesktop kirimPaketPage = new KirimPaketPageDesktop(driver);
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
        // Verify success transaction
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Pembuatan Nomor Resi Berhasil", 5));
        // get text nomor resi
        kirimPaketPage.getTextNomorResiSuccessTransaction();
    }

    @Title("Jemput paket & antar ke alamat")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Jemput paket & antar ke alamat", groups = "Transaction", priority = 1)
    public void jemputDanAntarKeAlamat() throws Exception {
        KirimPaketPageDesktop kirimPaketPage = new KirimPaketPageDesktop(driver);
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // go to Kirim Sekarang
        homePage.clickBtnkirimPaket();
        // click button kirim sekarang toko antar ke alamat
        kirimPaketPage.clickButtonKirimPaketSekarang(3); // index titip paket
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
        KirimPaketPageDesktop kirimPaketPage = new KirimPaketPageDesktop(driver);
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // go to Kirim Sekarang
        homePage.clickBtnkirimPaket();
        // click button kirim sekarang toko antar ke alamat
        kirimPaketPage.clickButtonKirimPaketSekarang(4); // index titip paket
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("INFORMASI BARANG YANG TIDAK BOLEH DIKIRIM", 5));
        // click checkbox S&K
        kirimPaketPage.clickCheckboxSyaratDanKetentuan1();
        // click button Lanjut
        kirimPaketPage.clickButtonLanjut();
        // Verify page Jemput & ambil di toko
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("JEMPUT & AMBIL DI TOKO", 5));
        // insert nama pengirim
        kirimPaketPage.setInsertNomorHpPengirim(ConfigFileReader.getNamaPengirim());
        // insert nomor telpon pengirim
        kirimPaketPage.setInsertNomorHpPengirim(ConfigFileReader.getNomorHpPengirim());
        // insert kota/kecamatan pengirim
        kirimPaketPage.setInsertKotaKecamatanPengirim(ConfigFileReader.getKotaKecamatanPengirim());
        // choose kota/kecamatan pengirim
        kirimPaketPage.chooseKotaKecamatanPengirim();
        // choose kodepos/kelurahan pengirim
        kirimPaketPage.chooseKelurahanPengirim();
        // set insert alamat pengirim
        kirimPaketPage.setInsertAlamatPengirim(ConfigFileReader.getAlamatPengirim());
        // insert catatan pengiriman
        kirimPaketPage.setInsertCatatanPengirim(ConfigFileReader.getCatatanPengirim());
        // click button pilih waktu jemput
        kirimPaketPage.clickButtonPilihWaktuJemput();
        // click button konfirmasi waktu jemput
        kirimPaketPage.clickButtonKonfirmasiWaktuJemput();
        // insert nama penerima
        kirimPaketPage.setInsertNamaPenerima(ConfigFileReader.getNamaPenerima());
        // insert nomor telpon penerima
        kirimPaketPage.setInsertTelponPenerima(ConfigFileReader.getTelponPenerima());
        // insert email penerima
        kirimPaketPage.setInsertEmailPenerima(ConfigFileReader.getEmailPenerima());
        // insert kodetoko
        kirimPaketPage.setInsertKodetokoPenerima(ConfigFileReader.getKodetokoPenerimaPaketJemput());
        // choose toko penerima
        kirimPaketPage.chooseKodetokoPenerima();
        // click button Lanjut
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
        // Verify success transaction
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Pembuatan Nomor Resi Berhasil", 5));
        // get text nomor resi
        kirimPaketPage.getTextNomorResiSuccessTransaction();
    }

    @Title("Check jam jemput & asuransi on transaction Jemput paket & ambil di toko")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Check jam jemput & asuransi on transaction Jemput paket & ambil di toko", groups = "Transaction", priority = 1)
    public void checkJamJemputAndAsuransiTransactionJemputDanAmbilDiToko() throws Exception {
        KirimPaketPageDesktop kirimPaketPage = new KirimPaketPageDesktop(driver);
        // login
        LoginSteps loginSteps = new LoginSteps(loginPage, homePage);
        loginSteps.doValidLogin(ConfigFileReader.getUsername(),ConfigFileReader.getPassword());
        // go to Kirim Sekarang
       homePage.clickBtnkirimPaket();
        // click button kirim sekarang toko antar ke alamat
        kirimPaketPage.clickButtonKirimPaketSekarang(4); // index titip paket
        // Verify persetujuan S & K
        loadingWait(5);
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("INFORMASI BARANG YANG TIDAK BOLEH DIKIRIM", 5));
        // click checkbox S&K
        kirimPaketPage.clickCheckboxSyaratDanKetentuan1();
        // click button Lanjut
        kirimPaketPage.clickButtonLanjut();
        // Verify page Jemput & ambil di toko
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("JEMPUT & AMBIL DI TOKO", 5));
        // insert nama pengirim
        kirimPaketPage.setInsertNomorHpPengirim(ConfigFileReader.getNamaPengirim());
        // insert nomor telpon pengirim
        kirimPaketPage.setInsertNomorHpPengirim(ConfigFileReader.getNomorHpPengirim());
        // insert kota/kecamatan pengirim
        kirimPaketPage.setInsertKotaKecamatanPengirim(ConfigFileReader.getKotaKecamatanPengirim());
        // choose kota/kecamatan pengirim
        kirimPaketPage.chooseKotaKecamatanPengirim();
        // choose kodepos/kelurahan pengirim
        kirimPaketPage.chooseKelurahanPengirim();
        // set insert alamat pengirim
        kirimPaketPage.setInsertAlamatPengirim(ConfigFileReader.getAlamatPengirim());
        // insert catatan pengiriman
        kirimPaketPage.setInsertCatatanPengirim(ConfigFileReader.getCatatanPengirim());
        // click button pilih waktu jemput
        kirimPaketPage.clickButtonPilihWaktuJemput();
        // click button konfirmasi waktu jemput
        kirimPaketPage.clickButtonKonfirmasiWaktuJemput();
        // insert nama penerima
        kirimPaketPage.setInsertNamaPenerima(ConfigFileReader.getNamaPenerima());
        // insert nomor telpon penerima
        kirimPaketPage.setInsertTelponPenerima(ConfigFileReader.getTelponPenerima());
        // insert email penerima
        kirimPaketPage.setInsertEmailPenerima(ConfigFileReader.getEmailPenerima());
        // insert kodetoko
        kirimPaketPage.setInsertKodetokoPenerima(ConfigFileReader.getKodetokoPenerimaPaketJemput());
        // choose toko penerima
        kirimPaketPage.chooseKodetokoPenerima();
        // click button Lanjut
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
        // click checkbox asuransi
        kirimPaketPage.clickCheckboxAsuransi();
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
        // Verify success transaction
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Pembuatan Nomor Resi Berhasil", 5));
        // get text nomor resi
        kirimPaketPage.getTextNomorResiSuccessTransaction();
        // switch to previous browser tab
        kirimPaketPage.switchBrowserTab(0);
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
                        .isEnabledElement(screen().getRiwayatPage().textJadwalJemput, 3));
        // verify text biaya asuransi
        assertTrue(
                uiComponent().checkTextScreen()
                        .isEnabledText("Asuransi", 3));
    }

}
