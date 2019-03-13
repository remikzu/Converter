package pl.sda.ConverterProject.Methods;

import pl.sda.ConverterProject.Enums.RomanNumeral;
import pl.sda.ConverterProject.Interfaces.RomanNumerals;

import java.util.List;

/**
 * @author Remigiusz Zudzin
 */
public class RomanNumeralMethods implements RomanNumerals {

    /**
     * Metoda sprawdza czy liczba rzymska jest w poprawnym formacie
     * @param romanNumber - liczba rzymska
     * @return true jeśli w poprawnym, false jeśli w niepoprawnym
     */
    @Override
    public Boolean isRomanNumberValid(String romanNumber){
        String romanRegex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        return romanNumber.matches(romanRegex);
    }

    /**
     * Metoda zamieniająca liczbę rzymską na arabską (w formacie dziesiętnym)
     * @param romanNumber - liczba rzymska
     * @return liczba arabska w formacie dziesiętnym
     */
    @Override //ok
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

    /**
     * Metoda zamieniająca liczbę arabską (w formacie dziesiętnym) na rzymską
     * @param decimalNumber - liczba arabska w formacie dziesiętnym
     * @return liczba rzymska
     */
    @Override //ok
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

    /**
     * Metoda zamieniająca liczbę rzymską na liczbę w dowolnym formacie
     * @param romanNumber - liczba rzymska
     * @param radix - liczba od 2 do 36 oznaczająca format liczbowy
     * @return - liczbę w wybranym formacie
     */
    @Override
    public String convertRomanToOutput(String romanNumber, Integer radix) {
        if(radix >= Character.MIN_RADIX && radix <= Character.MAX_RADIX) {
            if(isRomanNumberValid(romanNumber)) {
                return Integer.toString(convertRomanToDecimal(romanNumber), radix);
            } else throw new IllegalArgumentException("Niepoprawna liczba rzymska!");
        } else throw new IllegalArgumentException("Radix musi być w przedziale od 2 do 36!");
    }

    /**
     * Metoda zamieniająca liczbę w dowolnym formacie na liczbę rzymską
     * @param input - liczba w dowolnym formacie
     * @param radix - liczba od 2 do 36 oznaczająca format liczbowy
     * @return - liczba rzymska
     */
    @Override
    public String convertInputToRoman(String input, Integer radix) {
        if(radix >= Character.MIN_RADIX && radix <= Character.MAX_RADIX) {
            return convertDecimalToRoman(Integer.parseInt(input, radix));
        } else throw new IllegalArgumentException("Radix musi być w przedziale od 2 do 36!");

    }

}
