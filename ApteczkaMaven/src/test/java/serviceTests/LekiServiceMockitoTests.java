package serviceTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.*;

import org.joda.money.Money;
import org.junit.Test;

import static org.junit.Assert.*;

import domain.Lek;
import service.LekiService;

public class LekiServiceMockitoTests {
	Lek lek_1Mock = mock(Lek.class);
	LekiService ls = mock(LekiService.class);
	
	@Test
	public void addLek() {
		int ilosc;
		
		when(lek_1Mock.getIlosc()).thenReturn(20);
		ilosc = lek_1Mock.getIlosc();
		assertEquals(20, ilosc);		
	}
	
	@Test
	public void convertCenaToCurrency() {
		Money convertedAmount;
		Money expectedAmount = Money.parse("USD 5.00");
		BigDecimal convRate = BigDecimal.valueOf(0.2500);
		
		given(lek_1Mock.convertCenaToCurrency("USD", convRate)).willReturn(expectedAmount);
		convertedAmount = lek_1Mock.convertCenaToCurrency("USD", convRate);
		assertTrue(expectedAmount.equals(convertedAmount));
	}
	
	@Test
	public void cenaSum() {
		Money suma;
		
		when(ls.cenaSum()).thenReturn(Money.parse("PLN 60.00"));
		suma = ls.cenaSum();
		assertTrue("PLN 60.00".equals(suma.toString()));		
		
	}
}
