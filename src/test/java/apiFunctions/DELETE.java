package apiFunctions;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETE {
	
	
	public Response executeDeleteRequest(String uri, int rollNo) {
		
		RestAssured.baseURI= uri;
	    RequestSpecification req = RestAssured.given();
	    Response response = req.request(Method.DELETE, "/student/delete?rollNo="+rollNo);

		return response;
		
	}
	
	public int returnDeleteStatusCode(Response response) {
		
		return response.getStatusCode();

	}

}
