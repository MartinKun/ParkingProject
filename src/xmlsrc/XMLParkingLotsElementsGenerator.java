/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlsrc;

import org.w3c.dom.Element;

/**
 *
 * @author conde
 */
public class XMLParkingLotsElementsGenerator extends DOMGenerator {

    private static final int PARKING_LOT_NUMBER = 16;

    public XMLParkingLotsElementsGenerator() {
        super();
    }

    @Override
    protected void generateDocument() {
        Element parkingLots = document.createElement("parking_lots");
        document.appendChild(parkingLots);

        for (int i = 0; i < PARKING_LOT_NUMBER; i++) {
            Element parkingLot = document.createElement("parking_lot");
            Element vehicleType = document.createElement("vehicle");
            Element vehiclePlate = document.createElement("plate");
            Element admissionDate = document.createElement("admission_date");
            Element admissionHour = document.createElement("admission_hour");

            parkingLots.appendChild(parkingLot);
            parkingLot.setAttribute("parking_lot", (i+1) + "");
            parkingLot.appendChild(vehicleType);
            parkingLot.appendChild(vehiclePlate);
            parkingLot.appendChild(admissionDate);
            parkingLot.appendChild(admissionHour);
            
            vehicleType.appendChild(document.createTextNode("empty"));
            vehiclePlate.appendChild(document.createTextNode("empty"));
            admissionDate.appendChild(document.createTextNode("empty"));
            admissionHour.appendChild(document.createTextNode("empty"));
        }
    }
}
