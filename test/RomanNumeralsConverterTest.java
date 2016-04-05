import kata.RomanNumerals.RomanNumeralsConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsConverterTest {
    @Test
    public void WhenRomanNumeralsConverterIsPassedANumberItReturnsANumeral(){
        RomanNumeralsConverter converter = new RomanNumeralsConverter();
        assertEquals("Passing 1", "I", converter.toRomanNumeral(1));
        assertEquals("Passing 2", "II", converter.toRomanNumeral(2));

        assertEquals("Passing 5", "V", converter.toRomanNumeral(5));
        assertEquals("Passing 4","IV", converter.toRomanNumeral(4));


        assertEquals("Passing 10","X", converter.toRomanNumeral(10));


    }

}
