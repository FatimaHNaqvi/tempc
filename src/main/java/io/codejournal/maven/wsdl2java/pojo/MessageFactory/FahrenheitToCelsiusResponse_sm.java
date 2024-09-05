package io.codejournal.maven.wsdl2java.pojo.MessageFactory;
import jakarta.xml.soap.*;



public class FahrenheitToCelsiusResponse_sm {
    public static String sendRequest(SOAPMessage request) throws SOAPException {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        SOAPMessage response = soapConnection.call(request, "https://www.w3schools.com/xml/tempconvert.asmx?op=FahrenheitToCelsius");

        soapConnection.close();
        SOAPBody soapBody = response.getSOAPBody();
        SOAPBodyElement bodyElement = (SOAPBodyElement) soapBody.getChildElements().next();
        SOAPElement resultElement = (SOAPElement) bodyElement.getChildElements().next();

        // Return the text content of the result element
        return resultElement.getValue();
    }
}
