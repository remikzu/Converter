package pl.sda.ConverterProject.Interfaces;

/**
 * @author Remigiusz Zudzin
 */
public interface RomanNumerals {

    Boolean isRomanNumberValid(String romanNumber);
    Integer convertRomanToDecimal(String romanNumber);
    String convertDecimalToRoman(Integer decimalNumber);

}
