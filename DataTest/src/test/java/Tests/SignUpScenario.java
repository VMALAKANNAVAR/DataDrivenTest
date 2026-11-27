package Tests;

import HelperGroup.*;
import PageObjects.LoginPage;
import PageObjects.SignInPage;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

@Listeners(Listners.class)
public class SignUpScenario {

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

        SignInPage signInPage=new SignInPage(Base.getDriver());
        signInPage.SIGNUP(Data);



    }

        @AfterMethod
        public void closeBrowser()
        {
            Reporting.endtest();
            Base.CloseDriver();
        }


}
