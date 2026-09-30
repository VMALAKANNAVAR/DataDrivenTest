package test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ParsingBody {
	
	
	public void test()
	{
		
		given().contentType("application/json")
		.when()
		.get("https://dummyjson.com/users").then().body("users[3].bank.cardType",equalTo("Mastercard"));		
	
	}
	
	
	
	//@Test
	public void test1()
	{
		
		Response rp=given().contentType("application/json")
		.when()
		.get("https://dummyjson.com/users");
		
		String card=rp.jsonPath().get("users[0].bank.cardType");
		System.out.println(card);
		Assert.assertEquals(rp.statusCode(), 200);
		Assert.assertEquals(card, "Elo");
		String bd=rp.getBody().asPrettyString();
		System.out.println(bd);
	
	}
	
	//@Test
	public void test2()
	{
		
		Response rp=given().contentType("contentType.JSON")
		.when()
		.get("https://dummyjson.com/users");
		
		JSONObject obj=new JSONObject(rp.asPrettyString());
		
		int len=obj.getJSONArray("users").length();
		System.out.println(len);
		
		for(int i=0;i<len;i++)
		{
			String card=obj.getJSONArray("users").getJSONObject(i).getJSONObject("bank").get("cardNumber").toString();
			
			String cardtype=obj.getJSONArray("users").getJSONObject(i).getJSONObject("bank").get("cardType").toString();
			System.out.println(card+" "+cardtype);
		}
		
	
	}
	
	@Test
	public void test3()
	{
		
		
		
		Response rp=given().contentType("contentType.JSON")
		.when()
		.get("https://dummyjson.com/posts");
		
		JSONObject obj=new JSONObject(rp.asPrettyString());
		
		int len=obj.getJSONArray("users").length();
		System.out.println(len);
		
		for(int i=0;i<len;i++)
		{
			String card=obj.getJSONArray("users").getJSONObject(i).getJSONObject("bank").get("cardNumber").toString();
			
			String cardtype=obj.getJSONArray("users").getJSONObject(i).getJSONObject("bank").get("cardType").toString();
			System.out.println(card+" "+cardtype);
		}
		
	
	}

	
	
	

	
}
