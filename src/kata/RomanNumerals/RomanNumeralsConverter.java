package kata.RomanNumerals;

/**
 * Implementing the Rules based on http://agilekatas.co.uk/katas/romannumerals-kata as seen on April 5, 2016
 */
public class RomanNumeralsConverter {
    /**
     * Converting from Arabic Numeral to Roman Numeral
     * @param arabicNumber the arabic number to be converted
     * @return Roman Numeral
     * @throws IllegalArgumentException - thrown when number exceeds 3999 or below zero
     */
    public String toRomanNumeral(Integer arabicNumber) throws IllegalArgumentException {

        int leftOver = arabicNumber;

        // test for out of bound numbers
        if (leftOver >= 4000) // due to the kata rule of max 3 repeats - even though other online converters have allowed for 4 M's
            throw new IllegalArgumentException("Can not convert to Roman beyond 3999 - the number (" + arabicNumber + ") is too large");

        if (leftOver < 0)
            throw new IllegalArgumentException("Can not convert to Roman below 0 - the number (" + arabicNumber + ") is too small");

        /*
            Future Developer - The order of the statements matters!
         */
        StringBuilder sb = new StringBuilder("");
        while (leftOver > 0) {
            if (leftOver >= 1000) {
                sb.append("M");
                leftOver -= 1000;
            } else if (leftOver >= 900) {
                sb.append("CM");
                leftOver -= 900;
            } else if (leftOver >= 500) {
                sb.append("D");
                leftOver -= 500;
            } else if (leftOver >= 400) {
                sb.append("CD");
                leftOver -= 400;
            } else if (leftOver >= 100) {
                sb.append("C");
                leftOver -= 100;
            } else if (leftOver >= 90) {
                sb.append("XC");
                leftOver -= 90;
            } else if (leftOver >= 50) {
                sb.append("L");
                leftOver -= 50;
            } else if (leftOver >= 40) { // not at a terminal point
                sb.append("XL");
                leftOver -= 40;
            } else if (leftOver >= 10) {
                sb.append("X");
                leftOver -= 10;
            } else if (leftOver == 9) { // Terminal Point - Kept bugging me to stay at >= works either way
                sb.append("IX");
                leftOver -= 9;
            } else if (leftOver >= 5) {
                sb.append("V");
                leftOver -= 5;
            } else if (leftOver == 4) { // Terminal Point - Kept bugging me to stay at >= works either way
                sb.append("IV");
                leftOver -= 4;
            } else if (leftOver >= 1) {
                sb.append("I");
                leftOver--;
            }
        }
        return sb.toString();
    }

    private int toArabicNumber(char romanNumeral) throws IllegalArgumentException {
        switch (romanNumeral) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                throw new IllegalArgumentException ("Not a roman numeral " + romanNumeral);
        }
    }
    private int toArabicNumberIfSpecialTwo(char charFirst, char charSecond) throws IllegalArgumentException {
        switch(charFirst) {
            case 'D':
                if (charSecond == 'D' || charSecond == 'M') {
                    return -1;
                }
                break;
            case 'C':
                if (charSecond == 'M') {
                    return 900;
                } else if (charSecond == 'D') {
                    return 400;
                }
                break;
            case 'L':
                if (charSecond != 'X' && charSecond != 'V' && charSecond != 'I') {
                    return -1;
                }
                break;
            case 'X':
                if (charSecond == 'C') {
                    return 90;
                } else if (charSecond == 'L') {
                    return 40;
                } else if ((charSecond == 'D') || (charSecond == 'M')) { // illegal next character
                    return -1;
                }
                break;
            case 'V':
                if (charSecond != 'I') { // illegal next character
                    return -1;
                }
                break;
            case 'I':
                if (charSecond == 'X') {
                    return 9;
                } else if (charSecond == 'V') {
                    return 4;
                } else if (charSecond != 'I') { // illegal next character
                    return -1;
                }
                break;
        }
        return 0; // not special two  or illegal either - return invalid value
    }


    private boolean isIllegalThreeCombinations(String romanNumeral) throws IllegalArgumentException {
        /* Multi-Subtraction options for 1400, 140, and 14 have only one legal form -
                subtraction when applied should be applied to the least significant letter
                that still provides for a correct number
          */
        if (romanNumeral.equals("CMD") || romanNumeral.equals("XCL") || romanNumeral.equals("IXV"))
            return true;


        // numbers that add to self!
        if (romanNumeral.equals("CDC") || romanNumeral.equals("XLX") || romanNumeral.equals("IVI"))
            return true;

        // not applying subtraction to the lowest level
        if (romanNumeral.equals("CMM") || romanNumeral.equals("CDD") ||
                romanNumeral.equals("XCC") || romanNumeral.equals("XLL") ||
                romanNumeral.equals("IXX") || romanNumeral.equals("IVV"))
            return true;

        // illegally applying multiple subtractions
        if (romanNumeral.equals("CCM") || romanNumeral.equals("CCD") ||
                romanNumeral.equals("XXC") || romanNumeral.equals("XXL") ||
                romanNumeral.equals("IIX") || romanNumeral.equals("IIV"))
            return true;

        return false;
    }

    /**
     * @param romanNumeral the string of roman numerals to be converted
     * @return the arabic number representign the roman numerals
     * @throws IllegalArgumentException if the argument does not represent a valid roman numeral
     */
    public int toArabicNumber(String romanNumeral) throws IllegalArgumentException {

        int index=0;
        int length=romanNumeral.length();
        int arabicNumber = 0;

        while (index < length) {

            if (index < length-2) { // at least three characters left
                if (isIllegalThreeCombinations(romanNumeral.substring(index, index+3))) {
                    throw new IllegalArgumentException("Not a valid roman numeral " + romanNumeral);
                }
            }

            if (index == length-1) {
                arabicNumber += toArabicNumber(romanNumeral.charAt(index));
                index++;
            } else { // two letters to consider
                int validNumberIfSpecialTwo = toArabicNumberIfSpecialTwo(romanNumeral.charAt(index), romanNumeral.charAt(index+1));
                if (validNumberIfSpecialTwo == -1) { // invalid
                    throw new IllegalArgumentException ("Not a roman numeral " + romanNumeral);
                } else if (validNumberIfSpecialTwo > 0) { // are special
                    arabicNumber += validNumberIfSpecialTwo;
                    index += 2;
                } else { // regular combo - treat one at a time
                    arabicNumber += toArabicNumber(romanNumeral.charAt(index));
                    index++;
                }
            }
        }

        return arabicNumber;
    }
}
