package serviceTests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import service.ConnectionService;

public class ConnectionServiceTests {
	String url_1 = "https://my-json-server.typicode.com/giedrys-michal/ITN_TAU/leki/15";
	String url_2 = "https://my-json-server.typicode.com/giedrys-michal/ITN_TAU/leki/4";
	
	@Test
	public void shouldRequestFail() {
		ConnectionService cs = new ConnectionService(url_1);
		try {
			assertEquals( cs.getResponseCodeFromServer(), 404 );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
    public void shouldResponseCodeBe200() {
		ConnectionService cs = new ConnectionService(url_2);
        try {
			assertTrue( cs.getResponseCodeFromServer() == 200 );
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	@Test
	public void shouldResponseBeNotNull() {
		ConnectionService cs = new ConnectionService(url_2);
		try {
			assertNotNull( cs.readFromServer() );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldLek4NameEqualKetonal() {
		ConnectionService cs = new ConnectionService(url_2);
		try {
			assertEquals( cs.readFromServer().nazwa, "Ketonal" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
