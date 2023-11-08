package StepDefinition;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")	
public void beforScenario() throws Exception {
	
	stepDef m = new stepDef();
	
	if(stepDef.place_id==null) {
	m.add_place_payload("Shetty", "French", "Asia");
	m.user_calls_with_httprequest("AddplaceAPI", "Post");
	m.verify_place_id_created_maps_to_using("Shetty", "getPlaceAPI");
	}
}
}
