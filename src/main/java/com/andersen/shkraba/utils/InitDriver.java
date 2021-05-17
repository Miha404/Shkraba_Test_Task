package com.andersen.shkraba.utils;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class InitDriver {
    DriverManagerType driverManagerType;

    public void initDriverSettings() {
        switch (PropertyReader.getProperty("browser.name").toLowerCase()) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();
                break;
            case "firefox":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();
                break;
            default:
                log.error("Browser " + PropertyReader.getProperty("browser.name") + " is not supported.");
        }
        Configuration.browser = PropertyReader.getProperty("browser.name");
        Configuration.startMaximized = PropertyReader.getProperty("maximize").equalsIgnoreCase("true");
        Configuration.timeout = Integer.parseInt(PropertyReader.getProperty("implicitly.wait"));
        Configuration.headless = PropertyReader.getProperty("headless").equalsIgnoreCase("true");
    }

}
