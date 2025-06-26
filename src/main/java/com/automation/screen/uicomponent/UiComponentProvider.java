package com.automation.screen.uicomponent;

import com.automation.base.base.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class UiComponentProvider  extends BasePage {
    public UiComponentProvider() {
        super(driver);
    }

    /**
     * Returns an instance of CheckTextScreen initialized with the provided WebDriver.
     *
     * @return A CheckTextScreen object.
     */
    public CheckScreen checkTextScreen() {
        return new CheckScreen(driver);
    }

    /**
     * Creates a new DurationSleeper object with the specified duration in seconds.
     *
     * @param duration The duration in seconds to sleep.
     */
    public static void loadingWait(long duration) {
        new DurationSleeper(duration, TimeUnit.SECONDS).sleep();
    }
}
