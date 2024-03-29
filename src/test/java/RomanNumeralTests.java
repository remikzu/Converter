

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.sda.ConverterProject.Methods.RomanNumeralMethods;
import static org.assertj.core.api.Assertions.*;

/**
 * @author Remigiusz Zudzin
 */
class RomanNumeralTests {

    RomanNumeralMethods roman = new RomanNumeralMethods();

    @ParameterizedTest
    @ValueSource(strings = {"MXVI", "MMMCC"})
    void isRomanNumberInCorrectOrder(String romanNumber) {
        assertThat(roman.isRomanNumberValid(romanNumber)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"MVXI", "MCCCCMMCC"})
    void isRomanNumberInCorrectOrderFail(String romanNumber) {
        assertThat(roman.isRomanNumberValid(romanNumber)).isEqualTo(false);
    }

    //TODO Testy dla metod związanych z liczbami Romańskimi
    //TODO dokumentacja dla testów
//    @ParameterizedTest
//    @CsvSource({"MXVI, 1016", "MMM, 3000"})
//    void isRomanNumberConversionCorrect(String romanNumber, Integer decimalNumber) {
//        assertThat(roman.convertRomanToOutput(romanNumber)).isEqualTo(decimalNumber);
//    }
//
//    @ParameterizedTest
//    @CsvSource({"MXVI, 1610", "MMM, 300"})
//    void isRomanNumberConversionNotCorrect(String romanNumber, Integer decimalNumber) {
//        assertThat(roman.convertRomanToOutput(romanNumber)).isNotEqualTo(decimalNumber);
//    }
//
//    @ParameterizedTest
//    @CsvSource({"1016, MXVI", "3000, MMM"})
//    void isDecimalNumberConversionCorrect(Integer decimalNumber, String romanNumber) {
//        assertThat(roman.convertInputToRoman(decimalNumber)).isEqualTo(romanNumber);
//    }
//
//    @ParameterizedTest
//    @CsvSource({"1610, MXVI", "300, MMM"})
//    void isDecimalNumberConversionNotCorrect(Integer decimalNumber, String romanNumber) {
//        assertThat(roman.convertInputToRoman(decimalNumber)).isNotEqualTo(romanNumber);
//    }
}
