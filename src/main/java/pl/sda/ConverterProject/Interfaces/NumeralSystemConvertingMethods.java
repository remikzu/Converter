package pl.sda.ConverterProject.Interfaces;

/**
 * @author Remigiusz Zudzin
 */
public interface NumeralSystemConvertingMethods {
    public long[] numberToIntTabConverter(String hexadecimalNumber);
    public boolean isDifferentSystemNumberValid(String hexadecimalNumber);
    public long convertDifferentSystemNumberToDecimal(String hexadecimalNumber);
    public long convertDecimalToDifferentSystemNumber(String differentSystemNumber);

}
