package basictestcase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapibase.Baseapiclass;

import Utility.Auth;
import Utility.createURL;
import Utility.fetchvaluefromjson;
import Utility.payloadGenerator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class createRepoTest {
	public static JsonPath jsonPath;
	Response response;
//	@Test
	public void createrepoTestcase() throws IOException {
		String endpoint=createURL.getBaseURI("/user/repos");
		System.out.println(endpoint);
		String req_payLoad=payloadGenerator.generateStringPayload("createrepo.json");
		System.out.println("start2");
		String bearer_Token = Auth.getBearertoken();
		//System.out.println(bearer_Token);
		response = Baseapiclass.postRequest(endpoint,req_payLoad,bearer_Token);
		System.out.println("start3");
		String responseString=response.getBody().asString();
		System.out.println(responseString);
				
	}
	
	//@Test
	public void getlocalapiTestcase() throws IOException {
		String endpoint=createURL.getBaseURI("status");
		//System.out.println(endpoint);
		//String req_payLoad=payloadGenerator.generateStringPayload("justuserjson.json");
		//System.out.println("start2");
		response =Baseapiclass.getRequest(endpoint);
		String responseString=response.getBody().asString();
		//System.out.println(responseString);
		int response_statuscode=response.getStatusCode();
		
		//String exp=fetchvaluefromjson.valuefromjson(responseString,"laststname");
		//String act=fetchvaluefromjson.valuefromjson(req_payLoad,"name");
		
		System.out.println(fetchvaluefromjson.valuefromjson(responseString,"hit"));
		//System.out.println(act);
		Assert.assertEquals(200, response_statuscode);
		//Assert.assertEquals(exp, act);

}
	
	
	@Test
	public void postlocalapiTestcase() throws IOException {
		String endpoint=createURL.getBaseURI("status");
		System.out.println(endpoint);
		String req_payLoad=payloadGenerator.generateStringPayload("actions.json");
		System.out.println("start2");
		response =Baseapiclass.postRequest(endpoint, req_payLoad);
		String responseString=response.getBody().asString();
		System.out.println(responseString);
		int response_statuscode=response.getStatusCode();
		//Assert.assertEquals(201, response_statuscode);
		
		String exp=fetchvaluefromjson.valuefromjson(responseString,"status[1].hit3");
		String act=fetchvaluefromjson.valuefromjson(req_payLoad,"status[1].hit3");
		
		System.out.println("trying to fer list of 1st array");
		
	//notworking throwing jackson error	Getting can't deserialized
		    List<Object> allstatus = response.as(List.class);
		    Map<String,Object>  letmecheck= (Map<String,Object>)allstatus.get(0);
		    System.out.println(letmecheck.get("hit3"));
		//jackson 
			
		//String act1=fetchvaluefromjson.valuefromjson(req_payLoad,"status[0]");//throwing error
		//System.out.println(act1);
						
		System.out.println(exp);
		System.out.println(act);
		
		JsonPath extractor= response.jsonPath();
		ArrayList<String> statuses=  extractor.get("status[0]");
		System.out.println(statuses.size());//fetching data
		
		
		
		System.out.println(statuses.get(0));//throwing error
	
		
//		for (int i=0;i<=statuses.size();i++)
//		{
//			System.out.println(statuses.get(i));
//			
//		}
		//System.out.println(fetchvaluefromjson.valuefromjson(responseString,"laststname"));
		//System.out.println(fetchvaluefromjson.valuefromjson(req_payLoad,"laststname"));
		
		Assert.assertEquals(exp, act);
		
		//Assert.assertEquals(fetchvaluefromjson.valuefromjson(responseString,"name"), fetchvaluefromjson.valuefromjson(req_payLoad,"name"));

}
	
	//@Test
		public void putlocalapiTestcase_object() throws IOException {
			String endpoint=createURL.getBaseURI("");
			System.out.println(endpoint);
			String req_payLoad=payloadGenerator.generateStringPayload("actions.json");
			System.out.println(req_payLoad);
			response =Baseapiclass.putRequest(endpoint, req_payLoad);
			String responseString=response.getBody().asString();
			System.out.println(responseString);
			int response_statuscode=response.getStatusCode();
			Assert.assertEquals(201, response_statuscode);
			
			//String exp=fetchvaluefromjson.valuefromjson(responseString,"laststname");
			//String act=fetchvaluefromjson.valuefromjson(req_payLoad,"laststname");
			
			//System.out.println(fetchvaluefromjson.valuefromjson(responseString,"hit1"));
			//System.out.println(fetchvaluefromjson.valuefromjson(req_payLoad,"hit1"));
			
			//Assert.assertEquals(exp, act);
			
			//Assert.assertEquals(fetchvaluefromjson.valuefromjson(responseString,"hit1"), fetchvaluefromjson.valuefromjson(req_payLoad,"hit1"));

	}


}
