package com.automation.screen.uicomponent;

import com.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckScreen extends BasePage {
    public CheckScreen(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks if the specified element is enabled on the screen.
     *
     * @param element The element to check.
     * @param timeout The maximum time in seconds to wait for the element to be enabled.
     * @return true if the element is enabled, false otherwise.
     */
    public boolean isEnabledElement(WebElement element, long timeout) {
        try {
            return find(element, timeout);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checks if the specified target text is displayed on the screen.
     *
     * @param targetText The text to search for within the elements on the screen.
     * @param timeout    The maximum time in seconds to wait for the target text to be displayed.
     * @return true if the target text is displayed, false otherwise.
     */
    public boolean isEnabledText(String targetText, long timeout) {
        try {
            String xpath = String.format("//*[contains(., '%s')]", targetText);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(driver -> {
                WebElement element = driver.findElement(By.xpath(xpath));
                return element != null && element.isEnabled();
            });
        } catch (Exception e) {
            return false;
        }
    }
}
