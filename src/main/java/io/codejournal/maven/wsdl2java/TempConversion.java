// NOT in USE anymore
//package io.codejournal.maven.wsdl2java;

//
//import okhttp3.*;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.NodeList;
//import org.xml.sax.InputSource;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import java.io.IOException;
//import java.io.StringReader;
//

//public class TempConversion {
//
//    //FIXME Nadia: Repetitive code. Create a separate method to handle client, requests and responses. Make use of arguments.
//    //FIXME Fatima: Created a method to handle the client, requests and responses.
//    static void CelsiusToFahrenhiet(float celsius) {
//        String Conversion = "CelsiusToFahrenheit";
//        String temperature_in = "Celsius";
//        String responseBody = Client_temp(celsius, Conversion, temperature_in);
//        String Element_CelsiusToFahrenheit = "CelsiusToFahrenheitResult";
//        System.out.println("Temperature in Fahrenheit: ");
//        System.out.println(parseSoapResponse(responseBody, Element_CelsiusToFahrenheit));
//
//    }
//
//    static void FahrenhietToCelsius(float fahrenheit) {
//        String Conversion = "FahrenheitToCelsius";
//        String temperature_in = "Fahrenheit";
//        String responseBody = Client_temp(fahrenheit, Conversion, temperature_in);
//        String Element_FahrenheitToCelsius = "FahrenheitToCelsiusResult";
//        System.out.println("Temperature in Celsius: ");
//        System.out.println(parseSoapResponse(responseBody, Element_FahrenheitToCelsius));
//
//    }
//
//    //FIXME Nadia: Repetitive code. The only difference between the 2 methods are the Element Names?
//    // Avoid repeating code to make reviewing code simpler and less time consuming for tech leads
//    //FIXED Fatima- Now using a single method for parsing of both celsius to fahrenheit and vise versa
//    private static String parseSoapResponse(String responseXml, String Element_name) {
//        try {
//            // Initialize the DocumentBuilderFactory and DocumentBuilder
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//
//            // Parse the response XML
//            Document doc = builder.parse(new InputSource(new StringReader(responseXml)));
//            doc.getDocumentElement().normalize();
//
//            // Extract the result from the response
//            NodeList nodeList = doc.getElementsByTagName(Element_name);
//            if (nodeList.getLength() > 0) {
//                Element element = (Element) nodeList.item(0);
//                return element.getTextContent();
//            } else {
//                return "No result found in the response.";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error parsing response.";
//        }
//    }
//
//    public static String Client_temp(float Temperature, String Conversion, String temperature_in) {
//        String soapRequest = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
//                + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
//                + "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
//                + "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
//                + "<soap:Body>"
//                + "<" + Conversion + " xmlns=\"https://www.w3schools.com/xml/\">"
//                + "<" + temperature_in + ">" + Temperature + "</" + temperature_in + ">"// Example value for Celsius
//                + "</" + Conversion + ">"
//                + "</soap:Body>"
//                + "</soap:Envelope>";
//
//        // Create OkHttpClient instance
//        OkHttpClient client = new OkHttpClient();
//
//        // Create the request body
//        RequestBody body = RequestBody.create(soapRequest, MediaType.get("text/xml; charset=utf-8"));
//
//        // Build the request
//        Request request = new Request.Builder()
//                .url("https://www.w3schools.com/xml/tempconvert.asmx")
//                .post(body)
//                .addHeader("SOAPAction", "https://www.w3schools.com/xml/" + Conversion)
//                .build();
//
//        // Execute the request
//        try (Response response = client.newCall(request).execute()) {
//            if (!response.isSuccessful()) {
//                throw new IOException("Unexpected code " + response);
//            }
//
//            // Print the response
//            return response.body().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//        return "Invalid response";
//    }
//}
//
//
//
