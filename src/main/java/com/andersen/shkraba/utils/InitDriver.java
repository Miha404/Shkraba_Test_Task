package com.andersen.shkraba.utils;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class InitDriver {
    DriverManagerType driverManagerType;

    public void initDriverSettings() {

        switch (PropertyReader.getProperty("browser")) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                break;
            case "firefox":
                driverManagerType = DriverManagerType.FIREFOX;
                break;
            default:
                log.error("Browser " + PropertyReader.getProperty("browser") + " is not supported.");
        }
        WebDriverManager.getInstance(driverManagerType).setup();
        Configuration.browser = PropertyReader.getProperty("browser");
        Configuration.startMaximized = PropertyReader.getProperty("maximize").equalsIgnoreCase("true");
        Configuration.timeout = Integer.parseInt(PropertyReader.getProperty("implicitly.wait"));
        Configuration.headless = PropertyReader.getProperty("headless").equalsIgnoreCase("true");
    }

}
