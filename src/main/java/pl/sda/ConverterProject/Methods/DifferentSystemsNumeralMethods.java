package pl.sda.ConverterProject.Methods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.ConverterProject.Interfaces.NumeralSystemConvertingMethods;

/**
 * @author Remigiusz Zudzin
 */
public class DifferentSystemsNumeralMethods implements NumeralSystemConvertingMethods {

    @Override
    public long[] numberToIntTabConverter(String hexadecimalNumber) {
        return new long[0];
    }

    @Override
    public boolean isDifferentSystemNumberValid(String hexadecimalNumber) {
        return false;
    }

    @Override
    public long convertDifferentSystemNumberToDecimal(String hexadecimalNumber) {
        return 0;
    }

    @Override
    public long convertDecimalToDifferentSystemNumber(String differentSystemNumber) {
        return 0;
    }
}
