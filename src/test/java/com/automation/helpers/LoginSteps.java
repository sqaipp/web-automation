package com.automation.helpers;

import com.automation.screen.uipages.interfaces.home.HomePage;
import com.automation.screen.uipages.interfaces.login.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage;
    private final HomePage homePage;

    public LoginSteps(LoginPage loginPage, HomePage homePage) {
        this.loginPage = loginPage;
        this.homePage = homePage;
    }

    public void doValidLogin(String username, String password) {
        // click button masuk for login
        homePage.clickBtnMasukForLogin();
        // input username
        loginPage.clickandSendKeysUsername(username);
        // input password
        loginPage.clickandSendKeysPassword(password);
        // click button masuk
        loginPage.clickMasukLogin();
    }
}
