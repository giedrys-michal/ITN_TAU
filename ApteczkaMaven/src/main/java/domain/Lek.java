package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.joda.money.*;

public class Lek {
	
	public int id;
	public int id_apteczka;
	public String nazwa;
	public String typ;
	public int ilosc;
	public final CurrencyUnit DEF_CURRENCY = CurrencyUnit.of("PLN");
	public Money cena;
	
	public Lek(int id, int id_apteczka, String nazwa, String typ, int ilosc, double cena) {
		this.id = id;
		this.id_apteczka = id_apteczka;
		this.nazwa = nazwa;
		this.typ = typ;
		this.ilosc = ilosc;
		this.cena = Money.of(DEF_CURRENCY, cena);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_apteczka() {
		return id_apteczka;
	}
	public void setId_apteczka(int id_apteczka) {
		this.id_apteczka = id_apteczka;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	public int getIlosc() {
		return ilosc;
	}
	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}
	public Money getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = Money.of(DEF_CURRENCY, cena);
	}
	
	public Money convertCenaToCurrency(String currencyISOcode, BigDecimal conversionRate) {
		CurrencyUnit currency = CurrencyUnit.of(currencyISOcode.toUpperCase());
		Money convertedAmount = this.cena.convertedTo(currency, conversionRate, RoundingMode.HALF_UP);
		return convertedAmount;
	}

}
