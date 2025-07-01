package com.automation.screen.uipages.desktop.notification;

import com.automation.base.BasePage;
import com.automation.screen.uipages.interfaces.notification.NotificationPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class NotificationPageDesktop extends BasePage implements NotificationPage {
    public NotificationPageDesktop(WebDriver driver) {
        super(driver);
    }

}