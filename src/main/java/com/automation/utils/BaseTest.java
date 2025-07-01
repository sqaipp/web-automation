package com.automation.utils;

import com.automation.dataProviders.ConfigFileReader;
import com.automation.ScreenProvider;
import com.automation.screen.uicomponent.UiComponentProvider;
import com.automation.screen.uipages.desktop.homepages.CariTokoPageDesktop;
import com.automation.screen.uipages.desktop.homepages.HomePageDesktop;
import com.automation.screen.uipages.desktop.login.ForgotPasswordPageDesktop;
import com.automation.screen.uipages.desktop.login.LoginPageDesktop;
import com.automation.screen.uipages.desktop.notification.NotificationPageDesktop;
import com.automation.screen.uipages.desktop.profile.MembershipPageDesktop;
import com.automation.screen.uipages.desktop.profile.ProfilePageDesktop;
import com.automation.screen.uipages.desktop.profile.RiwayatPageDesktop;
import com.automation.screen.uipages.desktop.registration.RegistrationPageDesktop;
import com.automation.screen.uipages.desktop.transaction.AmbilPaketPageDesktop;
import com.automation.screen.uipages.desktop.transaction.KirimPaketPageDesktop;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static ConfigFileReader ConfigFileReader = new ConfigFileReader();
    public String testUrl = ConfigFileReader.getTestUrlWebsite();
    public String browserName = ConfigFileReader.getBrowserName();
    public String webType = ConfigFileReader.getWebType();

    protected HomePageDesktop homePage;
    protected CariTokoPageDesktop cariTokoPage;
    protected LoginPageDesktop loginPage;
    protected ForgotPasswordPageDesktop forgotPasswordPage;
    protected NotificationPageDesktop notificationPage;
    protected MembershipPageDesktop membershipPage;
    protected ProfilePageDesktop profilePage;
    protected RiwayatPageDesktop riwayatPage;
    protected RegistrationPageDesktop registrationPage;
    protected AmbilPaketPageDesktop ambilPaketPage;
    protected KirimPaketPageDesktop kirimPaketPage;

    @BeforeMethod
    public void startTest() {
        try {
            System.out.println("The Test has been started.");
            if (browserName.equalsIgnoreCase("chrome")) {
                String localProperty = ConfigFileReader.getSystemProperty_Local();
                String serverProperty = ConfigFileReader.getSystemProperty_Server();
//                System.setProperty("webdriver.chrome.driver", serverProperty);
                System.setProperty("webdriver.chrome.driver", localProperty);
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(false);
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-blink-features=AutomationControlled");
                options.addArguments("--disable-gpu"); // Applicable to Windows OS
                options.addArguments("--disable-extensions");
                options.addArguments("excludeSwitches","enable-automation");
                options.addArguments("useAutomationExtension", "false");
                if (webType.equalsIgnoreCase("desktopWeb")) {
                    options.addArguments("--start-maximized");
                } else {
                    options.addArguments("--window-size=320,1080");
                }
                driver = new ChromeDriver(options);

                if(webType.equals("desktopWeb")) {
                    homePage  = new HomePageDesktop(driver);
                    cariTokoPage = new CariTokoPageDesktop(driver);
                    loginPage  = new LoginPageDesktop(driver);
                    forgotPasswordPage = new ForgotPasswordPageDesktop(driver);
                    notificationPage = new NotificationPageDesktop(driver);
                    membershipPage = new MembershipPageDesktop(driver);
                    profilePage = new ProfilePageDesktop(driver);
                    riwayatPage = new RiwayatPageDesktop(driver);
                    registrationPage = new RegistrationPageDesktop(driver);
                    ambilPaketPage = new AmbilPaketPageDesktop(driver);
                    kirimPaketPage = new KirimPaketPageDesktop(driver);
                } else {
                    System.out.println("untuk mobile view");
                }

            } else if (browserName.equalsIgnoreCase("safari")) {
                SafariOptions options = new SafariOptions();
                options.setUseTechnologyPreview(true);
                driver = new SafariDriver(options);
                driver.manage().window().maximize();
            } else {
                throw new IllegalArgumentException("Invalid browser name: " + browserName);
            }
//            driver.manage().deleteAllCookies();
            driver.get(testUrl);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            String currentURL = driver.getCurrentUrl();
            System.out.println("current url is : " + currentURL);
            System.out.println("current window size : " + driver.manage().window().getSize());

        } catch (Exception e) {
            System.out.println("Gagal Launch Browser" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a ScreenProvider object based on the provided AppiumDriver.
     *
     * @return The ScreenProvider object initialized with the given driver.
     */
    public ScreenProvider screen() {
        return new ScreenProvider(driver);
    }

    /**
     * Returns a UiComponentProvider object initialized with the current AppiumDriver.
     *
     * @return The UiComponentProvider object.
     */
    public UiComponentProvider uiComponent() {
        // Create a new UiComponentProvider using the current AppiumDriver
        return new UiComponentProvider(driver);
    }


    @AfterMethod
    public void endTest() {
        System.out.println("The Test has been finished.");
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver.close();
                driver.quit();
            } else if (browserName.equalsIgnoreCase("safari")) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Gagal Launch Browser" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}


