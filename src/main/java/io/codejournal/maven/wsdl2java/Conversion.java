package io.codejournal.maven.wsdl2java;

import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        int choice;
       do{
           Scanner in = new Scanner(System.in);
        System.out.print("Choose:  \n1:CelsiusToFahrenhiet \n2:FahrenhietToCelsius \n3:Exit \n");
         choice = Integer.parseInt(in.nextLine());
         float value;
        switch (choice) {
            case 1:
                System.out.print("Enter Number:");
                value = Float.parseFloat(in.nextLine());
                TempConversion.CelsiusToFahrenhiet(value);
                break;
            case 2:
                System.out.print("Enter Number:");
                value = Float.parseFloat(in.nextLine());
                TempConversion.FahrenhietToCelsius(value);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }

    }while(choice != 4);

    }
}
