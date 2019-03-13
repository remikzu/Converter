package pl.sda.ConverterProject.Methods;

import java.util.Scanner;

/**
 * @author Remigiusz Zudzin
 */
public class ConsoleGUI {

    DifferentSystemsNumeralMethods metody = new DifferentSystemsNumeralMethods();

    //TODO dokumentacja
    public void run() {

        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Konwerter v1.0");
        System.out.println("Autor: Remigiusz Zudzin");
        System.out.println("------------------------");
        do {
            System.out.println("Wybierz opcje:");
            System.out.println("1. Ustaw format wejściowy (obecnie: " + metody.getInputFormat() + ")");
            System.out.println("2. Ustaw format wyjściowy (obecnie: " + metody.getOutputFormat() + ")");
            System.out.println("3. Zamień liczbę rzymską na arabską");
            System.out.println("4. Zamień liczbę arabską na rzymską");
            System.out.println("5. Zamień liczbę rzymską na liczbę w wybranym formacie wyjściowym");
            System.out.println("6. Zamień liczbę w wybranym formacie wejściowym na rzrymską");
            System.out.println("7. Zamień liczbę w wybranym formacie wejściowym" +
                    " na liczbę w wybranym formacie wyjściowym");
            System.out.println("0. Wyjście z programu");
            int choice = sc.nextInt();

            switch(choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    metody.changeInputFormat();
                    break;
                case 2:
                    metody.changeOutputFormat();
                    break;
                case 3:
                    metody.fromRomanToDecimal();
                    break;
                case 4:
                    metody.fromDecimalToRoman();
                    break;
                case 5:
                    metody.fromRomanToDifferentSystem();
                    break;
                case 6:
                    metody.fromDifferentSystemToRoman();
                    break;
                case 7:
                    metody.convertDifferentSystemNumber();
                    break;
            }
        }while (!exit);
        sc.close();
    }

}
