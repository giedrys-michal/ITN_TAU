package service;

import java.util.ArrayList;
import java.util.List;

import domain.Apteczka;

public class ApteczkaService {
	public ApteczkaService() {
		
	}
	
	public List<Apteczka> apteczki = new ArrayList<Apteczka>();
	
	public void addApteczka(Apteczka ap) {
		this.apteczki.add(ap);
	}
	public Apteczka getApteczka(int index) {
		return this.apteczki.get(index);
	}
	public List<Apteczka> getAllApteczki() {
		return this.apteczki;
	}
	public void deleteApteczka(int index) {
		this.apteczki.remove(index);
	}
	public void deleteAllApteczki() {
		this.apteczki.clear();
	}
}
