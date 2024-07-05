package apiFunctions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET {
	
public Response executeGetRequest(String uri) {
	
	RestAssured.baseURI = uri;
	  
	  RequestSpecification requestSpecification=RestAssured.given();
	  
	  Response response=requestSpecification.get();
	  
	  return response;
}

public int returnGetStatusCode(Response response) {
	
	return response.getStatusCode();

}
}
