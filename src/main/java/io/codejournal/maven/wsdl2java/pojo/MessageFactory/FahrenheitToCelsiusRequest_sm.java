package io.codejournal.maven.wsdl2java.pojo.MessageFactory;
import jakarta.xml.soap.*;
import java.io.ByteArrayOutputStream;
public class FahrenheitToCelsiusRequest_sm {
    public static SOAPMessage createFahrenheitToCelsiusRequest(String temperature)  {
    try {
        // Create a SOAP message
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        SOAPBody body = envelope.getBody();
        // Define the namespaces
        envelope.addNamespaceDeclaration("soap", "http://schemas.xmlsoap.org/soap/envelope/");
        // Add the SOAP Body content
        SOAPBodyElement bodyElement = body.addBodyElement(envelope.createName("FahrenheitToCelsius", "", "https://www.w3schools.com/xml/"));
        SOAPElement fahrenheitElement = bodyElement.addChildElement("Fahrenheit");
        fahrenheitElement.addTextNode(temperature); // Example Fahrenheit value
        // Save the changes to the SOAP message
        soapMessage.saveChanges();
        return soapMessage;
    }catch (Exception e) {
        e.printStackTrace();
    }
        return null;
    }
}
