package service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Lek;

public class ConnectionService {
	URL url;
	HttpURLConnection conn;
	
	public ConnectionService(String url) {
		try {
			this.url = new URL(url);
			
			conn = (HttpURLConnection) this.url.openConnection();
			conn.setRequestProperty("accept", "application/json");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getResponseCodeFromServer() throws IOException {
		return conn.getResponseCode();
	}
	
	public String getResponseMsgFromServer() throws IOException {
		return conn.getResponseMessage();
	}
	
	public Lek readFromServer() throws IOException {
		InputStream responseStream = conn.getInputStream();
		ObjectMapper om = new ObjectMapper();
		Lek mappedResponse = om.readValue(responseStream, Lek.class);
		
		return mappedResponse;
	}
	
}
