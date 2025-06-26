package com.automation.base.base;

import com.automation.dataProviders.ConfigFileReader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;


@Slf4j
public class BasePage {
    /**
     * All WebElements are identified by @FindBy annotation
     */
    public static WebDriver driver;
    public static ConfigFileReader config;
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void waitElement() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void scrollToElement(WebElement e) {
        waitElement();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", e);
    }

    public void scrollToEOP() {
        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll to bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollToPixel(String pixelTujuan){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixelTujuan+")", "");
    }

    public void clickElement(WebElement e) {
        waitElement();
        e.click();
//        System.out.println("Web element berhasil di click = " + e);
        waitElement();
    }

    public void clickElementandSendKeys(WebElement e, String text) {
        waitElement();
        e.click();
//        System.out.println("Web element berhasil di click = " + e);
        e.sendKeys(text);
//        System.out.println("Web element berhasil send keys  = " + e + text);
    }

    public void clickElementandClear(WebElement e) {
        waitElement();
        e.click();
//        System.out.println("Web element berhasil di click = " + e);
        e.clear();
//        System.out.println("Web element berhasil clear  = " + e);
    }

    public void clickElementandSendKeysEnter(WebElement e, String text) throws Exception {
        waitElement();
        e.click();
//        System.out.println("Web element berhasil di click = " + e);
        e.sendKeys(text);
        e.sendKeys(Keys.SPACE);
        Thread.sleep(5000);
        e.sendKeys(Keys.RETURN);
//        e.sendKeys(Keys.ENTER);
//        System.out.println("Web element berhasil send keys  = " + e + text);
    }

    public void clickElementandEnter(WebElement e) {
        waitElement();
        e.click();
//        System.out.println("Web element berhasil di click = " + e);
        e.sendKeys(Keys.ENTER);
//        System.out.println("Web element berhasil enter  = " + e);
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div[5]/div/div[5]/div/div/iframe")
    public WebElement iframeFS;
    public void switchToFramePaymentCenter() {
        try {
            driver.switchTo().frame(iframeFS);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
//            System.out.println("Element " + element + " is displayed");
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            e.getMessage();
            return false;
        }
    }

    public void scrollIntoView(WebElement e) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView({block: 'center'});", e);
    }

    /**
     * Performs a scroll action using a sequence of pointer actions.
     *
     * @param startX The starting X coordinate for the scroll action.
     * @param startY The starting Y coordinate for the scroll action.
     * @param endX   The ending X coordinate for the scroll action.
     * @param endY   The ending Y coordinate for the scroll action.
     */
    private void performScrollUsingSequence(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(450), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        RemoteWebDriver remoteDriver = (RemoteWebDriver) driver;
        remoteDriver.perform(Collections.singletonList(sequence));
    }

    /**
     * Performs a scroll action using a sequence of pointer actions.
     */
    public void performScroll(double indexEndY) {
        Dimension size = driver.manage()
                .window()
                .getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endY = (int) (size.getHeight() * indexEndY);
        performScrollUsingSequence(startX, startY, startX, endY);
    }

    public void clickElementJS(WebElement e) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", e);
    }

    public void clearTxtFile(String pathObject) throws IOException {
        PrintWriter writer = new PrintWriter(pathObject);
        writer.print("");
        writer.close();
    }

    public static String generateRandomMobileNumber() {
        Random random = new Random();
        // Select a random mobile prefix
        String[] mobilePrefixes = {"081", "082", "083", "085", "086", "087", "088"};
        String prefix = mobilePrefixes[random.nextInt(mobilePrefixes.length)];
        // Generate the rest of the digits
        StringBuilder sb = new StringBuilder(prefix);
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static void performHorizontalScroll(double startXFraction, double endXFraction) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Get the document width
        Long docWidth = (Long) js.executeScript("return document.documentElement.scrollWidth;");

        // Calculate start and end positions
        int startX = (int) (docWidth * startXFraction);
        int endX = (int) (docWidth * endXFraction);

        // Perform the scroll
        js.executeScript("window.scrollTo(" + startX + ", 0);");

        // If you want a smooth scroll effect, you can use this instead:
        // js.executeScript("window.scrollTo({left: " + endX + ", behavior: 'smooth'});");

        // Add a small delay to allow the scroll to complete
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds an element on the page and returns true if it is displayed within the specified timeout.
     *
     * @param element The By locator of the element to find.
     * @param timeout The timeout in seconds.
     * @return True if the element is displayed within the specified timeout, false otherwise.
     */
    public boolean find(final WebElement element, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until((ExpectedCondition<Boolean>) driver -> element.isEnabled());
        } catch (WebDriverException e) {
            return false;
        }
    }

    /**
     * Waits for the element located by the given By locator to become visible.
     *
     * @throws TimeoutException If the element does not become visible within the specified timeout.
     */
    public void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
            log.error("Element is now visible: {}", element.toString());
        } catch (WebDriverException e) {
            log.error("Element did not become visible within the timeout: {}", element.toString(), e);
            throw e;
        }
    }

    /**
     * This function inputs text into the element located by the given By locator.
     *
     * @param element   the locator of the element to input text
     * @param inputText the text to input
     */
    public void inputText(WebElement element, String inputText, String logMessage) {
        try {
            waitForElementVisibility(element);
            log.info(logMessage);
            element.clear();
            element.sendKeys(inputText);

        } catch (WebDriverException exception) {
            log.error("Unable to input text into element: {}", element.toString(), exception);
            throw exception;
        }
    }

    /**
    * This function find any elements.
    */
    public WebElement findAny(WebDriver driver, By... locators) {
        for (By locator : locators) {
            List<WebElement> found = driver.findElements(locator);
            for (WebElement el : found) {
                if (el.isDisplayed() && el.isEnabled()) {
                    return el;
                }
            }
        }
        return null;
    }

    /**
     * This function is use for switch tab on browser by index.
     */
    public void switchBrowserTab(int indexTab) {
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[indexTab]);
    }

}