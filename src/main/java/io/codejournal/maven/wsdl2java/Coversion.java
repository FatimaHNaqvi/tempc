package io.codejournal.maven.wsdl2java;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class Coversion {
    public static void main(String[] args) throws MalformedURLException {
        final String endpoint = "https://www.w3schools.com/xml/tempconvert.asmx";
        final URL url = URI.create(endpoint).toURL();
        final TempConvert service = new TempConvert(url);
        final TempConvertSoap port = service.getPort(TempConvertSoap.class);
        Scanner obj = new Scanner(System.in);
        Double  value;
        Double out;
        value = Double.valueOf(obj.nextLine());
        out= Double.valueOf(port.celsiusToFahrenheit(String.valueOf(value)));
        System.out.println(out);

//        final NumberConversion  service = new NumberConversion(url);
//        final NumberConversionSoapType port = service.getPort(NumberConversionSoapType.class);
//        Scanner obj = new Scanner(System.in);
//        Scanner choice = new Scanner(System.in);
//        int value;
//        int Dec;
//        String dollar;
//        String word;
//        System.out.print("Choose:  \n1:Numbers To Dollar \n2:Numbers To Word \n3:Both \n");
//        Dec = Integer.parseInt(choice.nextLine());
//        System.out.print("Enter Number:");
//        value = Integer.parseInt(obj.nextLine());
//        dollar= port.numberToDollars(BigDecimal.valueOf(value));
//        word=port.numberToWords(BigInteger.valueOf(value));
//        if (Dec == 1){
//            System.out.println("Number in Dollars: "+dollar);
//        }
//        else if (Dec == 2){
//            System.out.println("Number in Words: "+word);
//        } else if (Dec == 3) {
//            System.out.println("Number in Dollars: "+dollar);
//            System.out.println("Number in Words: "+word);
//        }
//        else {
//            System.out.println("Wrong Choice");
//        }




    }}


