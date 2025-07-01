package com.automation;

import com.automation.base.BasePage;
import com.automation.screen.uipages.desktop.homepages.HomePageDesktop;
import com.automation.screen.uipages.desktop.login.LoginPageDesktop;
import com.automation.screen.uipages.desktop.profile.RiwayatPageDesktop;
import com.automation.screen.uipages.desktop.registration.RegistrationPageDesktop;
import org.openqa.selenium.WebDriver;

public class ScreenProvider extends BasePage {
    public ScreenProvider(WebDriver driver) {
        super(driver);
    }

    /**
     * @return A loginPage object initialized with the provided AppiumDriver.
     */
    public LoginPageDesktop getLoginPage() {return new LoginPageDesktop(driver);}

    /**
     * @return A HomePage object initialized with the provided AppiumDriver.
     */
    public HomePageDesktop getHomePage() {return new HomePageDesktop(driver);}

    /**
     * @return A RegisterScreen object initialized with the provided AppiumDriver.
     */
    public RegistrationPageDesktop getRegisterScreen() {
        return new RegistrationPageDesktop(driver);
    }

    /**
     * @return A riwayatPage object initialized with the provided AppiumDriver.
     */
    public RiwayatPageDesktop getRiwayatPage() {return new RiwayatPageDesktop(driver);}
}
