package resources;

public enum APIresources {
   AddplaceAPI("/maps/api/place/add/json"),
   getPlaceAPI("/maps/api/place/get/json"),
   deletePlaceAPi("/maps/api/place/delete/json");
	
	private String resources;
	APIresources(String resources){
		this.resources = resources;
	}
	
	public String getResource() {
		return resources;
	}
}
