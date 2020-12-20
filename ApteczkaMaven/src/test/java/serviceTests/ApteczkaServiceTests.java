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
}
