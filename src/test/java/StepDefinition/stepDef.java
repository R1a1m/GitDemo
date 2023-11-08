package StepDefinition;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.seriliaze;
import resources.APIresources;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDef extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;
	
	@Given("Add place payload {string} {string} {string}")
	public void add_place_payload(String name, String Language, String address) throws Exception {
RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").
		setContentType(ContentType.JSON).build();
		
		 resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		 res = given().spec(requestSpecification()).body(data.addPlacePayload(name,Language,address)) ;
	}
	
	@When("User calls {string} with {string} httprequest")
	public void user_calls_with_httprequest(String Resource, String method) {
APIresources resourceApi = APIresources.valueOf(Resource);
		
		System.out.println(resourceApi.getResource());
		 
		 if(method.equalsIgnoreCase("post")) {
			 response = res.when().log().all().post(resourceApi.getResource());
		 }else if(method.equalsIgnoreCase("get")) {
			 response = res.when().log().all().get(resourceApi.getResource());
		 }

	}

	@Then("The API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    assertEquals(response.getStatusCode(), 200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedKeyvalue) {
		
		assertEquals(getJsonPath(response, keyValue),ExpectedKeyvalue );
	}
	
	@Then("verify place_ID created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String ExpectedName, String resource) throws Exception {
		 place_id = getJsonPath(response, "place_id");
	    res = given().spec(requestSpecification()).queryParam("place_id",place_id );
	    user_calls_with_httprequest(resource,"GET");
	    String actualname = getJsonPath(response,"name");
	    assertEquals(actualname,ExpectedName);
	    
	}
	
	@Given("DeletePlace payload")
	public void delete_place_payload() throws Exception {
		res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
}
