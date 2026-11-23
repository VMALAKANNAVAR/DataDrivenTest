package Tests;

import HelperGroup.Base;
import HelperGroup.ExcelDataProvider;
import PageObjects.LoginPage;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Hashtable;

public class FirstTest extends Base {

    @BeforeMethod
    public void InitiateExecution()
    {
        Base.InitiateDriver();
    }

    @DataProvider(parallel = true)
    public Object[] DataProvider() throws IOException {

        ExcelDataProvider DataProvidervalue=new ExcelDataProvider();
        Object[] Data=DataProvidervalue.readExcelFile("TestData","Head");
        return Data;
    }

    @Test(dataProvider="DataProvider")
    public static void Start(Hashtable<String,String> Data) throws IOException {

        String URL= HelperGroup.ReadProperty.readProperty("Config","URL");
        Base.getDriver().get(URL);
        System.out.println("USN"+Data.get("UserName")+"Password"+Data.get("Password"));
        LoginPage loginPage=new LoginPage(Base.getDriver());
        loginPage.setUserName(Data.get("UserName"));
        loginPage.setPassword(Data.get("Password"));
        loginPage.ClickSubmit();

    }

    @AfterMethod
    public void closeBrowser()
    {
        Base.CloseDriver();
    }
}
