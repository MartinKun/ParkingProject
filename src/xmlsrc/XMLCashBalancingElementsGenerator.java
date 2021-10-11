package xmlsrc;

import org.w3c.dom.Element;

public class XMLCashBalancingElementsGenerator extends DOMGenerator{

	public XMLCashBalancingElementsGenerator() {
		super();
	}
	@Override
	protected void generateDocument() {
		Element cashBalancing = document.createElement("cash_balancing");
        document.appendChild(cashBalancing);
		
	}

}
