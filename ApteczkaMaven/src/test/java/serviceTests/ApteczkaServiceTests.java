package serviceTests;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import domain.Apteczka;
import domain.Lek;
import service.ApteczkaService;
import service.LekiService;

public class ApteczkaServiceTests {
	public ApteczkaService as = new ApteczkaService();
	public LekiService ls = new LekiService();
	
	Lek lek_1 = new Lek(0, 0, "Lek_1", "Tabletka", 20, 45.0);
	Lek lek_2 = new Lek(1, 0, "Lek_2", "Tabletka", 40, 15.0);
	
	Apteczka ap_1 = new Apteczka(0, "Apteczka_1", DateTime.now(), ls.leki);
	
	@Test
	public void isApteczka_1NazwaEqual() {
		as.addApteczka(ap_1);
		assertEquals("Apteczka_1", as.getApteczka(0).getNazwa());		
	}
	
	@Test
	public void isApteczka_1LekiEmpty() {
		as.addApteczka(ap_1);
		assertTrue(as.getApteczka(0).leki.isEmpty());
	}
	
	@Test
	public void isApteczka_1LekiNotEmpty() {
		ls.addLek(lek_1);
		as.addApteczka(ap_1);
		assertFalse(as.getApteczka(0).leki.isEmpty());
	}
	
	@Test
	public void wasLekAddedToApteczka_1() {
		as.addApteczka(ap_1);
		int countInit = as.getApteczka(0).getLeki().size();
		ls.addLek(lek_1);
		int countModif = as.getApteczka(0).getLeki().size();
		assertEquals(++countInit, countModif);
	}
	
	@Test
	public void isApteczka_1DataUtworzeniaNotNull() {
		as.addApteczka(ap_1);
		assertNotNull(as.getApteczka(0).getData_utworzenia());
	}
}
