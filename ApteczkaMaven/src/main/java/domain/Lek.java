package domain;

public class Lek {
	public Lek(int id, String nazwa, String typ, int ilosc, double cena) {
		this.id = id;
		this.nazwa = nazwa;
		this.typ = typ;
		this.ilosc = ilosc;
		this.cena = cena;
	}
	
	public int id;
	public String nazwa;
	public String typ;
	public int ilosc;
	public double cena;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}

}
