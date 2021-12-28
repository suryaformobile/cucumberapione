package com.restapibase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseapiclass {
	
	public static Response getRequest(String requestURI){
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response =requestSpecification .get(requestURI);
		return response;
		}
	
	public static Response postRequest(String requestURI, String requestpayLoad){
		RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response =requestSpecification.post(requestURI);
		return response;
		}
	
	
	public static Response postRequest1(String requestURI,String requestpayLoad,String bearer_token){
		RequestSpecification requestSpecification = RestAssured.given().body(requestpayLoad).urlEncodingEnabled(false);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization","Bearer"+bearer_token);
		Response response =requestSpecification.post(requestURI);
		return response;
		}

}
