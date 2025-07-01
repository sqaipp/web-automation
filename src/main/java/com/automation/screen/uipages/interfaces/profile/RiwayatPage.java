package com.automation.screen.uipages.interfaces.profile;

public interface RiwayatPage {
    void setFieldSearchRiwayat(String nomorResi);
    void clickButtonIconSearch();
    void clickButtonFilter();
    void clickButtonFilterSemua();
    void clickButtonFilterMulai();
    void clickButtonFilterDiterimaDariPengirim();
    void clickButtonFilterProsesPengiriman();
    void clickButtonFilterSiapDiambilDiantar();
    void clickButtonFilterSudahDiambil();
    void clickButtonFilterSedangDiantar();
    void clickButtonFilterSudahDiantar();
    void clickButtonFilterRetur();
    void clickButtonDetilRiwayat();
    String getDetilServiceName();
    void checkJamPenjemputan();
    void clickButtonUnduhResi();
    void clickButtonLihatDetail();
    void clickButtonBatalkanAWB();
    void clickReasonBatalkanAWB();
    void clickButtonKonfirmasiBatalkanAWB();
}
