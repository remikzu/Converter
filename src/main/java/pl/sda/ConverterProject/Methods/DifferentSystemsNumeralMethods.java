package pl.sda.ConverterProject.Methods;
import pl.sda.ConverterProject.Interfaces.NumeralSystemConvertingMethods;

import java.util.Scanner;

/**
 * @author Remigiusz Zudzin
 */
//TODO dokumentacja
public class DifferentSystemsNumeralMethods implements NumeralSystemConvertingMethods {

    private int inputFormat;
    private int outputFormat;
    private Scanner sc = new Scanner(System.in);
    private static RomanNumeralMethods romanNumeralMethods = new RomanNumeralMethods();

    DifferentSystemsNumeralMethods() {
        this.inputFormat = 10;
        this.outputFormat = 10;
    }

    int getInputFormat() {
        return inputFormat;
    }

    int getOutputFormat() {
        return outputFormat;
    }

    @Override
    public void changeInputFormat() {
        System.out.println("Podaj format wejściowy który chcesz ustawić:");
        int format = sc.nextInt();
        if (format < Character.MIN_RADIX || format > Character.MAX_RADIX) {
            System.out.println("Radix musi być liczbą pomiędzy 2 a 36!");
        } else {
            inputFormat = format;
        }
    }

    @Override
    public void changeOutputFormat() {
        System.out.println("Podaj format wyjściowy który chcesz ustawić:");
        int format = sc.nextInt();
        if (format >= Character.MIN_RADIX && format <= Character.MAX_RADIX) {
            outputFormat = format;
        } else {
            System.out.println("Radix musi być liczbą pomiędzy 2 a 36!");
        }
    }

    @Override
    public void convertDifferentSystemNumber() {
        System.out.println("Podaj liczbę do zamiany: ");
        String differentSystemNumber = sc.next();
        System.out.println(Integer.toString(Integer.parseInt(differentSystemNumber, inputFormat), outputFormat));
    }

    @Override
    public void fromDifferentSystemToRoman() {
        System.out.println("Podaj liczbę do zamiany na rzymską:");
        String number = sc.next();

        try {
            if (Integer.valueOf(number, inputFormat) > 0 && Integer.valueOf(number, inputFormat) < 4000) {
                String romanNumber = romanNumeralMethods.convertInputToRoman(number, inputFormat);
                System.out.println("Wartość: " + romanNumber);
            } else {
                System.out.println("Podana liczba musi mieścić się w przedziale od 1 do 3999!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Format wprowadzonej liczby nie zgadza się z ustawieniem!");
        }
    }

    @Override
    public void fromRomanToDifferentSystem() {
        System.out.println("Podaj liczbę rzymską do zamiany na wybrany format:");
        String number = sc.next();
        String romanNumber = number.toUpperCase();

        if (romanNumeralMethods.isRomanNumberValid(romanNumber)) {
            String result = romanNumeralMethods.convertRomanToOutput(romanNumber, outputFormat);
            System.out.println("Wartość: " + result);
        } else {
            System.out.println("Podana liczba rzymska ma niewłaściwy format!");
        }
    }

    @Override
    public void fromRomanToDecimal() {
        System.out.println("Podaj liczbę rzymską: ");
        String number = sc.next();
        String romanNumber = number.toUpperCase();
        if (romanNumeralMethods.isRomanNumberValid(romanNumber)) {
            Integer result = romanNumeralMethods.convertRomanToDecimal(romanNumber);
            System.out.println("Wartość " + result);
        } else {
            System.out.println("Niepoprawny format liczby rzymskiej!");
        }
    }

    @Override
    public void fromDecimalToRoman() {
        System.out.println("Podaj liczbę arabską: ");
        Integer number = sc.nextInt();
        String romanNumber = romanNumeralMethods.convertDecimalToRoman(number);
        System.out.println("Wartość " + romanNumber);
    }
}
