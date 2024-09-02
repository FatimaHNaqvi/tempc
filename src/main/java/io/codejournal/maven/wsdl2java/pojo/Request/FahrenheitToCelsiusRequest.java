package io.codejournal.maven.wsdl2java.pojo.Request;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

@Data
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class FahrenheitToCelsiusRequest {

    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "FahrenheitToCelsiusRequestBody", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    public static class Body {
        @XmlElement(name = "FahrenheitToCelsius", namespace = "https://www.w3schools.com/xml/")
        private FahrenheitToCelsiusRequest.FahrenheitToCelsius fahrenheitToCelsius;
    }

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class FahrenheitToCelsius {
        @XmlElement(name = "Fahrenheit", namespace = "https://www.w3schools.com/xml/")
        private float fahrenheit;
    }

}
