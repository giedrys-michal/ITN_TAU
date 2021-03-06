package service;

import java.util.ArrayList;
import java.util.List;

import org.joda.money.Money;

import domain.Lek;

public class LekiService {
	public List<Lek> leki = new ArrayList<Lek>();	
	
	public LekiService() {
		
	}
	
	public void addLek(Lek lek) {
		this.leki.add(lek);
	}
	public Lek getLek(int index) {
		return this.leki.get(index);
	}
	public List<Lek> getAllLeki() {
		return this.leki;
	}
	public void deleteLek(int index) {
		this.leki.remove(index);
	}
	public void deleteAllLeki() {
		this.leki.clear();
	}
	
	public Money cenaSum() {
		Money suma = Money.parse("PLN 0.00");
		for (Lek lek : leki) {
			suma = suma.plus(lek.getCena());
		}
		return suma;
	}
}
