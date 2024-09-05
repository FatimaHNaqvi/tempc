package io.codejournal.maven.wsdl2java;

import io.codejournal.maven.wsdl2java.pojo.MessageFactory.FahrenheitToCelsiusRequest_sm;
import io.codejournal.maven.wsdl2java.pojo.MessageFactory.FahrenheitToCelsiusResponse_sm;
import jakarta.xml.soap.*;
import io.codejournal.maven.wsdl2java.pojo.RESPONSE.CelsiusTofahrenheitResponse;
import io.codejournal.maven.wsdl2java.pojo.RESPONSE.FahrenheitTocelsiusResponse;
import io.codejournal.maven.wsdl2java.pojo.Request.CelsiusToFahrenheitRequest;
import io.codejournal.maven.wsdl2java.pojo.Request.FahrenheitToCelsiusRequest;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.*;
public class Temp_handler {
    // Replace with your SOAP endpoint URL

    static void CelsiusToFahrenheit(float Temp) {
        try {

            CelsiusToFahrenheitRequest request = new CelsiusToFahrenheitRequest();
            CelsiusToFahrenheitRequest.Body body = new CelsiusToFahrenheitRequest.Body();
            CelsiusToFahrenheitRequest.CelsiusToFahrenheit celsiusToFahrenheit = new CelsiusToFahrenheitRequest.CelsiusToFahrenheit();
            celsiusToFahrenheit.setCelsius(Temp); // Example Celsius value
            body.setCelsiusToFahrenheit(celsiusToFahrenheit);
            request.setBody(body);

            // Marshal the request object to XML
            String soapRequest = String.valueOf(marshal(request, CelsiusToFahrenheitRequest.class));

            // Send SOAP request and receive response
            String soapResponse = Temp_Client.temp_client(soapRequest);

            // Unmarshal the response XML to a response object
            CelsiusTofahrenheitResponse response = unmarshal(soapResponse, CelsiusTofahrenheitResponse.class);

            // Print the response result
            System.out.println("Celsius to Fahrenheit Result: " + response.getBody().getCelsiusToFahrenheitResponse().getCelsiusToFahrenheitResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    static void FahrenheitToCelsius_test(float Temp) {
//        try {
//
//            FahrenheitToCelsiusRequest request = new FahrenheitToCelsiusRequest();
//            FahrenheitToCelsiusRequest.Body body = new FahrenheitToCelsiusRequest.Body();
//            FahrenheitToCelsiusRequest.FahrenheitToCelsius fahrenheitToCelsius = new FahrenheitToCelsiusRequest.FahrenheitToCelsius();
//            fahrenheitToCelsius.setFahrenheit(Temp); // Example Celsius value
//            body.setFahrenheitToCelsius(fahrenheitToCelsius);
//            request.setBody(body);
//
//            // Marshal the request object to XML
//            String soapRequest = String.valueOf(marshal(request, FahrenheitToCelsiusRequest.class));
//            // Send SOAP request and receive response
//            String soapResponse = Temp_Client.temp_client(soapRequest);
//
//            // Unmarshal the response XML to a response object
//            FahrenheitTocelsiusResponse response = unmarshal(soapResponse, FahrenheitTocelsiusResponse.class);
//
//            // Print the response result
//            System.out.println("Celsius to Fahrenheit Result: " + response.getBody().getFahrenheitToCelsiusResponse().getFahrenheitToCelsiusResult());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void FahrenheitToCelsius(float Temp) {
        try {
            SOAPMessage request = FahrenheitToCelsiusRequest_sm.createFahrenheitToCelsiusRequest(String.valueOf(Temp));
            String responseMessage = FahrenheitToCelsiusResponse_sm.sendRequest(request);
            System.out.println(responseMessage);
            System.out.println("Fahrenheit to celsius Result: " +responseMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T marshal(T request, Class<T> clazz) throws JAXBException {
        // Determine the JAXBContext class array based on the type of the request
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(request, sw);
        return (T) sw.toString();
    }


    public static <T> T unmarshal(String soapResponse, Class<T> clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader sr = new StringReader(soapResponse);
        return clazz.cast(unmarshaller.unmarshal(sr));
    }


}


