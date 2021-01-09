package domain;

import java.util.List;

import org.joda.time.DateTime;

public class Apteczka {
	public int id;
	public String nazwa;
	public DateTime data_utworzenia;
	public List<Lek> leki;
	
	public Apteczka(int id, String nazwa, DateTime data_utworzenia, List<Lek> leki) {
		this.id = id;
		this.nazwa = nazwa;
		this.data_utworzenia = data_utworzenia;
		this.leki = leki;
	}
		
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
	public DateTime getData_utworzenia() {
		return data_utworzenia;
	}
	public void setData_utworzenia(DateTime data_utworzenia) {
		this.data_utworzenia = data_utworzenia;
	}
	public List<Lek> getLeki() {
		return leki;
	}
	public void setLeki(List<Lek> leki) {
		this.leki = leki;
	}
	
	
	
}
