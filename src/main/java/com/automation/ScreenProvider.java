package com.automation;

import com.automation.base.base.BasePage;
import com.automation.screen.uipages.homepages.homePage;
import com.automation.screen.uipages.login.loginPage;
import com.automation.screen.uipages.profile.riwayatPage;
import com.automation.screen.uipages.registration.registrationPage;

public class ScreenProvider extends BasePage {
    public ScreenProvider() {
        super(driver);
    }

    /**
     * @return A loginPage object initialized with the provided AppiumDriver.
     */
    public loginPage getLoginPage() {return new loginPage(driver);}

    /**
     * @return A HomePage object initialized with the provided AppiumDriver.
     */
    public homePage getHomePage() {return new homePage(driver);}

    /**
     * @return A RegisterScreen object initialized with the provided AppiumDriver.
     */
    public registrationPage getRegisterScreen() {
        return new registrationPage(driver);
    }

    /**
     * @return A riwayatPage object initialized with the provided AppiumDriver.
     */
    public riwayatPage getRiwayatPage() {return new riwayatPage(driver);}
}
