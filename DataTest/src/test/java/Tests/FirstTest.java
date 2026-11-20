package Tests;

import HelperGroup.Base;
import HelperGroup.ExcelDataProvider;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
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
        String URL= HelperGroup.ReadProperty.readProperty("Config","URL");
        String USN= HelperGroup.ReadProperty.readProperty("Config","USERNAME");
        String PSW= HelperGroup.ReadProperty.readProperty("Config","PASSWORD");
        Driver= Base.InitiateDriver();
        Driver.get(URL);
        LoginPage loginPage=new LoginPage(Driver);
        loginPage.setUserName(USN);
        loginPage.setPassword(PSW);


    }
}
