package com.automation.screen.uipages.notification;

import com.automation.base.base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.automation.screen.uicomponent.UiComponentProvider.loadingWait;

@Slf4j
public class notificationPage extends BasePage {
    public notificationPage(WebDriver driver) {
        super(driver);
    }

}