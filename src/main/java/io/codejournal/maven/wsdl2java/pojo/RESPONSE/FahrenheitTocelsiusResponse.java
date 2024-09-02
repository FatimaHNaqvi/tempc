package io.codejournal.maven.wsdl2java.pojo.RESPONSE;


import jakarta.xml.bind.annotation.*;
import lombok.Data;

@Data
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class FahrenheitTocelsiusResponse {
    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "FahrenheitTocelsiusResponseBody", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    public static class Body {
        @XmlElement(name = "FahrenheitToCelsiusResponse", namespace = "https://www.w3schools.com/xml/")
        private FahrenheitToCelsiusResponse fahrenheitToCelsiusResponse;
    }

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class FahrenheitToCelsiusResponse {
        @XmlElement(name = "FahrenheitToCelsiusResult", namespace = "https://www.w3schools.com/xml/")
        private float FahrenheitToCelsiusResult;
    }

}