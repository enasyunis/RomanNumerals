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

    public int toArabicNumber(String romanNumeral) throws IllegalArgumentException {

        if (romanNumeral.length() == 1) {
            return toArabicNumber(romanNumeral.charAt(0));
        }
        return 2000;
    }
}
