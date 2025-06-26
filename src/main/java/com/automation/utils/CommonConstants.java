package com.automation.utils;
import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;


public class CommonConstants {

    static String UAT = "uat";
    public static final String EXECUTION_ENV_NAME = getEnvironmentName();


    private static String getEnvironmentName() {
        String environmentNameFromPomXml = System.getProperty("environment");
        String envName;

        if (environmentNameFromPomXml != null)
            envName = environmentNameFromPomXml;
        else {
            envName = UAT;
        }

        return envName.toLowerCase();
    }

    private CommonConstants() {
    }
}
