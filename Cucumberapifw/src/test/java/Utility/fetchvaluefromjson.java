package Utility;

import io.restassured.path.json.JsonPath;


public class fetchvaluefromjson {
	
	public static JsonPath jsonPath;
	
	public static String valuefromjson(String response_body,String response_key) {
		
	   jsonPath= new JsonPath(response_body);
	   String Key_value= jsonPath.get(response_key);
		return Key_value;
	}
	

}
