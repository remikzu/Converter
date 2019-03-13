package pl.sda.ConverterProject.Interfaces;

/**
 * @author Remigiusz Zudzin
 */
public interface RomanNumerals {

    public Boolean isRomanNumberValid(String romanNumber);
    Integer convertRomanToDecimal(String romanNumber);
    String convertRomanToOutput(String romanNumber, Integer radix);
    String convertDecimalToRoman(Integer decimalNumber);
    String convertInputToRoman(String decimalNumber, Integer radix);
}
