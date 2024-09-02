package io.codejournal.maven.wsdl2java;

import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        int choice;
        //FIXME Nadia: indentations/formatting (ctrl+a then ctrl+alt+l)
        // Done Fatima: Done
        //TODO Nadia: purpose of do-while?
        // Done Fatima: I want the user to be able to convert temperature as many times as they want. Once done, they can exit
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Choose:  \n1:CelsiusToFahrenheit \n2:FahrenheitToCelsius \n3:Exit \n");
            choice = Integer.parseInt(in.nextLine());
            String Unit;
            switch (choice) {
                case 1:
                    //FIXME Nadia: repetitive code. Rather move this outside the switch for both case 1 and 2
                    //Fixed Fatima-Done
                    Unit= "Celsius";
                    Temp_handler.CelsiusToFahrenheit(Input_temp(Unit));
                    break;
                case 2:
                    Unit= "Fahrenheit";
                    Temp_handler.FahrenheitToCelsius(Input_temp(Unit));
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }

        } while (choice != 4);


    }
        public static float Input_temp(String Unit){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Temperature in "+Unit+":");
        float temp;
        temp = Float.parseFloat(in.nextLine());
        return temp;
    }
}
