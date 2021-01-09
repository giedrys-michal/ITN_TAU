package serviceTests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.joda.money.Money;
import org.junit.Test;

import domain.Lek;
import service.LekiService;

public class LekiServiceTest {	
	public final BigDecimal CURR_CON_RATE = BigDecimal.valueOf(0.2500);
	LekiService ls = new LekiService();
	
	Lek lek_1 = new Lek(0, 0, "Lek_1", "Tabletka", 20, 20.0);
	Lek lek_2 = new Lek(1, 0, "Lek_2", "Tabletka", 40, 60.0);
	
	@Test
	public void isLek_1NazwaEqual() {
		ls.addLek(lek_1);
		assertEquals("Lek_1", ls.getLek(0).getNazwa());
	}
	
	@Test
	public void isLek_2CenaNotNull() {
		ls.addLek(lek_1);
		ls.addLek(lek_2);
		assertNotNull(ls.getLek(1).getCena());
	}
	
	@Test
	public void isCenaSum60PLN() {
		ls.addLek(lek_1);
		ls.addLek(lek_2);
		assertTrue(ls.cenaSum().toString().equals("PLN 80.00"));
	}
	
	@Test
	public void isLekiCountForApteczka0Equal2() {
		int count = 0;
		
		ls.addLek(lek_1);
		ls.addLek(lek_2);
		
		for (Lek lek : ls.leki) {
			if (lek.id_apteczka == 0)
				count++;
		}		
		assertEquals(2, count);
	}
	
	@Test
	public void isLek_1CenaConvertedToUSD() {
		ls.addLek(lek_1);
		Money converted = ls.getLek(0).convertCenaToCurrency("USD", CURR_CON_RATE);
		assertTrue(converted.toString().equals("USD 5.00"));
	}
}
