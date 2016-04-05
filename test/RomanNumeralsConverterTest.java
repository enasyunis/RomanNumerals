import kata.RomanNumerals.RomanNumeralsConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsConverterTest {
    @Test
    public void WhenRomanNumeralsConverterIsPassedANumberItReturnsANumeral(){
        RomanNumeralsConverter converter = new RomanNumeralsConverter();
        assertEquals("Passing 1", converter.toRomanNumeral(1), "I");
        assertEquals("Passing 2", converter.toRomanNumeral(2), "II");

        assertEquals("Passing 5", converter.toRomanNumeral(5), "V");

    }

}
