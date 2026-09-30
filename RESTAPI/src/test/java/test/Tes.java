package test;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tes {
	
	@Test
	public static void test()
	{
		
		ChromeDriver c=new ChromeDriver();
		c.get("https://lmits.omni.manh.com/omnifacade/#/home");
		
		Cookie test = new Cookie.Builder("com-manh-cp-zuulserver_JSESSIONID", "fad53e1e-3449-4737-b505-bf0e8901b986")        
				.domain("lmits.omni.manh.com")        
				.path("/")       
				.isSecure(true)        
				.build(); 
		c.manage().addCookie(test); 
		c.navigate().refresh();
		
	}

}
