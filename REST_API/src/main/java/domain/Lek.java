package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Lek {
	public final int id;
	public final String nazwa;
	public final String typ;
	public final int ilosc;
	
	public Lek(@JsonProperty("id") int id,
			   @JsonProperty("nazwa") String nazwa,
			   @JsonProperty("typ") String typ,
			   @JsonProperty("ilosc") int ilosc) {
		this.id = id;
		this.nazwa = nazwa;
		this.typ = typ;
		this.ilosc = ilosc;
	}	
}
