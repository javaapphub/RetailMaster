package com.retail.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtilities {

	public static String getResponse(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String responseBody = null;
		try {
			HttpGet httpget = new HttpGet(url);

			System.out.println("Executing request " + httpget.getRequestLine());

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response)
						throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					String jsonOutput = "[]";
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						jsonOutput = (entity != null) ? EntityUtils
								.toString(entity) : "[]";
					} else {
						throw new ClientProtocolException(
								"Unexpected response status: " + status);
					}
					return jsonOutput;
				}
			};
			try {
				responseBody = httpclient.execute(httpget, responseHandler);
			} catch (IOException ioex) {
				ioex.printStackTrace();
			}
		} finally {
			try {
				httpclient.close();
			} catch (IOException ioex) {

			}
		}
		return responseBody;
	}
}
