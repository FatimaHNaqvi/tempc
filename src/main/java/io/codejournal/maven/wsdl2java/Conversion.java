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
            System.out.print("Choose:  \n1:CelsiusToFahrenhiet \n2:FahrenhietToCelsius \n3:Exit \n");
            choice = Integer.parseInt(in.nextLine());
            System.out.print("Enter Number:");
            float value;
            value = Float.parseFloat(in.nextLine());

            switch (choice) {
                case 1:
                    //FIXME Nadia: repetitive code. Rather move this outside the switch for both case 1 and 2
                    //Fixed Fatima-Done
                    TempConversion.CelsiusToFahrenhiet(value);
                    break;
                case 2:

                    TempConversion.FahrenhietToCelsius(value);
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
}
