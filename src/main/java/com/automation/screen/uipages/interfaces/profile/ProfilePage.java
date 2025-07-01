package com.automation.screen.uipages.interfaces.profile;

public interface ProfilePage {
    void clickButtonEditProfile();
    void setInsertNamaPengirim(String namaPengirim);
    void setInsertNomorHpPengirim(String nomorHp);
    void setInsertAlamatPengirim(String alamat);
    void chooseProvince(String province);
    void chooseCity(String city);
    void chooseDistrict(String district);
    void chooseSubDistrict(String subdistrict);
    void choosePostalCode(String postalcode);
    void clickButtonSimpan();
    void clickButtonTutupAkun();
    void setInsertPassword(String password);
    void clickButtonKonfirmasiTutupAkun();
    void clickButtonBatalTutupAkun();
    void setInsertCurrentPassword(String currentPassword);
    void setInsertNewPassword(String newPassword);
    void setInsertConfirmNewPassword(String confirmNewPassword);
}
