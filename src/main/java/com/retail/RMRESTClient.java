package com.retail;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.massmani.retailmaster.model.XMLBoundObject;
import com.massmani.retailmaster.ws.Param;
import com.massmani.retailmaster.ws.Params;
import com.massmani.retailmaster.ws.QueryInput;

public class RMRESTClient {
	
	String baseURL = null;
	
	public RMRESTClient(String baseURL) {
		setBaseURL(baseURL);
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}
	
	public String getGeneratedCode(String key, String defaultValue) {
		return executeGet("/AdvPlannerQueryService/generateCode?input=" + key + "&default=" + defaultValue);
	}

	public String executeInsert(String url, XMLBoundObject xmlBoundObject) {
		return executePost(url, xmlBoundObject);
	}

	public XMLBoundObject getXMLBoundObject(String url, XMLBoundObject defaultValue) {
		String output = executeGet(url);
		try {
			return (XMLBoundObject) defaultValue.unMarshal(output, defaultValue.getClass().getName());
		} catch (Exception ex) {
			ex.printStackTrace();
			return defaultValue;
		}
	}
	
	public XMLBoundObject getResult(String serviceClass, String methodName, String key, String[] paramStrings, XMLBoundObject defaultValue) {
		QueryInput queryInput = new QueryInput();
		queryInput.setKey(key);
		Params params = new Params();
		List<Param> paramList = new ArrayList<Param>();
		int index = 0;
		for (String paramString : paramStrings) {
			Param param = new Param("param-" + index++, paramString);
			paramList.add(param);
		}
		params.setParams(paramList);
		queryInput.setParams(params);
		return getXMLBoundObject("/" + serviceClass + "/" + methodName + "?input=" + URLEncoder.encode(queryInput.toString()), defaultValue);
	}
	
	public String executeGet(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String responseBody = null; 
		try {
		    HttpGet httpget = new HttpGet(baseURL + url);
		
		    System.out.println("Executing request " + httpget.getRequestLine());
		
		    // Create a custom response handler
		    ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
		
		        public String handleResponse(
		                final HttpResponse response) throws ClientProtocolException, IOException {
		            int status = response.getStatusLine().getStatusCode();
		            String output = "[]";
		            if (status >= 200 && status < 300) {
		                HttpEntity entity = response.getEntity();
		                output =  (entity != null)? EntityUtils.toString(entity) : "[]";
		            } else {
		                throw new ClientProtocolException("Unexpected response status: " + status);
		            }
		            return output;
		        }
		    };
		    try {
				responseBody = httpclient.execute(httpget, responseHandler);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("----------------------------------------");
		    System.out.println(responseBody);
		} finally {
		    try {
				httpclient.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return responseBody;
	}

	public String executePost(String urlString, XMLBoundObject xmlBoundObject) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		String result = null;
		try {
			xmlBoundObject.marshal(xmlBoundObject, xmlBoundObject.getClass().getName(), out);
			byte[] contents = out.toByteArray();
			out.close();
			result = executePost(urlString, contents);
			contents = null;
		} catch (ClassNotFoundException | IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}

	public String executePost(String urlString, byte[] contents) {
		String output = null;
		try {
			URL url = new URL(baseURL + urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			OutputStream os = conn.getOutputStream();
			os.write(contents);
			os.flush();
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			os.close();
			conn.disconnect();
		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }
		return output;
	}
}