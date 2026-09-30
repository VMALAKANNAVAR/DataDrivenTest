package test;

import org.testng.annotations.Test;

import POJOClass.RP;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class REVISE {
	
	@Test
	public void rev()
	{
		RP r=new RP();
		RP.Subsubj rss=new RP.Subsubj();
		rss.setSUB1("AI");
		rss.setSUB2("ML");
		Object o[]= {rss};
		RP.Subject su=new RP.Subject();
		su.setTest1("OMS");
		su.setTest2("AO");
		r.setId("3");
		r.setName("GIRI");
		r.setCRS(o);
		r.setSUB(su);
		
		
		
		given().contentType("application/json").body(r).when().post("http://localhost:3000/STUDENT").then().log().all();
	}

}
