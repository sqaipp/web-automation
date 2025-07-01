package com.automation.screen.uipages.desktop.transaction;

import com.automation.base.BasePage;
import com.automation.screen.uipages.interfaces.transaction.KirimPaketPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;

@Slf4j
public class KirimPaketPageDesktop extends BasePage implements KirimPaketPage {
    public KirimPaketPageDesktop(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "wrap-btn")
    public List<WebElement> buttonkirimPaket;
    @Step("Clicking on button Kirim Sekarang")
    public void clickButtonKirimPaketSekarang(int index) {
        log.info("Clicking button edit profile");
        clickElement(buttonkirimPaket.get(index));
    }

    @Step("Clicking on checkbox S&K")
    public void clickCheckboxSyaratDanKetentuan1() {
        log.info("Click on checkbox S&K 1");
        performScroll(0.05);
        loadingWait(5);
        WebElement el = findAny(driver,
                By.cssSelector("label[for='checkbox_popup']"),
                By.cssSelector("label[for='checkbox_popupss']"),
                By.cssSelector("label[for='checkbox_popupss_baru']"),
                By.xpath("//*[@id=\"barang_yang_tidak_boleh_dikirim\"]/div/div/div[2]/div[2]/div[1]/label")
        );
        el.click();
//        driver.findElement(By.cssSelector("label[for='checkbox_popupss'], label[for='checkbox_popup']")).click();
    }

    @FindBy(className = "roundLabels")
    public List <WebElement> checkboxSyaratDanKetentuan;
    @Step("Clicking on checkbox S&K")
    public void clickCheckboxSyaratDanKetentuan2() {
        log.info("Click on checkbox S&K 2");
        performScroll(0.2);
        for(WebElement checkbox : checkboxSyaratDanKetentuan) {
            if(checkbox.getAttribute("for").contains("checkbox_popup")) {
                loadingWait(3);
                clickElement(checkbox);
                break;
            }
        }
    }

    @Step("Clicking on checkbox S&K")
    public void clickCheckboxSyaratDanKetentuan3() {
        log.info("Click on checkbox S&K 3");
        performScroll(0.05);
        loadingWait(3);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div/div/div[2]/div[2]/div[1]/label")).click();
    }

    @FindAll({@FindBy(id = "modal_lanjut"),
            @FindBy(id = "lanjut"),
            @FindBy(id = "button_door_to_point"),
            @FindBy(className = "ip_btn"),
            @FindBy(className = "btn")})
//    @FindBy(className = "btn")
    public List <WebElement> buttonLanjut;
    @Step("Clicking on button Lanjut")
    public void clickButtonLanjut() {
        log.info("Clicking on button Lanjut");
        performScroll(0.2);
        for (WebElement button : buttonLanjut) {
            try {
                // Avoid loadingWait for every loop unless absolutely needed
                if (button.isDisplayed() && button.getText().trim().equalsIgnoreCase("Lanjut")) {
                    clickElement(button);
                    log.info("Clicked 'Lanjut' button.");
                    return;
                }
            } catch (Exception e) {
                log.debug("Skipping an element due to error: {}", e.getMessage());
            }
        }
        log.warn("'Lanjut' button not found or not clickable.");
    }

    @FindBy(id = "nama_penerima")
    public WebElement insertNamaPenerima;
    @Step("Insert nama penerima")
    public void setInsertNamaPenerima(String namaPenerima) {
        log.info("Insert nama penerima");
        clickElementandSendKeys(insertNamaPenerima, namaPenerima);
    }

    @FindBy(id = "telp_penerima")
    public WebElement insertTelponPenerima;
    @Step("Insert nomor telpon penerima")
    public void setInsertTelponPenerima( String telponPenerima) {
        log.info("Insert nomor telpon penerima");
        clickElementandSendKeys(insertTelponPenerima, telponPenerima);
    }

    @FindBy(id = "phone")
    public WebElement insertNomorHpPengirim;
    @Step("Insert nomor hp pengirim")
    public void setInsertNomorHpPengirim(String nomorHp) {
        log.info("Insert nomor hp pengirim");
        clickElementandClear(insertNomorHpPengirim);
        clickElementandSendKeys(insertNomorHpPengirim, nomorHp);
    }

    @FindBy(id = "email_penerima")
    public WebElement insertEmailPenerima;
    @Step("Insert email penerima")
    public void setInsertEmailPenerima(String emailPenerima) {
        log.info("Insert email penerima");
        clickElementandSendKeys(insertEmailPenerima, emailPenerima);
    }

