package io.codejournal.maven.wsdl2java.pojo.RESPONSE;


import io.codejournal.maven.wsdl2java.pojo.Request.CelsiusToFahrenheitRequest;
import jakarta.xml.bind.annotation.*;
import lombok.Data;

@Data
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class CelsiusTofahrenheitResponse {
  @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
  private Body body;

  @Data
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "CelsiusTofahrenheitResponseBody", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
  public static class Body {
    @XmlElement(name = "CelsiusToFahrenheitResponse", namespace = "https://www.w3schools.com/xml/")
    private CelsiusToFahrenheitResponse celsiusToFahrenheitResponse;
  }

  @Data
  @XmlAccessorType(XmlAccessType.FIELD)
  public static class CelsiusToFahrenheitResponse {
    @XmlElement(name = "CelsiusToFahrenheitResult", namespace = "https://www.w3schools.com/xml/")
    private float celsiusToFahrenheitResult;
  }

}
