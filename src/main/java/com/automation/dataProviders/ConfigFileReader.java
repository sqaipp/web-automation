package com.automation.dataProviders;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigFileReader {

    public static Properties properties;
    public static final String propertyFilePathAppium = "src/test/java/com/automation/environment/appium.properties";
    public static final String propertyFilePathUAT = "src/test/java/com/automation/environment/uat.properties";
    public static final String propertyFilePathTOPROD = "src/test/java/com/automation/environment/to-prod.properties";

    public static Properties ConfigFileReaderAppium() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePathAppium));

            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePathAppium);
        }
        return properties;
    }


    public Properties ConfigFileReaderact() {
        BufferedReader reader;
        try {
            if(getPropertyEnvironment().equalsIgnoreCase("uat")) {
                reader = new BufferedReader(new FileReader(propertyFilePathUAT));
            } else {
                reader = new BufferedReader(new FileReader(propertyFilePathTOPROD));
            }
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePathUAT);
        }
        return properties;
    }

    /**
     * appium.properties
     */

    public static String getPropertyEnvironment() {
        String environment = ConfigFileReaderAppium().getProperty("environment");
        if (environment != null) return environment;
        else throw new RuntimeException("environment not specified in the appium.properties file.");
    }



    public String getUrl() {
        String url = ConfigFileReaderAppium().getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the appium.properties file.");
    }

    /**
     * uat/to-prod.properties
     */

    public String getTestUrlWebsite() {
        //String testUrl = ConfigFileReaderact().getProperty("urlUAT"); // UAT
        String testUrl = ConfigFileReaderact().getProperty("testUrl"); // DEV
        if (testUrl != null) return testUrl;
        else throw new RuntimeException("testUrl not specified in the file.");
    }
    public String getSystemProperty_Server() {
        String sysProperty = ConfigFileReaderact().getProperty("serverProperty");
        if (sysProperty != null) return sysProperty;
        else throw new RuntimeException("sysProperty not specified in the file.");
    }
    public String getBrowserName() {
        String browserName = ConfigFileReaderact().getProperty("browsername");
        if (browserName != null) return browserName;
        else throw new RuntimeException("browserName not specified in the file.");
    }

    public String getWebType() {
        String type = ConfigFileReaderact().getProperty("web_type");
        if (type != null) return type;
        else throw new RuntimeException("web_type not specified in the file.");
    }

    public String getSystemProperty_Local() {
        String sysProperty = ConfigFileReaderact().getProperty("localProperty");
        if (sysProperty != null) return sysProperty;
        else throw new RuntimeException("testUrl not specified in the file.");
    }

    public String getSystemProperty_LocalSafari() {
        String sysProperty = ConfigFileReaderact().getProperty("localPropertySafari");
        if (sysProperty != null) return sysProperty;
        else throw new RuntimeException("testUrl not specified in the file.");
    }

    public String getTestDataFilePath() {
        String data_test_file_path = ConfigFileReaderact().getProperty("data_test_file_path");
        if (data_test_file_path != null) return data_test_file_path;
        else throw new RuntimeException("data_test_file_path not specified in the file.");
    }

    public String getUsername() {
        String username = ConfigFileReaderact().getProperty("username");
        if (username != null) return username;
        else throw new RuntimeException("username not specified in the file.");
    }

    public String getWrongUsername() {
        String wrongUsername = ConfigFileReaderact().getProperty("wrongUsername");
        if (wrongUsername != null) return wrongUsername;
        else throw new RuntimeException("wrongUsername not specified in the file.");
    }

    public String getPhoneNumberforRegis() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        String dynamics_phonenumber = "08" + dateFormat.format(currentDate);
        System.out.println("Formatted Date: " + dynamics_phonenumber);
        return dynamics_phonenumber;
    }

    public String getPassword() {
        String password = ConfigFileReaderact().getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("password not specified in the file.");
    }

    public String getWrongPassword() {
        String wrongPassword = ConfigFileReaderact().getProperty("wrongPassword");
        if (wrongPassword != null) return wrongPassword;
        else throw new RuntimeException("wrong password not specified in the file.");
    }

    public String getPasswordLessThan() {
        String passwordLessThan = ConfigFileReaderact().getProperty("passwordLessThan");
        if (passwordLessThan != null) return passwordLessThan;
        else throw new RuntimeException("password less than not specified in the file.");
    }

    public String getNoResi() {
        String nomorResi = ConfigFileReaderact().getProperty("nomor_resi");
        if (nomorResi != null) return nomorResi;
        else throw new RuntimeException("nomor resi not specified in the file.");
    }

    public String getNoResiNotFound() {
        String nomorResi = ConfigFileReaderact().getProperty("nomor_resi_not_found");
        if (nomorResi != null) return nomorResi;
        else throw new RuntimeException("nomor resi not specified in the file.");
    }

    public String getNoMultiResi() {
        String nomorMultiResi = ConfigFileReaderact().getProperty("nomor_multi_resi");
        if (nomorMultiResi != null) return nomorMultiResi;
        else throw new RuntimeException("multi resi not specified in the file.");
    }

    public String getNoMultiResiNotFound() {
        String nomorMultiResi = ConfigFileReaderact().getProperty("nomor_multi_resi_not_found");
        if (nomorMultiResi != null) return nomorMultiResi;
        else throw new RuntimeException("multi resi not specified in the file.");
    }

    public String getEmail() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        String dynamics_email = "QAEDTS_" + dateFormat.format(currentDate) + "@gmail.com";
        return dynamics_email;
    }

    public String getKotaAsal() {
        String kotaAsal = ConfigFileReaderact().getProperty("kota_asal");
        if (kotaAsal != null) return kotaAsal;
        else throw new RuntimeException("kota asal not specified in the file.");
    }

    public String getKotaTujuan() {
        String kotaAsal = ConfigFileReaderact().getProperty("kota_tujuan");
        if (kotaAsal != null) return kotaAsal;
        else throw new RuntimeException("kota tujuan not specified in the file.");
    }

    public String getWrongEmail() {
        String wrongEmail = ConfigFileReaderact().getProperty("wrong_email");
        if (wrongEmail != null) return wrongEmail;
        else throw new RuntimeException("wrong email not specified in the file.");
    }

    public String getEmailForgotPassword() {
        String emailForgotPassword = ConfigFileReaderact().getProperty("email_forgot_password");
        if (emailForgotPassword != null) return emailForgotPassword;
        else throw new RuntimeException("email_forgot_password not specified in the file.");
    }

    public String getNamaPengirim() {
        String namaPengirim = ConfigFileReaderact().getProperty("nama_pengirim");
        if (namaPengirim != null) return namaPengirim;
        else throw new RuntimeException("nama_pengirim not specified in the file.");
    }


    public String getNomorHpPengirim() {
        String nomorHPPngirim = ConfigFileReaderact().getProperty("nomor_hp_pengirim");
        if (nomorHPPngirim != null) return nomorHPPngirim;
        else throw new RuntimeException("nomor_hp_pengirim not specified in the file.");
    }

    public String getAlamatPengirim() {
        String alamatPengirim = ConfigFileReaderact().getProperty("alamat_pengirim");
        if (alamatPengirim != null) return alamatPengirim;
        else throw new RuntimeException("nomor_hp_pengirim not specified in the file.");
    }

    public String getProvince() {
        String province = ConfigFileReaderact().getProperty("province");
        if (province != null) return province;
        else throw new RuntimeException("province not specified in the file.");
    }

    public String getCity() {
        String city = ConfigFileReaderact().getProperty("city");
        if (city != null) return city;
        else throw new RuntimeException("city not specified in the file.");
    }

    public String getDistrict() {
        String district = ConfigFileReaderact().getProperty("district");
        if (district != null) return district;
        else throw new RuntimeException("district not specified in the file.");
    }

    public String getSubdistrict() {
        String subdistrict = ConfigFileReaderact().getProperty("subdistrict");
        if (subdistrict != null) return subdistrict;
        else throw new RuntimeException("subdistrict not specified in the file.");
    }

    public String getPostalCode() {
        String postalcode = ConfigFileReaderact().getProperty("postalcode");
        if (postalcode != null) return postalcode;
        else throw new RuntimeException("postalcode not specified in the file.");
    }

    public String getCurrentPassword() {
        String currentPassword = ConfigFileReaderact().getProperty("edit_password");
        if (currentPassword != null) return currentPassword;
        else throw new RuntimeException("edit_password not specified in the file.");
    }

    public String getNewPassword() {
        String newpassword = ConfigFileReaderact().getProperty("edit_password");
        if (newpassword != null) return newpassword;
        else throw new RuntimeException("edit_password not specified in the file.");
    }

    public String getConfirmNewPassword() {
        String confirmnewpassword = ConfigFileReaderact().getProperty("edit_password");
        if (confirmnewpassword != null) return confirmnewpassword;
        else throw new RuntimeException("edit_password not specified in the file.");
    }

    public String getNamaPenerima() {
        String namaPenerima = ConfigFileReaderact().getProperty("nama_penerima");
        if (namaPenerima != null) return namaPenerima;
        else throw new RuntimeException("nama_penerima not specified in the file.");
    }

    public String getTelponPenerima() {
        String noTelponPenerima = ConfigFileReaderact().getProperty("noTelpon_penerima");
        if (noTelponPenerima != null) return noTelponPenerima;
        else throw new RuntimeException("noTelpon_penerima not specified in the file.");
    }

    public String getEmailPenerima() {
        String emailPenerima = ConfigFileReaderact().getProperty("email_penerima");
        if (emailPenerima != null) return emailPenerima;
        else throw new RuntimeException("email_penerima not specified in the file.");
    }

    public String getKotaPenerima() {
        String kotaPenerima = ConfigFileReaderact().getProperty("kota_penerima");
        if (kotaPenerima != null) return kotaPenerima;
        else throw new RuntimeException("kota_penerima not specified in the file.");
    }

    public String getKelurahanPenerima() {
        String kelurahanPenerima = ConfigFileReaderact().getProperty("kelurahan_penerima");
        if (kelurahanPenerima != null) return kelurahanPenerima;
        else throw new RuntimeException("kelurahan_penerima not specified in the file.");
    }

    public String getAlamatPenerima() {
        String alamatPenerima = ConfigFileReaderact().getProperty("alamat_penerima");
        if (alamatPenerima != null) return alamatPenerima;
        else throw new RuntimeException("alamat_penerima not specified in the file.");
    }

    public String getDeskripsiBarang() {
        String deskripsiBarang = ConfigFileReaderact().getProperty("deskripsi_barang");
        if (deskripsiBarang != null) return deskripsiBarang;
        else throw new RuntimeException("deskripsi_barang not specified in the file.");
    }

    public String getHargaBarang() {
        String hargaBarang = ConfigFileReaderact().getProperty("harga_barang");
        if (hargaBarang != null) return hargaBarang;
        else throw new RuntimeException("harga_barang not specified in the file.");
    }

    public String getBeratBarang() {
        String beratBarang = ConfigFileReaderact().getProperty("berat_barang");
        if (beratBarang != null) return beratBarang;
        else throw new RuntimeException("berat_barang not specified in the file.");
    }

    public String getPanjangBarang() {
        String panjangBarang = ConfigFileReaderact().getProperty("panjang_barang");
        if (panjangBarang != null) return panjangBarang;
        else throw new RuntimeException("panjang_barang not specified in the file.");
    }

    public String getLebarBarang() {
        String lebarBarang = ConfigFileReaderact().getProperty("lebar_barang");
        if (lebarBarang != null) return lebarBarang;
        else throw new RuntimeException("lebar_barang not specified in the file.");
    }

    public String getTinggiBarang() {
        String tinggiBarang = ConfigFileReaderact().getProperty("tinggi_barang");
        if (tinggiBarang != null) return tinggiBarang;
        else throw new RuntimeException("tinggi_barang not specified in the file.");
    }

    public String getKodetoko() {
        String kodetoko = ConfigFileReaderact().getProperty("kodetoko");
        if (kodetoko != null) return kodetoko;
        else throw new RuntimeException("kodetoko not specified in the file.");
    }

    public String getKodetokoPilihan() {
        String kodetokoPilihan = ConfigFileReaderact().getProperty("kodetoko_pilihan");
        if (kodetokoPilihan != null) return kodetokoPilihan;
        else throw new RuntimeException("kodetoko_pilihan not specified in the file.");
    }

    public String getTokoPenerima() {
        String tokoPenerima = ConfigFileReaderact().getProperty("kodetoko_penerima");
        if (tokoPenerima != null) return tokoPenerima;
        else throw new RuntimeException("kodetoko_penerima not specified in the file.");
    }

    public String getSearchToko() {
        String searchToko = ConfigFileReaderact().getProperty("search_toko");
        if (searchToko != null) return searchToko;
        else throw new RuntimeException("search_toko not specified in the file.");
    }

    public String getPin() {
        String pinNumber = ConfigFileReaderact().getProperty("pin_number");
        if (pinNumber != null) return pinNumber;
        else throw new RuntimeException("pin_number not specified in the file.");
    }
    public String getCatatanPengirim() {
        String catatan = ConfigFileReaderact().getProperty("catatan_pengirim");
        if (catatan != null) return catatan;
        else throw new RuntimeException("catatan_pengirim not specified in the file.");
    }

    public String getKodetokoPenerimaPaketJemput() {
        String tokoPenerimaPaketJemput = ConfigFileReaderact().getProperty("kodetoko_penerima_paket_jemput");
        if (tokoPenerimaPaketJemput != null) return tokoPenerimaPaketJemput;
        else throw new RuntimeException("kodetoko_penerima_paket_jemput not specified in the file.");
    }

    public String getKotaKecamatanPengirim() {
        String kotakecamatanPengirim = ConfigFileReaderact().getProperty("kota_kecamatan_pengirim");
        if (kotakecamatanPengirim != null) return kotakecamatanPengirim;
        else throw new RuntimeException("kota_kecamatan_pengirim not specified in the file.");
    }

    public String getTokoPenerimaPaketJemput() {
        String tokoPenerimaPaketJemput = ConfigFileReaderact().getProperty("kodetoko_penerima_paket_jemput");
        if (tokoPenerimaPaketJemput != null) return tokoPenerimaPaketJemput;
        else throw new RuntimeException("kodetoko_penerima_paket_jemput not specified in the file.");
    }

    public String getOfficeAddress() {
        String officeAddress = ConfigFileReaderact().getProperty("alamat_kantor");
        if (officeAddress != null) return officeAddress;
        else throw new RuntimeException("alamat_kantor not specified in the file.");
    }

//    public String getReasonCancelation() {
//        String reason = ConfigFileReaderact().getProperty("reason_cancelation");
//        if (reason != null) return reason;
//        else throw new RuntimeException("reason_cancelation not specified in the file.");
//    }


}
