import kata.RomanNumerals.RomanNumeralsConverter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsConverterTest {

    private RomanNumeralsConverter converter;

    @Before
    public void setup() {
        converter = new RomanNumeralsConverter();
    }

    @Test
    public void WhenRomanNumeralsConverterIsPassedANumberItReturnsANumeral(){

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

        // extra valid tests to make sure
        assertEquals("Passing 3999","MMMCMXCIX", converter.toRomanNumeral(3999)); // max number
        assertEquals("Passing 0","", converter.toRomanNumeral(0)); // min number


    }


    // TODO :: find a better way to test illegals being thrown than multiple separate tests
    @Test(expected = IllegalArgumentException.class)
    public void WhenRomanNumeralsConverterIsPassedAnInvalidNumberItShouldFail() {
        converter.toRomanNumeral(4000);
    }


    @Test(expected = IllegalArgumentException.class)
    public void WhenRomanNumeralsConverterIsPassedAnInvalidNegativeNumberItShouldFail() {
        converter.toRomanNumeral(-1);
    }

    @Test
    public void WhenRomanNumeralConverterIsPassedASingleRomanCharItReturnsANumber() {
        assertEquals("Passing M", 1000, converter.toArabicNumber("M"));
        assertEquals("Passing D", 500, converter.toArabicNumber("D"));
        assertEquals("Passing C", 100, converter.toArabicNumber("C"));
        assertEquals("Passing L", 50, converter.toArabicNumber("L"));
        assertEquals("Passing X", 10, converter.toArabicNumber("X"));
        assertEquals("Passing V", 5, converter.toArabicNumber("V"));
        assertEquals("Passing I", 1, converter.toArabicNumber("I"));
    }


    @Test
    public void WhenRomanNumeralConverterIsPassedTwoRomanCharsItReturnsANumber() {
        assertEquals("Passing MM", 2000, converter.toArabicNumber("MM"));
        assertEquals("Passing MC", 1100, converter.toArabicNumber("MC"));

        assertEquals("Passing CM", 900, converter.toArabicNumber("CM"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void WhenRomanNumeralsConverterIsPassedAnInvalidRomanCharacterShouldFail() {
        converter.toArabicNumber("J");
    }


}
