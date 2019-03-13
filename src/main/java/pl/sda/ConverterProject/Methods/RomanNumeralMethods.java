package pl.sda.ConverterProject.Methods;

import pl.sda.ConverterProject.Enums.RomanNumeral;
import pl.sda.ConverterProject.Interfaces.RomanNumerals;

import java.util.List;

/**
 * @author Remigiusz Zudzin
 */
public class RomanNumeralMethods implements RomanNumerals {

    @Override
    public Boolean isRomanNumberValid(String romanNumber) {
        String romanRegex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        return romanNumber.matches(romanRegex);
    }

    @Override
    public Integer convertRomanToDecimal(String romanNumber) {
        if (!isRomanNumberValid(romanNumber)) throw new IllegalArgumentException("Zły format liczby Romańskiej!");
        String romanNumeral = romanNumber;
        int result = 0;
        //sortowanie w kolejnosci malejacej
        List<RomanNumeral> listOfRomanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        while ((romanNumeral.length() > 0) && (i < listOfRomanNumerals.size())) {
            RomanNumeral symbol = listOfRomanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        return result;
    }

    @Override
    public String convertDecimalToRoman(Integer decimalNumber) {
        if (decimalNumber <= 0 || decimalNumber > 4000) {
            throw new IllegalArgumentException(decimalNumber + " musi być większy od 0 i mniejszy od 4000!");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((decimalNumber > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if(currentSymbol.getValue() <= decimalNumber) {
                sb.append(currentSymbol.name());
                decimalNumber -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
