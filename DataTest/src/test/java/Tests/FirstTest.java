package Tests;

import HelperGroup.*;
import PageObjects.LoginPage;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

@Listeners(Listners.class)
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

    @Test(dataProvider="DataProvider",retryAnalyzer = RetryAnalyzer.class,enabled = true, invocationCount = 1)
    public static void Start(Hashtable<String,String> Data) throws IOException {

        Random random=new Random();
        String URL= HelperGroup.ReadProperty.readProperty("Config","URL");
        Base.getDriver().get(URL);
        Reporting.InitiateReport("C:\\DataDrivenFramewrok\\DataTest\\src\\test\\resources\\TestReports\\"+Data.get("Scenario")+random.nextLong()+".html");
        System.out.println("USN"+Data.get("UserName")+"Password"+Data.get("Password"));
        LoginPage loginPage=new LoginPage(Base.getDriver());
        loginPage.userLogin(Data.get("UserName"),Data.get("Password"));

    }

    @AfterMethod
    public void closeBrowser()
    {
        Reporting.endtest();
        Base.CloseDriver();
    }

}
