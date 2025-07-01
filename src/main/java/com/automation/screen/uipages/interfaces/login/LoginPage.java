package com.automation.screen.uipages.interfaces.login;

public interface LoginPage {
    void clickandSendKeysUsername(String username);
    void clickandSendKeysPassword(String password);
    void clickMasukLogin();
    void clickButtonLogout();
    void clickConfirmLogout();
    void checkPopupMessage();
}
