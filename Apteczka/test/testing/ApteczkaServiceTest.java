package testing;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import domain.Lek;
import service.ApteczkaService;

public class ApteczkaServiceTest {
	
	private final ApteczkaService ap = new ApteczkaService();
	
	Lek lek_1 = new Lek(0, "Lek_1", "Tabletka", 20, 45.0);
	Lek lek_2 = new Lek(1, "Lek_2", "Tabletka", 40, 15.0);
	
	
	@BeforeAll
	void initAll() {		
		ap.addLek(lek_1);
	}

	@Test
	public void test() {
		assertEquals("Lek_1", ap.getLek(lek_1).nazwa);
	}

}
