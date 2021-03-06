import kata.RomanNumerals.RomanNumeralsConverter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


// TODO:: the test cases need to come from a file for illegal combination possibilities!!!

/**
 * validating accuracy using
 *  http://www.onlineconversion.com/roman_numerals_advanced.htm [strict] and
 *  http://www.csgnetwork.com/csgromancnv.html [not strict]
 *
 *  INFO :: not enough rules to make clear decisions on design - using above as test ideas
 */
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

        // testing the 1400 case if it returns CMD (invalid) or MCD (valid)
        assertEquals("Passing 1400","MCD", converter.toRomanNumeral(1400));


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
        assertEquals("Passing CC", 200, converter.toArabicNumber("CC"));

        assertEquals("Passing DC", 600, converter.toArabicNumber("DC"));
        assertEquals("Passing CD", 400, converter.toArabicNumber("CD"));

        assertEquals("Passing XC", 90, converter.toArabicNumber("XC"));
        assertEquals("Passing CX", 110, converter.toArabicNumber("CX"));

        assertEquals("Passing XL", 40, converter.toArabicNumber("XL"));
        assertEquals("Passing LX", 60, converter.toArabicNumber("LX"));

        assertEquals("Passing IX", 9, converter.toArabicNumber("IX"));
        assertEquals("Passing XI", 11, converter.toArabicNumber("XI"));

        assertEquals("Passing IV", 4, converter.toArabicNumber("IV"));
        assertEquals("Passing VI", 6, converter.toArabicNumber("VI"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void WhenRomanNumeralsConverterIsPassedAnInvalidRomanCharacterShouldFail() {
        converter.toArabicNumber("J");
    }

    @Test
    public void WhenRomanNumeralConverterIsPassedThreeRomanCharsItReturnsANumber() {
        assertEquals("Passing MMM", 3000, converter.toArabicNumber("MMM"));
        assertEquals("Passing CCC", 300, converter.toArabicNumber("CCC"));
        assertEquals("Passing XXX", 30, converter.toArabicNumber("XXX"));
        assertEquals("Passing III", 3, converter.toArabicNumber("III"));

        assertEquals("Passing MCM", 1900, converter.toArabicNumber("MCM"));
        assertEquals("Passing MCD", 1400, converter.toArabicNumber("MCD"));
    }

    @Test
    public void WhenRomanNumeralsConverterIsPassedLongValidRomanCharacterShouldPass() {
        assertEquals("Passing MMMCMXCIX", 3999, converter.toArabicNumber("MMMCMXCIX"));

        assertEquals("Passing MMMCMXCVIII", 3998, converter.toArabicNumber("MMMCMXCVIII"));
    }


    @Test
    public void WhenRomanNumeralsConverterIsCheckingValidRomansViaRegExShouldPass() {
        assertTrue(converter.isValidRomanNumeralUsingRegEx("M"));
        assertTrue(converter.isValidRomanNumeralUsingRegEx("MMM"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("MMMM"));
        assertTrue(converter.isValidRomanNumeralUsingRegEx("MMMCM"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("IIII"));

        assertFalse(converter.isValidRomanNumeralUsingRegEx("VV"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("DD"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("LL"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("XM"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("ID"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("XD"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("IC"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("CMD")); // per online MCD is the correct represntation
        assertFalse(converter.isValidRomanNumeralUsingRegEx("XCL"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("IXV"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("CDC"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("CMM"));
        assertFalse(converter.isValidRomanNumeralUsingRegEx("IXL"));

    }

}
