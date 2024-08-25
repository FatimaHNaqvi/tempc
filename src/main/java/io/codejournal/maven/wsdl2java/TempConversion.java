package io.codejournal.maven.wsdl2java;

import okhttp3.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.StringReader;

public class TempConversion {

    static void CelsiusToFahrenhiet(float celsius) {
        String soapRequest = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
                + "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<soap:Body>"
                + "<CelsiusToFahrenheit xmlns=\"https://www.w3schools.com/xml/\">"
                + "<Celsius>"+ celsius +"</Celsius>" // Example value for Celsius
                + "</CelsiusToFahrenheit>"
                + "</soap:Body>"
                + "</soap:Envelope>";

        // Create OkHttpClient instance
        OkHttpClient client = new OkHttpClient();

        // Create the request body
        RequestBody body = RequestBody.create(soapRequest, MediaType.get("text/xml; charset=utf-8"));

        // Build the request
        Request request = new Request.Builder()
                .url("https://www.w3schools.com/xml/tempconvert.asmx")
                .post(body)
                .addHeader("SOAPAction", "https://www.w3schools.com/xml/CelsiusToFahrenheit")
                .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Print the response
            String responseBody = response.body().string();
            System.out.println("Temperature in Fahrenheit: ");
            System.out.println(parseSoapResponse_celsius(responseBody));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void FahrenhietToCelsius(float fahrenheit) {
        String soapRequest = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
                + "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                + "<soap:Body>"
                + "<FahrenheitToCelsius xmlns=\"https://www.w3schools.com/xml/\">"
                + "<Fahrenheit>" + fahrenheit + "</Fahrenheit>" // Insert variable value
                + "</FahrenheitToCelsius>"
                + "</soap:Body>"
                + "</soap:Envelope>";

        // Create OkHttpClient instance
        OkHttpClient client = new OkHttpClient();

        // Create the request body
        RequestBody body = RequestBody.create(soapRequest, MediaType.get("text/xml; charset=utf-8"));

        // Build the request
        Request request = new Request.Builder()
                .url("https://www.w3schools.com/xml/tempconvert.asmx")
                .post(body)
                .addHeader("SOAPAction", "https://www.w3schools.com/xml/FahrenheitToCelsius")
                .build();

        // Execute the request and return the response
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Print the response
            String responseBody = response.body().string();
            System.out.println("Temperature in Celsius: ");
            System.out.println(parseSoapResponse_fahrenhiet(responseBody));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String parseSoapResponse_celsius(String responseXml) {
        try {
            // Initialize the DocumentBuilderFactory and DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the response XML
            Document doc = builder.parse(new InputSource(new StringReader(responseXml)));
            doc.getDocumentElement().normalize();

            // Extract the result from the response
            NodeList nodeList = doc.getElementsByTagName("CelsiusToFahrenheitResult");
            if (nodeList.getLength() > 0) {
                Element element = (Element) nodeList.item(0);
                return element.getTextContent();
            } else {
                return "No result found in the response.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error parsing response.";
        }
    }
    private static String parseSoapResponse_fahrenhiet(String responseXml) {
        try {
            // Initialize the DocumentBuilderFactory and DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the response XML
            Document doc = builder.parse(new InputSource(new StringReader(responseXml)));
            doc.getDocumentElement().normalize();

            // Extract the result from the response
            NodeList nodeList = doc.getElementsByTagName("FahrenheitToCelsiusResult");
            if (nodeList.getLength() > 0) {
                Element element = (Element) nodeList.item(0);
                return element.getTextContent();
            } else {
                return "No result found in the response.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error parsing response.";
        }
    }
}




