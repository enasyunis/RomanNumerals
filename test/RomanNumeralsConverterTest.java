import kata.RomanNumerals.RomanNumeralsConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsConverterTest {
    @Test
    public void WhenRomanNumeralsConverterIsPassedANumberItReturnsANumeral(){
        RomanNumeralsConverter converter = new RomanNumeralsConverter();
        assertEquals(converter.toRomanNumeral(1), "I");
        assertEquals(converter.toRomanNumeral(2), "II");

    }
}