    @FindBy(id = "kota_kecamatan_penerima")
    public WebElement insertKotaPenerima;
    @FindBy(id = "listTujuanKota")
    public WebElement resultKotaPenerima;
    @Step("Insert kota penerima")
    public void setInsertKotaPenerima(String kotaPenerima) {
        log.info("Insert kota penerima");
        clickElementandSendKeys(insertKotaPenerima, kotaPenerima);
        loadingWait(2);
        // Wait and select from suggestion list
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(), '" + kotaPenerima + "')]")
        ));
        suggestion.click();
    }

    @FindBy(id = "kelurahan")
    public WebElement chooseKelurahan;
    @Step("choose kelurahan penerima")
    public void chooseKelurahanPenerima(String kelurahanPenerima) {
        log.info("choose kelurahan penerima");
        clickElement(chooseKelurahan);
        // Create a Select object
        Select select = new Select(chooseKelurahan);
        // Select by visible text
        select.selectByVisibleText(kelurahanPenerima);
    }

    public void chooseKelurahanPengirim() {
        log.info("choose kelurahan pengirim");
        clickElement(chooseKelurahan);
        // Step 1: Initialize Select class
        loadingWait(2);
        Select select = new Select(chooseKelurahan);
        // Step 2: Select the 1st valid option (index 1, because index 0 is placeholder)
        select.selectByIndex(1);
    }

    @FindBy(id = "alamat_penerima")
    public WebElement insertAlamatPenerima;
    @Step("Insert alamat penerima")
    public void setInsertAlamatPenerima(String alamatPenerima) {
        log.info("Insert alamat penerima");
        clickElementandSendKeys(insertAlamatPenerima, alamatPenerima);
    }

    @FindBy(xpath = "//*[@id=\"blue\"]")
    public WebElement buttonKonfirmasiAlamat;
    @Step("click button konfirmasi alamat")
    public void clickButtonKonfirmasiAlamat() {
        log.info("click button konfirmasi alamat");
        clickElement(buttonKonfirmasiAlamat);
    }

    @FindBy(id = "kategori")
    public WebElement chooseKategori;
    @Step("click Pilih Kategori")
    public void clickPilihKategori() {
        log.info("click Pilih Kategori");
        clickElement(chooseKategori);
    }

    @FindBy(className = "btn-category")
    public List <WebElement> listKategoriElektronik;
    @Step("click Pilih Kategori Elektronik")
    public void clickListKategoriElektronik() {
        log.info("click Pilih Kategori Elektronik");
        for(WebElement kategori : listKategoriElektronik) {
            loadingWait(1);
            if(Objects.equals(kategori.getText(), "Elektronik")) {
                clickElement(kategori);
                break;
            }
        }
    }

    @FindBy(xpath = "//*[@id=\"modalPilihKategori\"]/div/div/div[2]/button")
    public WebElement buttonMengerti;
    @Step("click button Mengerti")
    public void clickButtonMengerti() {
        log.info("click button Mengerti");
        loadingWait(3);
        clickElement(buttonMengerti);
    }

    @FindAll({@FindBy(id = "lainya_input"),
            @FindBy(id = "deskripsi")})
    public WebElement insertDeskripsiBarang;
    @Step("insert deskripsi barang")
    public void setInsertDeskripsiBarang(String deskripsiBarang) {
        log.info("insert deskripsi barang");
        clickElementandSendKeys(insertDeskripsiBarang, deskripsiBarang);
    }

    @FindBy(id = "nilai_paket")
    public WebElement insertHargaBarang;
    @Step("insert harga barang")
    public void setInsertHargaBarang(String hargaBarang) {
        log.info("insert harga barang");
        clickElementandSendKeys(insertHargaBarang, hargaBarang);
    }

    @FindBy(id = "weights")
    public WebElement insertBeratBarang;
    @Step("insert berat barang")
    public void setInsertBeratBarang(String beratBarang) {
        log.info("insert berat barang");
        clickElementandSendKeys(insertBeratBarang, beratBarang);
    }

    @FindBy(id = "lengthx")
    public WebElement insertPanjangBarang;
    @Step("insert panjang barang")
    public void setInsertPanjangBarang(String panjangBarang) {
        log.info("insert panjang barang");
        clickElementandSendKeys(insertPanjangBarang, panjangBarang);
    }

    @FindBy(id = "widthx")
    public WebElement insertLebarBarang;
    @Step("insert lebar barang")
    public void setInsertLebarBarang(String lebarBarang) {
        log.info("insert lebar barang");
        clickElementandSendKeys(insertLebarBarang, lebarBarang);
    }

    @FindBy(id = "heightx")
    public WebElement insertTinggiBarang;
    @Step("insert tinggi barang")
    public void setInsertTinggiBarang(String tinggiBarang) {
        log.info("insert tinggi barang");
        clickElementandSendKeys(insertTinggiBarang, tinggiBarang);
        insertTinggiBarang.sendKeys(Keys.ENTER);
    }

    @FindBy(id = "total_transaksi")
    public WebElement textTotalTransaksi;
    @Step("get text total transaksi")
    public void getTotalTransaksi() {
        log.info("get text total transaksi");
        loadingWait(2);
        System.out.println("Total biaya = "+textTotalTransaksi.getText());
    }

    @FindBy(css = "label[for='checkbox']")
    public WebElement checkboxAsuransi;
    public void clickCheckboxAsuransi() {
        log.info("click checkbox asuransi");
        loadingWait(10);
        clickElement(checkboxAsuransi);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.elementToBeClickable(checkboxAsuransi)).click();
    }

    @FindBy(id = "total_final")
    public WebElement textTotalTransaksiFinal;
    @Step("get text total transaksi final")
    public void getTotalTransaksiFinal() {
        log.info("get text total transaksi final");
        loadingWait(2);
        System.out.println("Total biaya final = "+textTotalTransaksiFinal.getText());
    }

    @FindBy(id = "konfirmasi_ringkasan")
    public WebElement buttonKonfirmasiRingkasan;
    @Step("click button konfirmasi ringkasan")
    public void clickButtonKonfirmasiRingkasan() {
        log.info("click button konfirmasi ringkasan");
        clickElement(buttonKonfirmasiRingkasan);
    }

    @FindBy(id = "ptds_header_resi")
    public WebElement nomorResiSuccessTransaction;
    @Step("get text nomor resi")
    public void getTextNomorResiSuccessTransaction() {
        log.info("get text nomor resi");
        System.out.println("nomor resi = "+nomorResiSuccessTransaction.getText());
    }

    @FindBy(id = "kt_penerima")
    public WebElement insertKodetoko;
    @Step("Insert kodetoko penerima")
    public void setInsertKodetoko(String kodetokoPenerima) {
        log.info("Insert kodetoko penerima");
        clickElementandSendKeys(insertKodetoko, kodetokoPenerima);
    }

    @FindBy(className = "wrapListKotas")
    public List <WebElement> resultListKodetoko;
    @Step("choose kodetoko penerima")
    public void chooseKodetokoPenerima() {
        log.info("choose kodetoko penerima");
        loadingWait(2);
        clickElement(resultListKodetoko.getFirst());
    }

    @Step("choose kodetoko pilihan")
    public void chooseKodetokoPilihan() {
        log.info("choose kodetoko pilihan");
        clickElement(resultListKodetoko.getFirst());
    }

    @Step("Clicking on checkbox Penerima")
    public void clickCheckboxPenerima() {
        log.info("Click on checkbox penerima");
        loadingWait(3);
        driver.findElement(By.cssSelector("label[for='checkbox']")).click();
    }

    @FindBy(id = "kodetoko_pengirim")
    public WebElement fieldKodetokoPilihan;
    @Step("Insert kodetoko pilihan")
    public void insertKodetokoPilihan(String kodetokoPilihan) {
        log.info("Insert kodetoko pilihan");
        clickElementandSendKeys(fieldKodetokoPilihan, kodetokoPilihan);
//        fieldKodetokoPilihan.sendKeys(Keys.ENTER);
        loadingWait(5);
    }

    @FindBy(id = "kt_penerima")
    public WebElement insertKodetokoPenerimaPaketJemput;
    @Step("Insert kodetoko pengirim")
    public void setInsertKodetokoPenerima(String kodetokoPenerimaPaketJemput) {
        log.info("Insert kodetoko penerima");
        clickElementandSendKeys(insertKodetokoPenerimaPaketJemput, kodetokoPenerimaPaketJemput);
        insertKodetokoPenerimaPaketJemput.sendKeys(Keys.ENTER);
        loadingWait(5);
    }

    @FindBy(id = "alamat_pengirim")
    public WebElement insertAlamatPengirim;
    @Step("Insert alamat pengirim")
    public void setInsertAlamatPengirim(String alamat) {
        log.info("Insert alamat pengirim");
        clickElementandClear(insertAlamatPengirim);
        clickElementandSendKeys(insertAlamatPengirim, alamat);
    }

    @FindBy(id = "shNotes")
    public WebElement insertCatatan;
    @Step("Insert catatan pengirim")
    public void setInsertCatatanPengirim(String catatan) {
        log.info("Insert catatan pengirim");
        clickElementandClear(insertCatatan);
        clickElementandSendKeys(insertCatatan, catatan);
    }

    @FindBy(className = "pilih-waktu-jemput")
    public WebElement buttonPilihWaktuJemput;
    @Step("click button pilih waktu jemput")
    public void clickButtonPilihWaktuJemput() {
        log.info("click button pilih waktu jemput");
        clickElement(buttonPilihWaktuJemput);
    }

    @FindBy(id = "confirm-btn")
    public WebElement buttonKonfirmasiWaktuJemput;
    @Step("click button konfirmasi waktu jemput")
    public void clickButtonKonfirmasiWaktuJemput() {
        log.info("click button konfirmasi waktu jemput");
        clickElement(buttonKonfirmasiWaktuJemput);
    }

    @FindBy(id = "kota_kecamatan_pengirim")
    public WebElement insertKotaKecamatanPengirim;
    @Step("Insert kota/kecamatan pengirim")
    public void setInsertKotaKecamatanPengirim(String kotaKecamatanPengirim) {
        log.info("Insert kota/kecamatan pengirim");
        clickElementandClear(insertKotaKecamatanPengirim);
        loadingWait(1);
        clickElementandSendKeys(insertKotaKecamatanPengirim, kotaKecamatanPengirim);
    }

    @FindBy(className = "wrapListKota")
    public List <WebElement> resultListKotaPengirim;
    @Step("choose kota kecamatan pengirim")
    public void chooseKotaKecamatanPengirim() {
        log.info("choose kota kecamatan pengirim");
        clickElement(resultListKotaPengirim.getFirst());
    }

}