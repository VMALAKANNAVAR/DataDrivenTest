package Tests;

import Utils.Base;
import Utils.ExcelDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

public class FirstTest extends Base {

    @DataProvider(parallel = true)
    public Object[] DataProvider() throws IOException {

        ExcelDataProvider DataProvidervalue=new ExcelDataProvider();
        Object[] Data=DataProvidervalue.readExcelFile("TestData","Head");
        return Data;
    }

    @Test(dataProvider="DataProvider")
    public static void Start(Hashtable Data) throws IOException {
        WebDriver Driver;
        String URL= Utils.ReadProperty.readProperty("Config","URL");
        String USN= Utils.ReadProperty.readProperty("Config","USERNAME");
        String PSW= Utils.ReadProperty.readProperty("Config","PASSWORD");
        Driver= Base.InitiateDriver();
        Driver.get(URL);

    }
}
