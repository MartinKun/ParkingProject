package model.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "prices")
public class Prices {
	private String priceByHour;
	
	public Prices() {
		
	}

	@XmlElement(name = "price_by_hour")
	public String getPriceByHour() {
		return priceByHour;
	}

	public void setPriceByHour(String priceByHour) {
		this.priceByHour = priceByHour;
	}


	
	
}
