package xmlsrc;

import org.w3c.dom.Element;

public class XMLPricesElementsGenerator extends DOMGenerator{
	
	private static final int PRICE_BY_HOUR = 100;
	
	public XMLPricesElementsGenerator() {
		super();
	}

	@Override
	protected void generateDocument() {
		Element prices = document.createElement("prices");
        document.appendChild(prices);
        
        Element priceByHour = document.createElement("price_by_hour");
        
        prices.appendChild(priceByHour);
        priceByHour.appendChild(document.createTextNode(PRICE_BY_HOUR + ""));
		
	}

	
}
