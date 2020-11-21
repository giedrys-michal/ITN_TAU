package testing;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import domain.Lek;
import service.ApteczkaService;

public class ApteczkaServiceTest {
	
	ApteczkaService ap = new ApteczkaService();
	
	Lek lek_1 = new Lek(0, "Lek_1", "Tabletka", 20, 45.0);
	Lek lek_2 = new Lek(1, "Lek_2", "Tabletka", 40, 15.0);
	
	@Test
	public void isLek_1NazwaEqual() {
		ap.addLek(lek_1);
		assertEquals("Lek_1", ap.getLek(0).getNazwa());
	}
	
	@Test
	public void isLek_2CenaNotNull() {
		ap.addLek(lek_1);
		ap.addLek(lek_2);
		assertNotNull(ap.getLek(1).getCena());
	}
	
	@Test
	public void isCenaSum60() {
		ap.addLek(lek_1);
		ap.addLek(lek_2);
		assertTrue(ap.cenaSum() == 60);
	}

}
