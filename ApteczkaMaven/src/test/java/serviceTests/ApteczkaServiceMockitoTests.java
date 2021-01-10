package serviceTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.joda.time.DateTime;

import static org.mockito.BDDMockito.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

import domain.Apteczka;
import service.ApteczkaService;

public class ApteczkaServiceMockitoTests {
	Apteczka ap_1Mock = mock(Apteczka.class);
	Apteczka ap_2Mock = mock(Apteczka.class);
	ApteczkaService asMock = mock(ApteczkaService.class);
	
	@Test
	public void getApteczka() {
		Apteczka expected;
		
		asMock.addApteczka(ap_1Mock);
		given(asMock.getApteczka(0)).willReturn(ap_1Mock);
		expected = asMock.getApteczka(0);
		
		assertTrue(ap_1Mock.equals(expected));
	}
	
	@Test
	public void deleteAllApteczki() {
		asMock.addApteczka(ap_1Mock);
		asMock.addApteczka(ap_2Mock);
		asMock.deleteAllApteczki();
		
		assertEquals(0, asMock.getAllApteczki().size());
	}
	
	@Test
	public void isApteczka_1DataUtworzeniaNotNull() {
		when(ap_1Mock.getData_utworzenia()).thenReturn(new DateTime());
		
		assertNotNull(ap_1Mock.getData_utworzenia());
	}
}
