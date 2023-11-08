package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
public static RequestSpecification req;

public RequestSpecification requestSpecification() throws Exception {
	
	
	if(req==null) {
	PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	 req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL")).addQueryParam("key", "qaclick123").
			 addFilter(RequestLoggingFilter.logRequestTo(log)).
			 addFilter(ResponseLoggingFilter.logResponseTo(log)).
	setContentType(ContentType.JSON).build();
	 
	 return req;
	}
	return req;
}


public String getGlobalValue(String key) throws Exception {
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\APIFrameWork\\src\\test\\java\\resources\\Prop.properties");
	prop.load(fis);
	String baseurl = prop.getProperty(key);
	return baseurl;
}

public String  getJsonPath(Response response,String key) {
	String resp = response.asString();
	JsonPath js = new JsonPath(resp);
	String output = js.get(key);
	return output;
	
	
}
}
