package com.qa.httpClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	//Get Method With out header
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		
		//get method
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpGet httpGet=new HttpGet(url);
		CloseableHttpResponse httpResponse= httpClient.execute(httpGet);
		
		return httpResponse;

		
	}
	
	
	//Get Method with outHeader
  public CloseableHttpResponse get(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		
		//get method
		CloseableHttpClient httpClient= HttpClients.createDefault();
		HttpGet httpGet=new HttpGet(url);
		
		for(Map.Entry<String, String> entry :headerMap.entrySet()) {
			
			httpGet.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse httpResponse= httpClient.execute(httpGet);
		
		return httpResponse;

		
	}

}
