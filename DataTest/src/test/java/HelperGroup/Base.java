package HelperGroup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    public static final ThreadLocal<WebDriver> Driver = new ThreadLocal<>();
public static void InitiateDriver()
{
    WebDriverManager.chromedriver().getWebDriver();

    Driver.set(new ChromeDriver());
    Driver.get().manage().window().maximize();

}

public static WebDriver getDriver()
{
    return Driver.get();
}

public static void CloseDriver()
{
    WebDriver driver=Driver.get();
    driver.quit();
}

}
