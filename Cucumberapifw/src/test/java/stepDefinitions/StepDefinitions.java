package stepDefinitions;


import static io.restassured.RestAssured.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class StepDefinitions {
	
	String base_URI	= "https://reqres.in/api";
	Response response;
	RequestSpecification request;
	
	@Given("baseUI is provided")
	public void base_ui_is_provided() {
		System.out.println(base_URI);
		RestAssured.baseURI = base_URI;
		request=RestAssured.given();
		
	   
	}
	@When("resource provided for users")
	public void resource_provided_for_users() {
		response =get("/users?page=2");
		System.out.println(base_URI);
	    
	}
	@SuppressWarnings("deprecation")
	@Then("api should fetch status code {int}")
	public void api_should_fetch_status_code(Integer int1) {
		
		int int11=200;
		Assert.assertEquals(int11, response.getStatusCode());
		
		
		System.out.println(base_URI);
		
		//just
	    
	}

}
