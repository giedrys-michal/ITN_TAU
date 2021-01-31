package ITN_TAU.REST_API;

import java.io.IOException;

import service.ConnectionService;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	String url = "https://my-json-server.typicode.com/giedrys-michal/ITN_TAU/leki/1";
    	ConnectionService cs = new ConnectionService(url);
    	int respCode = cs.getResponseCodeFromServer();
    	String respMsg = cs.getResponseMsgFromServer();
    	String nazwaLeku = cs.readFromServer().nazwa;
    	
    	System.out.println(respCode);
    	System.out.println(respMsg);
    	System.out.println(nazwaLeku);
    	
    }
}
