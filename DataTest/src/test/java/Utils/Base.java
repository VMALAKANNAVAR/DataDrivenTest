package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

public static WebDriver InitiateDriver()
{
    WebDriverManager.chromedriver().getWebDriver();
    WebDriver Driver =new ChromeDriver();
    return Driver;
}

}
