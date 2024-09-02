package io.codejournal.maven.wsdl2java.pojo.Request;

import jakarta.xml.bind.annotation.*;
import lombok.Data;


//import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class CelsiusToFahrenheitRequest {

    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    private Body body;

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "CelsiusToFahrenheitRequestBody", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    public static class Body {
        @XmlElement(name = "CelsiusToFahrenheit", namespace = "https://www.w3schools.com/xml/")
        private CelsiusToFahrenheit celsiusToFahrenheit;
    }

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class CelsiusToFahrenheit {
        @XmlElement(name = "Celsius", namespace = "https://www.w3schools.com/xml/")
        private float celsius;
    }
}
