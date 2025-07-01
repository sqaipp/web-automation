package com.automation.screen.uipages.homepages;

import com.automation.base.base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;


@Slf4j
public class homePage extends BasePage {

    public homePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"wi\"]/div[1]/div[2]/div/div/div/div[3]/div/a[2]")
    public WebElement buttonMasuk;

    @FindBy(xpath = "//*[@id=\"wi\"]/div[1]/div[2]/div/div/div/div[3]/div/a[1]")
    public WebElement buttonDaftar;

    @FindBy(xpath = "/html/body/div/div/section/div[1]/div/div/div/form/div[1]/div[2]/a")
    public WebElement buttonLupaPassword;

    @FindBy(id = "span_menu")
    public WebElement buttonBeranda;

    @FindBy(id = "menu_tracking")
    public WebElement buttonTracking;

    @FindBy(id = "menu_cek_tarif")
    public WebElement buttonCekTarif;

    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[4]/a")
    public WebElement buttonKirimSekarang;

    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[5]/a")
    public WebElement buttonCariToko;

    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[6]/a")
    public WebElement buttonTentangKamiBeforeLogin;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div/div/div[2]/div/nav/div[2]/ul/li[8]/a")
    public WebElement buttonMembership;

    @FindBy(id = "value_resi")
    public WebElement fieldInputResi;

    @FindBy(id = "trackingNumbers")
    public WebElement fieldInputMultiResi;

    @FindAll({@FindBy(id = "modal_resi"),
            @FindBy(xpath = "//*[@id=\"wi\"]/div[2]/div/div[2]/div/div[2]/button")})
    public WebElement buttonSearchResi;

    @FindBy(id = "teks")
    public WebElement textCapcha;

    @FindBy(id = "text")
    public WebElement fieldTextCapcha;

    @FindBy(id = "span_captcha")
    public WebElement buttonTerapkanCapcha;

    @FindBy(id = "modal_resi_multi")
    public WebElement buttonMultiResi;

    @FindBy(id = "stringAsalKota")
    public WebElement asalKota;

    @FindBy(xpath = "//*[@id=\"listAsalKota\"]/div/a")
    public WebElement resultAsalKota;

    @FindBy(id = "stringTujuanKota")
    public WebElement tujuanKota;

    @FindBy(xpath = "//*[@id=\"listTujuanKota\"]/div/a[1]")
    public WebElement resultKotaTujuan;

    @FindBy(id = "weight")
    public WebElement inputBerat;

    @FindBy(id = "width")
    public WebElement inputDimensiPanjang;

    @FindBy(id = "length")
    public WebElement inputDimensiLebar;

    @FindBy(id = "height")
    public WebElement inputDImensiTinggi;

    @FindBy(id = "cekHome")
    public WebElement buttonCheckTarif;

    @FindBy(xpath = "//*[@id=\"wi\"]/div[1]/div[2]/div/div/div/div[3]/div/div[2]/ul/li[1]/a")
    public WebElement buttonEditProfile;

    @FindBy(xpath = "//*[@id=\"wi\"]/div[1]/div[2]/div/div/div/div[3]/div/div[2]/ul/li[2]/a")
    public WebElement buttonEditPassword;

    @FindBy(xpath = "//*[@id=\"wi\"]/div[1]/div[2]/div/div/div/div[3]/div/div[2]/ul/li[3]/a")
    public WebElement buttonRiwayat;

    @FindBy(xpath = "//*[@id=\"wi\"]/div[1]/div[2]/div/div/div/div[3]/div/div[2]/ul/li[4]/a")
    public WebElement buttonSurveyPengiriman;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div/div/div[3]/div/div[1]")
    public WebElement buttonNotification;

    @FindBy(className = "wrap-title")
    public List<WebElement> listDetilNotification;

    @FindBy(id = "info_promo")
    public WebElement buttonInfoPromo;

    @FindBy(id = "status_paket")
    public WebElement buttonStatusPaket;

    @FindBy(name = "bulk[]")
    public List <WebElement> listCheckboxNotification;

    @FindBy(id = "bulk-delete")
    public WebElement buttonDeleteNotification;

    @FindBy(xpath = "//button[text()='Ya']")
    public WebElement buttonConfirmDeleteNotification;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement buttonSuccessDeleteNotification;

    @FindBy(xpath = "//*[@id=\"table_data\"]/div[3]/a")
    public WebElement buttonLihatSemuaNotifikasi;

    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[6]/a")
    public WebElement buttonOTP;

    @FindBy(xpath = "//a[@href='https://webd.indopaket.co.id/tentang-kami']")
    public WebElement buttonTentangKamiAfterLogin;

    @FindBy(xpath = "//a[@href='https://webd.indopaket.co.id/layanan']")
    public WebElement buttonLayananProgram;

    @FindBy(xpath = "//a[@href='https://webd.indopaket.co.id/tutorial']")
    public WebElement buttonTutorial;

    @FindBy(xpath = "//a[@href='https://webd.indopaket.co.id/faq']")
    public WebElement buttonFAQ;

    @FindBy(xpath = "//a[@href='https://webd.indopaket.co.id/syarat-ketentuan']")
    public WebElement buttonSyaratKetentuan;

    @FindBy(xpath = "//a[@href='https://webd.indopaket.co.id/kebijakan']")
    public WebElement buttonKebijakan;

    @FindBy(xpath = "//a[@title='Instagram']")
    public WebElement iconInstagram;

    @FindBy(xpath = "//a[@title='Facebook']")
    public WebElement iconFacebook;

    @FindBy(xpath = "//a[@title='Tiktok']")
    public WebElement iconTiktok;

    @FindBy(xpath = "//a[@title='Youtube']")
    public WebElement iconYoutube;

    @FindBy(className = "alamat-footer-content")
    public WebElement textOfficeAddress;


    public void clickBtnMasukForLogin() {
        log.info("Clicking on button Login ");
        clickElement(buttonMasuk);
    }

    public void clickBtnDaftar() {
        log.info("Clicking on button daftar ");
        clickElement(buttonDaftar);
    }

    public void clickBtnBeranda() {
        log.info("Clicking on Button Beranda ");
        clickElement(buttonBeranda);
    }

    public void clickBtnTracking() {
        log.info("Clicking on Button Tracking ");
        clickElement(buttonTracking);
    }

    public void clickBtnCekTarif() {
        log.info("Clicking on Button Cek Tarif ");
        clickElement(buttonCekTarif);
    }

    public void clickBtnKirimSekarang() {
        log.info("Clicking on Button Kirim Sekarang ");
        clickElement(buttonKirimSekarang);
    }

    public void clickBtnCariToko() {
        log.info("Clicking on Button Cari Toko ");
        clickElement(buttonCariToko);
    }

    public void clickBtnTentangKamiBeforeLogin() {
        log.info("Clicking on Button Tentang Kami ");
        clickElement(buttonTentangKamiBeforeLogin);
    }

    public void clickBtnLayananDanProgram() {
        log.info("Clicking on Button Layanan & Program ");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        clickElement(buttonLayananProgram);
    }

    public void clickBtnTutorial() {
        log.info("Clicking on Button Tutorial");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        clickElement(buttonTutorial);
    }


    public void clickBtnMembership() {
        log.info("Clicking on Button Membership ");
        clickElement(buttonMembership);
    }

    public void clickBtnLupaPassword() {
        log.info("Clicking on Button Lupa Password ");
        clickElement(buttonLupaPassword);
    }

    public void inputResi(String noResi) {
        log.info("Inut nomor resi");
        clickElementandSendKeys(fieldInputResi, noResi);
    }

    public void clickButtonMultiResi() {
        log.info("Click on button multi resi");
        clickElement(buttonMultiResi);
    }

    public void inputMultiResi(String noMultiResi) {
        log.info("Input nomor multi resi");
        clickElementandSendKeys(fieldInputMultiResi, noMultiResi);
    }

    public void clickBtnSearchResi() {
        log.info("Clicking on Button Search Resi ");
        clickElement(buttonSearchResi);
    }

    public void clickButtonTentangKami() {
        log.info("Clicking on Button Tentang Kami");
        clickElement(buttonTentangKamiBeforeLogin);
    }

    public void insertCapcha() {
        log.info("get text capcha and insert");
        clickElementandSendKeys(fieldTextCapcha, textCapcha.getAttribute("textContent")); // langsung input semua char captcha
//        char[] captcha = textCapcha.getAttribute("textContent").toCharArray();
//        for (char c : captcha) { // input per char satu per satu
//            clickElementandSendKeys(fieldTextCapcha, String.valueOf(c));
//        }
//        loadingWait(1);
        clickElement(buttonTerapkanCapcha);
    }

    public void inputAsalKota(String kotaAsal) {
        log.info("Input asal kota for cek tarif");
        clickElementandSendKeys(asalKota,kotaAsal);
        loadingWait(3);
        clickElement(resultAsalKota);
    }

    public void inputTujuanKota(String kotaTujuan) {
        log.info("Input tujuan kota for cek tarif");
        clickElementandSendKeys(tujuanKota,kotaTujuan);
        loadingWait(3);
        clickElement(resultKotaTujuan);
    }

    public void inputBerat() {
        log.info("Input berat paket for cek tarif");
        clickElementandClear(inputBerat);
        clickElementandSendKeys(inputBerat,"5");
    }

    public void inputDimensiPanjang() {
        log.info("Input panjang paket for cek tarif");
        find(inputDimensiPanjang,2);
        clickElementandSendKeys(inputDimensiPanjang,"50");
    }
    public void inputDimensiLebar() {
        log.info("Input lebar paket for cek tarif");
        clickElementandSendKeys(inputDimensiLebar,"30");
    }

    public void inputDimensiTinggi() {
        log.info("Input tinggi paket for cek tarif");
        clickElementandSendKeys(inputDImensiTinggi,"40");
    }

    public void clickButtonCekTarif() {
        log.info("Click button cek tarif");
        clickElement(buttonCheckTarif);
    }

    @FindBy(id = "span_profil")
    public WebElement buttonProfile;
    public void clickButtonProfile() {
        log.info("Clicking Button Profile");
        clickElement(buttonProfile);
    }

    public void clickDropdownMenuEditProfile() {
        log.info("Clicking Button Edit Profile");
        clickElement(buttonEditProfile);
    }

    public void clickDropdownMenuEditPassword() {
        log.info("Clicking Button Edit Password");
        clickElement(buttonEditPassword);
    }

    public void clickButtonRiwayat() {
        log.info("Clicking on button Riwayat ");
        clickElement(buttonRiwayat);
    }

    public void clickButtonSurveyPengiriman() {
        log.info("Clicking on button survey pengiriman ");
        clickElement(buttonSurveyPengiriman);
    }

    public void clickButtonNotification() {
        log.info("Clicking on button notification");
        clickElement( buttonNotification);
    }

    public void clickButtonInfoPromo() {
        log.info("Clicking on button info & promo");
        clickElement( buttonInfoPromo);
    }

    @Step("click button detil notification")
    public void clickButtonDetilNotification() {
        log.info("click button detil notification");
        clickElement(listDetilNotification.getFirst());
    }

    public void clickButtonSTatusPaket() {
        log.info("Clicking on button status paket");
        clickElement(buttonStatusPaket);
    }

    public void clickCheckboxNotification() {
        log.info("Clicking on checkbox notification");
        clickElement(listCheckboxNotification.getFirst());
    }

    public void clickButtonDeleteNotification() {
        log.info("Clicking on button delete notification");
        clickElement(buttonDeleteNotification);
    }

    public void clickButtonConfirmDeleteNotification() {
        log.info("Clicking on button confirm delete notification");
        loadingWait(2);
        clickElement(buttonConfirmDeleteNotification);
    }

    public void clickButtonSuccessDeleteNotification() {
        log.info("Clicking on button Success confirm delete notification");
        loadingWait(2);
        clickElement(buttonSuccessDeleteNotification);
    }

    public void clickButtonLihatSemuaNotifikasi() {
        log.info("Clicking on button liat semua notifikasi");
        loadingWait(2);
        clickElement(buttonLihatSemuaNotifikasi);
    }

    public void clickButtonOTP() {
        log.info("Clicking on button OTP ");
        loadingWait(2);
        clickElement(buttonOTP);
    }

    public void clickBtnTentangKamiAfterLogin() {
        log.info("Clicking on Button Tentang Kami ");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        loadingWait(2);
        clickElement(buttonTentangKamiAfterLogin);
    }

    public void clickBtnLayananProgram() {
        log.info("Clicking on Button Layanan & Program");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        loadingWait(2);
        clickElement(buttonLayananProgram);
    }

    public void clickBtnFAQ() {
        log.info("Clicking on Button FAQ");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        loadingWait(2);
        clickElement(buttonFAQ);
    }
    public void clickBtnSyaratKetentuan() {
        log.info("Clicking on Button Syarat & Ketentuan");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        loadingWait(2);
        clickElement(buttonSyaratKetentuan);
    }

    public void clickBtnKebijakan() {
        log.info("Clicking on Button Kebijakan");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        loadingWait(2);
        clickElement(buttonKebijakan);
    }

    public void getURLInstagram() {
        log.info("get URL Instagram");
        System.out.println(iconInstagram.getAttribute("href"));
    }

    public void getURLFacebook() {
        log.info("get URL Facebook");
        System.out.println(iconFacebook.getAttribute("href"));
    }

    public void getURLTiktok() {
        log.info("get URL Tiktok");
        System.out.println(iconTiktok.getAttribute("href"));
    }

    public void getURLYoutube() {
        log.info("get URL Youtube");
        System.out.println(iconYoutube.getAttribute("href"));
    }

    public String getTextOfficeAddress() {
        log.info("get text office address");
        return textOfficeAddress.getText();
    }

}