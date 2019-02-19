package com.qa.restassuredApiTesting;

import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.httpClient.RestClient;
import com.qa.utility.TestUtil;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class GetAPITestRestAssured extends TestBase{
	
	public TestBase testBase;
	public RestClient restClient;
	public String ServiceURL;
	public String pathURL;
	public String URL;
	CloseableHttpResponse httpResponse;
	
	 @BeforeMethod
	  public void beforeMethod() {
		 testBase =new TestBase();
		 ServiceURL=prop.getProperty("EndPointUrl");
		 pathURL=prop.getProperty("QueryParamURL");
		 
		 
		 URL=ServiceURL+pathURL;
		 //URL="https://reqres.in/api/users?page=2";
		 
		 
		 
	  }
	 
	 
  @Test(priority=1)
  public void testWithoutHeader() throws ClientProtocolException, IOException {
	  restClient=new RestClient();
	  this.httpResponse=restClient.get(URL);
	  
	  
		//Get The status code
		int statusCode=httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code ---->" +statusCode);
		Assert.assertEquals(statusCode, 200, "Staurs code is wrong");
		
		//Get the response opbjects
		
		String responseString=EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
		JSONObject responseJsonObject=new JSONObject(responseString);
		System.out.println("JonObject os------------>"+responseJsonObject);
		
		//Verify Page Value
		String PerPageValue=TestUtil.getValueByJPath(responseJsonObject, "/per_page");
		System.out.println("PerPageValue is -->"+PerPageValue);
		Assert.assertEquals(3, Integer.parseInt(PerPageValue), "Per Page Value is not matching");
		
		//Verify total_pages Value
		String totalPagesValue=TestUtil.getValueByJPath(responseJsonObject, "/total_pages");
		System.out.println("totalPagesValue is -->"+totalPagesValue);
		Assert.assertEquals(4, Integer.parseInt(totalPagesValue), "Per Page Value is not matching");
		
		//Verify First Name
		String firstName=TestUtil.getValueByJPath(responseJsonObject, "/data[0]/first_name");
		System.out.println("firstName is -->"+firstName);
		Assert.assertEquals("Eve", firstName, "First Name is wrong");
		
		//GetHeader
		Header[] headerArray= httpResponse.getAllHeaders();
		HashMap<String, String> herderMap=new HashMap<String, String>();
		
	  for(Header header: headerArray) {
		  
		  herderMap.put(header.getName(), header.getValue());
	  }
	  
	  System.out.println("All Headers -------> "+herderMap);
	  
	  
	  }
  
  @Test(priority=2)
  public void testWithHeader() throws ClientProtocolException, IOException {
	  restClient=new RestClient();
	  HashMap<String, String> Heas= new HashMap<String, String>();
	  Heas.put("Content-type", "application/json");
	  
	     httpResponse=restClient.get(URL,Heas);
	  
	  
		//Get The status code
		int statusCode=httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code ---->" +statusCode);
		Assert.assertEquals(statusCode, 200, "Staurs code is wrong");
		
		//Get the response opbjects
		
		String responseString=EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
		JSONObject responseJsonObject=new JSONObject(responseString);
		System.out.println("JonObject os------------>"+responseJsonObject);
		
		//Verify Page Value
		String PerPageValue=TestUtil.getValueByJPath(responseJsonObject, "/per_page");
		System.out.println("PerPageValue is -->"+PerPageValue);
		Assert.assertEquals(3, Integer.parseInt(PerPageValue), "Per Page Value is not matching");
		
		//Verify total_pages Value
		String totalPagesValue=TestUtil.getValueByJPath(responseJsonObject, "/total_pages");
		System.out.println("totalPagesValue is -->"+totalPagesValue);
		Assert.assertEquals(4, Integer.parseInt(totalPagesValue), "Per Page Value is not matching");
		
		//Verify First Name
		String firstName=TestUtil.getValueByJPath(responseJsonObject, "/data[0]/first_name");
		System.out.println("firstName is -->"+firstName);
		Assert.assertEquals("Eve", firstName, "First Name is wrong");
		
		//GetHeader
		Header[] headerArray= httpResponse.getAllHeaders();
		HashMap<String, String> herderMap=new HashMap<String, String>();
		
	  for(Header header: headerArray) {
		  
		  herderMap.put(header.getName(), header.getValue());
	  }
	  
	  System.out.println("All Headers -------> "+herderMap);
	  
	  
	  


		
	
  }
 
 

}
