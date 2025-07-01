package com.automation.screen.uipages.desktop.profile;

import com.automation.base.BasePage;
import com.automation.screen.uipages.interfaces.profile.RiwayatPage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;

@Slf4j
public class RiwayatPageDesktop extends BasePage implements RiwayatPage {
    public RiwayatPageDesktop(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "value_resi")
    public WebElement fieldSearchRiwayat;
    @Step("Insert resi for search riwayat")
    public void setFieldSearchRiwayat(String nomorResi) {
        log.info("Insert resi for search riwayat");
        clickElementandSendKeys(fieldSearchRiwayat, nomorResi);
    }

    @FindBy(id = "icon_search")
    public WebElement iconSearch;
    @Step("click button icon search riwayat")
    public void clickButtonIconSearch() {
        log.info("click icon search");
        clickElement(iconSearch);
    }

    @FindBy(id = "button-filter")
    public WebElement buttonFilter;
    @Step("click button filter riwayat")
    public void clickButtonFilter() {
        log.info("click button filter");
        clickElement(buttonFilter);
        loadingWait(1);
    }

    @FindBy(xpath = "//a[text()='Semua']")
    public WebElement buttonFilterSemua;
    @Step("click button filter semua")
    public void clickButtonFilterSemua() {
        log.info("click button filter Semua");
        clickElement(buttonFilterSemua);
    }

    @FindBy(xpath = "//*[@id=\"ul_filter\"]/li[3]/a")
    public WebElement buttonFilterMulai;
    @Step("click button filter mulai")
    public void clickButtonFilterMulai() {
        log.info("click button filter mulai");
        clickElement(buttonFilterMulai);
    }

    @FindBy(xpath = "//*[@id=\"ul_filter\"]/li[5]/a")
    public WebElement buttonFilterDiterimaDariPengirim;
    @Step("click button filter diterima dari pengirim")
    public void clickButtonFilterDiterimaDariPengirim() {
        log.info("click button filter diterima dari pengirim");
        clickElement(buttonFilterDiterimaDariPengirim);
    }

    @FindBy(xpath = "//*[@id=\"ul_filter\"]/li[7]/a")
    public WebElement buttonFilterProsesPengiriman;
    @Step("click button filter proses pengiriman")
    public void clickButtonFilterProsesPengiriman() {
        log.info("click button filter proses pengiriman");
        clickElement(buttonFilterProsesPengiriman);
    }

    @FindBy(xpath = "//*[@id=\"ul_filter\"]/li[9]/a")
    public WebElement buttonFilterSiapDiambilDiantar;
    @Step("click button filter siap diambil/diantar")
    public void clickButtonFilterSiapDiambilDiantar() {
        log.info("click button filter siap diambil/diantar");
        clickElement(buttonFilterSiapDiambilDiantar);
    }

    @FindBy(xpath = "//*[@id=\"ul_filter\"]/li[11]/a")
    public WebElement buttonFilterSudahDiambil;
    @Step("click button filter sudah diambil")
    public void clickButtonFilterSudahDiambil() {
        log.info("click button filter sudah diambil");
        clickElement(buttonFilterSudahDiambil);
    }

    @FindBy(xpath = "//*[@id=\"ul_filter\"]/li[13]/a")
    public WebElement buttonFilterSedangDiantar;
    @Step("click button filter sedang diantar")
    public void clickButtonFilterSedangDiantar() {
        log.info("click button filter sedang diantar");
        clickElement(buttonFilterSedangDiantar);
    }

    @FindBy(xpath = "//*[@id=\"ul_filter\"]/li[15]/a")
    public WebElement buttonFilterSudahDiantar;
    @Step("click button filter sudah diantar")
    public void clickButtonFilterSudahDiantar() {
        log.info("click button filter sudah diantar");
        clickElement(buttonFilterSudahDiantar);
    }

    @FindBy(xpath = "//*[@id=\"ul_filter\"]/li[17]/a")
    public WebElement buttonFilterRetur;
    @Step("click button filter retur")
    public void clickButtonFilterRetur() {
        log.info("click button filter retur");
        clickElement(buttonFilterRetur);
    }

    @FindBy(id = "konfirmasi_ringkasan")
    public List<WebElement> detilRiwayat;
    @Step("click button detil riwayat")
    public void clickButtonDetilRiwayat() {
        log.info("click button detil riwayat");
        clickElement(detilRiwayat.getFirst());
    }

    @FindBy(css = "div.col-md-6.responsive-title")
    public WebElement textDetilServiceName;
    @FindBy(css = "div.ta-right")
    public WebElement textDetilNomorResi;
    @Step("get text detil service name and nomor resi")
    public String getDetilServiceName() {
        log.info("get text detil service name and nomor resi");
        loadingWait(3);
        System.out.println("Service name = "+textDetilServiceName.getText());
        System.out.println("Nomor Resi = "+textDetilNomorResi.getText());
        return textDetilServiceName.getText();
    }

    @FindBy(xpath = "//*[@id=\"myDIV\"]/div[4]/input")
    public WebElement jamPenjemputan;
    @FindBy(xpath = "//*[@id=\"myDIV\"]/div[4]/label")
    public WebElement textJadwalJemput;

    @Step("Check jam penjemputan")
    public void checkJamPenjemputan() {
        String jenisTransaksi = getDetilServiceName();
        if(Objects.equals(jenisTransaksi, "JEMPUT DAN AMBIL DI TOKO")) {
            Assert.assertEquals(textJadwalJemput.getText(), "Jadwal Jemput");
            System.out.print("Jadwal jemput = "+jamPenjemputan.getAttribute("value")+"\n");
        } else {
            System.out.print("Jadwal jemput doesn't exist");
        }
    }

    @FindBy(id = "unduh-desktop")
    public WebElement buttonUnduhResi;
    @Step("click button unduh label resi")
    public void clickButtonUnduhResi() {
        log.info("click button unduh label resi");
        clickElement(buttonUnduhResi);
    }

    @FindBy(id = "konfirmasi_ringkasan")
    public WebElement buttonKonfirmasiRingkasan;
    @Step("click button Lihat Detail")
    public void clickButtonLihatDetail() {
        log.info("click button Lihat Detail");
        clickElement(buttonKonfirmasiRingkasan);
    }

    @FindBy(className = "btn-batal-awb")
    public WebElement buttonBatalkanAWB;
    @Step("click button batalkan AWB")
    public void clickButtonBatalkanAWB() {
        log.info("click button batalkan AWB");
        clickElement(buttonBatalkanAWB);
    }

    @FindBy(className = "btn-reason")
    public List <WebElement> listReasonBatalAWB;
    @Step("click reason batalkan AWB")
    public void clickReasonBatalkanAWB() {
        log.info("click reason batalkan AWB");
        String[] options = {"Ubah data pengiriman", "Permintaan khusus pengirim", "Ganti Jasa Kirim"};
        Random rand = new Random();
        String randomReason = options[rand.nextInt(options.length)];
        for(WebElement reason : listReasonBatalAWB) {
            if(randomReason.equalsIgnoreCase(reason.getAttribute("data-value"))) {
                reason.click();
                break;
            }
        }
    }

    @FindBy(className = "btn-konfirmasi-pembatalan")
    public WebElement buttonKonfirmasiBatalkanAWB;
    @Step("click button konfirmasi batalkan AWB")
    public void clickButtonKonfirmasiBatalkanAWB() {
        log.info("click button konfirmasi batalkan AWB");
        clickElement(buttonKonfirmasiBatalkanAWB);
    }
}