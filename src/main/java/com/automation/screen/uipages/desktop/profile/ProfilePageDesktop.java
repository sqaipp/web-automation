package com.automation.screen.uipages.desktop.profile;

import com.automation.base.BasePage;
import com.automation.screen.uipages.interfaces.profile.ProfilePage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;

@Slf4j
public class ProfilePageDesktop extends BasePage implements ProfilePage {
    public ProfilePageDesktop(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "edit-button")
    public WebElement buttonEditProfile;
    @Step("Clicking on button edit profile")
    public void clickButtonEditProfile() {
        log.info("Clicking button edit profile");
        clickElement(buttonEditProfile);
    }

    @FindBy(id = "nama")
    public WebElement insertNamaPengirim;
    @Step("Insert nama pengirim")
    public void setInsertNamaPengirim(String namaPengirim) {
        log.info("Insert nama pengirim");
        clickElementandClear(insertNamaPengirim);
        clickElementandSendKeys(insertNamaPengirim, namaPengirim);
    }

    @FindBy(id = "phone")
    public WebElement insertNomorHpPengirim;
    @Step("Insert nomor hp pengirim")
    public void setInsertNomorHpPengirim(String nomorHp) {
        log.info("Insert nomor hp pengirim");
        clickElementandClear(insertNomorHpPengirim);
        clickElementandSendKeys(insertNomorHpPengirim, nomorHp);
    }

    @FindBy(id = "alamat")
    public WebElement insertAlamatPengirim;
    @Step("Insert alamat pengirim")
    public void setInsertAlamatPengirim(String alamat) {
        log.info("Insert alamat pengirim");
        clickElementandClear(insertAlamatPengirim);
        clickElementandSendKeys(insertAlamatPengirim, alamat);
    }

    @FindBy(id = "provinsi")
    public WebElement dropDownMenuProvince;
    @Step("click and choose drop down menu province")
    public void chooseProvince(String province) {
        log.info("click and choose drop down menu province");
        clickElement(dropDownMenuProvince);
        // Create a Select object
        Select select = new Select(dropDownMenuProvince);
        // Select by value
        select.selectByVisibleText(province);
    }

    @FindBy(id = "kota")
    public WebElement dropDownMenuCity;
    @Step("click and choose drop down menu city")
    public void chooseCity(String city) {
        log.info("click and choose drop down menu city");
        clickElement(dropDownMenuCity);
        // Create a Select object
        Select select = new Select(dropDownMenuCity);
        // Select by value
        select.selectByVisibleText(city);
    }

    @FindBy(id = "kecamatan")
    public WebElement dropDownMenuDistrict;
    @Step("click and choose drop down menu district")
    public void chooseDistrict(String district) {
        log.info("click and choose drop down menu district");
        clickElement(dropDownMenuDistrict);
        // Create a Select object
        Select select = new Select(dropDownMenuDistrict);
        // Select by value
        select.selectByVisibleText(district);
    }
    @FindBy(id = "kelurahan")
    public WebElement dropDownMenuSubDistrict;
    @Step("click and choose drop down menu district")
    public void chooseSubDistrict(String subdistrict) {
        log.info("click and choose drop down menu subdistrict");
        clickElement(dropDownMenuSubDistrict);
        // Create a Select object
        Select select = new Select(dropDownMenuSubDistrict);
        // Select by value
        select.selectByVisibleText(subdistrict);
    }

    @FindBy(id = "kd_pos")
    public WebElement dropDownMenuPostalCode;
    @Step("click and choose drop down menu postal code")
    public void choosePostalCode(String postalcode) {
        log.info("click and choose drop down menu postalcode");
        clickElement(dropDownMenuPostalCode);
        // Create a Select object
        Select select = new Select(dropDownMenuPostalCode);
        // Select by value
        select.selectByVisibleText(postalcode);
    }

    @FindBy(id = "final-submit")
    public WebElement buttonSimpan;
    @Step("click on button simpan")
    public void clickButtonSimpan() {
        log.info("click button simpan");
        clickElement(buttonSimpan);
    }

    @FindBy(id = "delete-account-button")
    public WebElement buttonTutupAkun;
    @Step("click on button tutup akun")
    public void clickButtonTutupAkun() {
        log.info("click button tutup akun");
        scrollIntoView(buttonTutupAkun);
        clickElement(buttonTutupAkun);
    }

    @FindBy(id = "textPassword")
    public WebElement insertPassword;
    @Step("insert password for tutup akun")
    public void setInsertPassword(String password) {
        log.info("insert password for tutup akun");
        clickElementandSendKeys(insertPassword, password);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[2]/center/div/div/div/div/button[2]/span")
    public WebElement buttonKonfirmasiTutupAkun;
    @Step("click on button konfirmasi tutup akun")
    public void clickButtonKonfirmasiTutupAkun() {
        log.info("click button konfirmasi tutup akun");
        clickElement(buttonKonfirmasiTutupAkun);
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div[2]/center/div/div/div/div/button[3]/span")
    public WebElement buttonBatalTutupAkun;
    @Step("click on button batal tutup akun")
    public void clickButtonBatalTutupAkun() {
        log.info("click button batal tutup akun");
        loadingWait(2);
        clickElement(buttonBatalTutupAkun);
    }

    @FindBy(id = "current-password")
    public WebElement insertCurrentPassword;
    @Step("insert current password")
    public void setInsertCurrentPassword(String currentPassword) {
        log.info("insert current password");
        clickElementandSendKeys(insertCurrentPassword, currentPassword);
    }

    @FindBy(id = "password-baru")
    public WebElement insertNewPassword;
    @Step("insert new password")
    public void setInsertNewPassword(String newPassword) {
        log.info("insert new password");
        clickElementandSendKeys(insertNewPassword, newPassword);
    }

    @FindBy(id = "konfirmasi-password")
    public WebElement insertConfirmNewPassword;
    @Step("insert confirm new password")
    public void setInsertConfirmNewPassword(String confirmNewPassword) {
        log.info("insert confirm new password");
        clickElementandSendKeys(insertConfirmNewPassword, confirmNewPassword);
    }

}