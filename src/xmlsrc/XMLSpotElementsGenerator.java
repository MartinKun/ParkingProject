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
public class XMLSpotElementsGenerator extends DOMGenerator {

    private static final int SPOTS_NUMBER = 5;

    public XMLSpotElementsGenerator() {
        super();
    }

    @Override
    protected void generateDocument() {
        Element vehicleSpots = document.createElement("spots");
        document.appendChild(vehicleSpots);

        for (int i = 0; i < SPOTS_NUMBER; i++) {
            Element vehicleSpot = document.createElement("spot");

            Element vehicleType = document.createElement("vehicle_type");
            //Element spotNumber = document.createElement("spot_number");
            Element vehiclePlate = document.createElement("vehicle_plate");
            Element admissionDate = document.createElement("admission_date");
            Element admissionHour = document.createElement("admission_hour");

            vehicleSpots.appendChild(vehicleSpot);
            vehicleSpot.setAttribute("spot", "A" + (i+1));
            vehicleSpot.appendChild(vehicleType);
            vehicleSpot.appendChild(vehiclePlate);
            vehicleSpot.appendChild(admissionDate);
            vehicleSpot.appendChild(admissionHour);
            
            vehicleType.appendChild(document.createTextNode("empty"));
            vehiclePlate.appendChild(document.createTextNode("empty"));
            admissionDate.appendChild(document.createTextNode("empty"));
            admissionHour.appendChild(document.createTextNode("empty"));
        }
    }
}
