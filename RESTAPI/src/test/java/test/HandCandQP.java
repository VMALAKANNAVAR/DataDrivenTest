package test;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HandCandQP {
	
//	@Test
	public void test1()
	{
		
		given()
		.when()
		.get("http://localhost:3000/student")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json");
		
		
	}
	
	
	
//	@Test
	public void test2()
	{
		
		Response r=given()
		.when()
		.get("http://localhost:3000/student");
		
		
		String resp=r.getHeader("Content-Type");
		System.out.println(resp);
		
		
	}
	
	

//	@Test
	public void test3()
	{
		
		given()
		.when()
		.get("http://localhost:3000/student")
		.then()
		.log().headers()
		.log().body()
		.log().cookies()
		.log().all();
		
		
	}
	
	
//	@Test
	public void test4()
	{
		
		Response r=given()
		.when()
		.get("http://localhost:3000/student");
		
		
		
		Headers h=r.getHeaders();
		for(Header h1:h)
		{
			System.out.println(h1);
		}		
		
	}
	
	
	
	@Test
	public void test5()
	{
		
		given()
			.pathParam("path1", "student")
			.queryParam("id", 1218)
		.when()
		.get("http://localhost:3000/{path1}")
		.then()
		.log().all();
		
		
	}

}
