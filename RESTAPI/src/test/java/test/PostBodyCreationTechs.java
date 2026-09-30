package test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

import org.json.JSONObject;
import org.json.JSONTokener;

import POJOClass.BasicPojo;
import POJOClass.Post;
import POJOClass.PostCOMPLX;

public class PostBodyCreationTechs {
	
	
	
	//Using POJO CLASSS
	//@Test
	public void test1()
	{
		BasicPojo pj=new BasicPojo();
		pj.setAge(28);
		pj.setComp("ALSHAYA");
		pj.setName("VARUNA");
		
		
		given().contentType("application/json").body(pj)
		.when().post("http://localhost:3000/student")
		.then().statusCode(201).log().all();
		
	}
	
	
	
	//USING JSON LIBRARY
	//@Test
	public void test2()
	{
		JSONObject jo=new JSONObject();
	
		jo.put("name","SHREYA");
		jo.put("age",25);
		jo.put("comp","INFOSYS");
		
		
		given().contentType("application/json").body(jo.toString())
		.when().post("http://localhost:3000/student")
		.then().statusCode(201);
	}
	
	
	//USING EXTERNAL JSON FILE 
	//@Test
	public void test3() throws FileNotFoundException
	{
		
		File f=new File("C:\\Postman\\EXTDATA.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject jo=new JSONObject(jt);
		
		
		given().contentType("application/json").body(jo.toString())
		.when().post("http://localhost:3000/student")
		.then().statusCode(201);
	}
	
	
	
	//Creating complex body using POJO file--------------------------------------------------------------
	 //@Test
	    public void testCreatePost() {
	       
		 
		 Post.Subject pt=new Post.Subject();
		 pt.setTest("BIO");
		 pt.setTest2("CHEMI");
		 Post p=new Post();
		 p.setId("4");
		 p.setName("GEETHA");
		 String subjs[]= {"C","C++","JAVA"};
		 p.setCRS(subjs);
		 p.setTs(pt);
		 
		 
			given().contentType("application/json").body(p).log().all()
			.when().post("http://localhost:3000/STUDENT")
			.then().statusCode(201).log().all();

}
	 
	 @Test
	    public void testCreatePost2() {
	       
		 PostCOMPLX.alter alte=new PostCOMPLX.alter();
		 alte.setSUB1("KAND");
		 alte.setSUB2("SAMS");
		 PostCOMPLX.alter alte2=new PostCOMPLX.alter();
		 alte2.setSUB1("HINDI");
		 alte2.setSUB2("SONGS");
		 PostCOMPLX.Subject mai=new PostCOMPLX.Subject();
		 mai.setTest("PHY");
		 mai.setTest2("CHEM");
		 PostCOMPLX pos=new PostCOMPLX();
		 Object arry[]= {alte,alte2};
		 pos.setCRS(arry);
		 pos.setId("10");
		 pos.setName("HARI");
		 pos.setMain(mai);
		 
			given().contentType("application/json").body(pos).log().all()
			.when().post("http://localhost:3000/STUDENT")
			.then().statusCode(201).log().all();

}
	 
	 
}
