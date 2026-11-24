package com.tester.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    private static final ThreadLocal<WebDriver> Driver=new ThreadLocal<>();

    public static void initializeDriver()
    {
        WebDriverManager.chromedriver().setup();
        Driver.set(new ChromeDriver());
    }

    public static WebDriver getWebDriver()
    {
        return Driver.get();
    }

    public static void closeWebSite()
    {
        WebDriver driver=Driver.get();
        if(driver!=null) {
            driver.quit();
            driver=null;
        }
    }
}
