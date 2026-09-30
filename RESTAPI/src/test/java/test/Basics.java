package test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Basics {
	
	String id="";
	@Test(enabled=false)
	public void getUser()
	{
		given().when().get("http://localhost:3000/student").then().log().all();
	}
	
	@Test() 
	public void postUser()
	{
		
		HashMap data=new HashMap<>();
		data.put("name", "GEETHA");
		data.put("age", 28);
		data.put("comp","EXPLEO");
		id=given()
			.contentType("application/json")
			.body(data)
		.when().log().all()
			.post("http://localhost:3000/student")
			.jsonPath().getString("id");
		
		}
	
	@Test(dependsOnMethods={"postUser"})
	public void getUserData()
	{

		given().when().get("http://localhost:3000/student/"+id).then().log().all();
	}
	
	@Test(dependsOnMethods={"getUserData"})
	public void putuserdata()
	{
		HashMap data=new HashMap<>();
		data.put("name", "JEEVA");
		data.put("age", 28);
		data.put("comp","EXPLEO");

		given().contentType("application/json").body(data).when().put("http://localhost:3000/student/"+id).then().log().all();
	}
	
	@Test(dependsOnMethods={"putuserdata"})
	public void deleteUser()
	{


		when().delete("http://localhost:3000/student/"+id).then().statusCode(200);
	}

}
