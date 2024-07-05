package poleStar;

import org.testng.annotations.Test;

import apiFunctions.DELETE;
import apiFunctions.GET;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.Assert;

public class ApiTestClass {

	GET getObj;
	Response response;
	DELETE deleteObj;

	@BeforeClass
	public void beforeClass() {

		getObj = new GET();
		deleteObj = new DELETE();
	}
	
	
	@Parameters("uriGet")
	@Test(priority = 0)
	public void executeGETRequest(@Optional("http://10.82.180.36:8080/AmigoWallet/RegistrationAPI/getAllQuestions") String uriGet) {

		String uri = uriGet;

		response = getObj.executeGetRequest(uri);

		System.out.println(response.asString());

	}

	@Test(priority = 1, dependsOnMethods = "executeGETRequest")
	public void verifyStatusCodeOfGetResponse() {

		Assert.assertEquals(200, getObj.returnGetStatusCode(response));
		
		System.out.println("API GET Status Code: " + getObj.returnGetStatusCode(response));
	}
	
	
	@Test(priority = 2)
	public void executeDelete(){
		
		String uri = "http://10.82.180.36:8080/rest-session-demo/api";
		
		int rollNo = 102;
		
		deleteObj.executeDeleteRequest(uri, rollNo);
		
	}
	
	@Test(priority = 2, dependsOnMethods = "executeDelete")
	public void verifyStatusCodeOfDeleteResponse() {
		
		Assert.assertEquals(200, deleteObj.returnDeleteStatusCode(response));
		System.out.println("API DELETE Status Code: " + deleteObj.returnDeleteStatusCode(response));
	}


}
