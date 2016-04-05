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
        assertEquals("Passing 9","IX", converter.toRomanNumeral(9));

        assertEquals("Passing 50","L", converter.toRomanNumeral(50));
        assertEquals("Passing 40","XL", converter.toRomanNumeral(40));

        // testing 49 for the sake of validation :)
        assertEquals("Passing 49","XLIX", converter.toRomanNumeral(49));

        assertEquals("Passing 100","C", converter.toRomanNumeral(100));
        assertEquals("Passing 90","XC", converter.toRomanNumeral(90));

        assertEquals("Passing 500","D", converter.toRomanNumeral(500));
        assertEquals("Passing 400","CD", converter.toRomanNumeral(400));

        assertEquals("Passing 1000","M", converter.toRomanNumeral(1000));
        assertEquals("Passing 900","CM", converter.toRomanNumeral(900));

    }

}
