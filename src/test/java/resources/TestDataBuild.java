package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.seriliaze;

public class TestDataBuild {
   public seriliaze addPlacePayload(String name,String language,String address) {
	   seriliaze sl = new seriliaze();
		sl.setAccuracy(50);
		sl.setAddress(address);
		sl.setLanguage(language);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		sl.setLocation(l);
		sl.setPhone_number("(+91) 983 893 3937");
		sl.setName(name);
		sl.setWebsite("www.rahulshetty.com");
		
		List<String> ls = new ArrayList<String>();
		ls.add("shoe park");
		ls.add("shop");
		
		sl.setTypes(ls);
		return sl;
   }
   
   public String deletePlacePayload(String place_id) {
	   return "{\r\n"
	   		+ "    \"place_id\":\""+place_id+"\"\r\n"
	   		+ "}\r\n"
	   		+ "";
   }
}
