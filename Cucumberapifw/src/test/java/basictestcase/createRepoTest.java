package basictestcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restapibase.Baseapiclass;

import Utility.Auth;
import Utility.createURL;
import Utility.fetchvaluefromjson;
import Utility.payloadGenerator;
import io.restassured.response.Response;

public class createRepoTest {
	
	Response response;
//	@Test
	public void createrepoTestcase() throws IOException {
		String endpoint=createURL.getBaseURI("/user/repos");
		System.out.println(endpoint);
		String req_payLoad=payloadGenerator.generateStringPayload("createrepo.json");
		System.out.println("start2");
		String bearer_Token = Auth.getBearertoken();
		//System.out.println(bearer_Token);
		response = Baseapiclass.postRequest1(endpoint,req_payLoad,bearer_Token);
		System.out.println("start3");
		String responseString=response.getBody().asString();
		System.out.println(responseString);
				
	}
	
	//@Test
	public void getlocalapiTestcase() throws IOException {
		String endpoint=createURL.getBaseURI("users");
		//System.out.println(endpoint);
		String req_payLoad=payloadGenerator.generateStringPayload("justuserjson.json");
		//System.out.println("start2");
		response =Baseapiclass.getRequest(endpoint);
		String responseString=response.getBody().asString();
		//System.out.println(responseString);
		int response_statuscode=response.getStatusCode();
		
		//String exp=fetchvaluefromjson.valuefromjson(responseString,"laststname");
		//String act=fetchvaluefromjson.valuefromjson(req_payLoad,"name");
		
		System.out.println(fetchvaluefromjson.valuefromjson(responseString,"laststname"));
		//System.out.println(act);
		Assert.assertEquals(200, response_statuscode);
		//Assert.assertEquals(exp, act);

}
	
	
	//@Test
	public void postlocalapiTestcase() throws IOException {
		String endpoint=createURL.getBaseURI("users");
		System.out.println(endpoint);
		String req_payLoad=payloadGenerator.generateStringPayload("justuserjson.json");
		System.out.println("start2");
		response =Baseapiclass.postRequest(endpoint, req_payLoad);
		String responseString=response.getBody().asString();
		//System.out.println(responseString);
		//int response_statuscode=response.getStatusCode();
		//Assert.assertEquals(201, response_statuscode);
		
		//String exp=fetchvaluefromjson.valuefromjson(responseString,"laststname");
		//String act=fetchvaluefromjson.valuefromjson(req_payLoad,"laststname");
		
		System.out.println(fetchvaluefromjson.valuefromjson(responseString,"laststname"));
		System.out.println(fetchvaluefromjson.valuefromjson(req_payLoad,"laststname"));
		
		//Assert.assertEquals(exp, act);
		
		Assert.assertEquals(fetchvaluefromjson.valuefromjson(responseString,"name"), fetchvaluefromjson.valuefromjson(req_payLoad,"name"));

}

}
