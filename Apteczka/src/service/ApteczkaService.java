package service;

import java.util.ArrayList;
import java.util.List;

import domain.Lek;

public class ApteczkaService {
	public List<Lek> leki = new ArrayList<Lek>();
	
	public void addLek(Lek lek) {
		this.leki.add(lek);
	}
	public Lek getLek(Lek lek) {
		return this.leki.get(this.leki.indexOf(lek));
	}
	public List<Lek> getAllLeki() {
		return this.leki;
	}
	public void deleteLek(Lek lek) {
		this.leki.remove(this.leki.indexOf(lek));
	}
	public void deleteAllLeki() {
		this.leki.clear();
	}
	
	public double cenaSum() {
		double suma = 0.0;
		for (Lek lek : leki) {
			suma += lek.getCena();
		}
		return suma;
	}
}
