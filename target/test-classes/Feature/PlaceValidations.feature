Feature: Validating Place Api's
@Addplace
Scenario Outline: Verify if places is being successfully added using addPlace API
  Given Add place payload "<name>" "<Language>" "<address>"
  When User calls "AddplaceAPI" with "post" httprequest
  Then The API call got success with status code 200
  And "status" in response body is "OK"
  And "scope" in response body is "APP"
  Then verify place_ID created maps to "<name>" using "getPlaceAPI"
  
  Examples:
  |name    |Language|address           |
  |AAhouse |English |World Cross center|
  #|BBhouse |Spanish |Twin tower|
  
  @DeletePlace
  Scenario: Verify if delete place functionality working
  
  Given DeletePlace payload
  When User calls "deletePlaceAPi" with "post" httprequest 
  Then The API call got success with status code 200
  And "status" in response body is "OK"