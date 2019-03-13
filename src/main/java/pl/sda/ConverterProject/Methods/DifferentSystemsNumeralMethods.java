package pl.sda.ConverterProject.Methods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.ConverterProject.Enums.DifferentSystemsNumeral;
import pl.sda.ConverterProject.Interfaces.NumeralSystemConvertingMethods;

import java.util.Scanner;

/**
 * @author Remigiusz Zudzin
 */
public class DifferentSystemsNumeralMethods implements NumeralSystemConvertingMethods {

    private int inputFormat;
    private int outputFormat;
    private Scanner sc;
    private final static RomanNumeralMethods romanNumeralMethods = new RomanNumeralMethods();

    DifferentSystemsNumeralMethods() {
        this.inputFormat = 10;
        this.outputFormat = 10;
    }

    @Override
    public void changeInputFormat() {
        System.out.println("Podaj format wejściowy który chcesz ustawić:");
        int format = sc.nextInt();
        if (format < Character.MIN_RADIX || format > Character.MAX_RADIX) {
            throw new IllegalArgumentException("Radix musi być liczbą pomiędzy 2 a 36!");
        } else {
            inputFormat = format;
        }
    }

    @Override
    public void changeOutputFormat() {
        System.out.println("Podaj format wyjściowy który chcesz ustawić:");
        int format = sc.nextInt();
        if (format < Character.MIN_RADIX || format > Character.MAX_RADIX) {
            throw new IllegalArgumentException("Radix musi być liczbą pomiędzy 2 a 36!");
        } else {
            outputFormat = format;
        }
    }

    @Override
    public void convertDifferentSystemNumber() {
        System.out.println("Podaj liczbę do zamiany: ");
        String differentSystemNumber = sc.nextLine();
        int intNumber = Integer.parseInt(differentSystemNumber, inputFormat);
        System.out.println("Wartość: " + Integer.toString(intNumber,outputFormat));
    }

    @Override
    public void fromDifferentSystemToRoman() {
        System.out.println("Podaj liczbę do zamiany na rzymską:");
        String number = sc.nextLine();
        String numString = number.toUpperCase();

        try {
            if (Integer.valueOf(numString, inputFormat) > 0 && Integer.valueOf(numString, outputFormat) < 4000) {
                String romanNumber = romanNumeralMethods.convertInputToRoman(numString, inputFormat);
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
        sc.nextLine();
        String romanNumber = sc.nextLine().toUpperCase();

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
        sc.nextLine();
        String romanNumber = sc.nextLine().toUpperCase();
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
