package kata.RomanNumerals;


public class RomanNumeralsConverter {
    public String toRomanNumeral(Integer arabicNumber) {
        StringBuilder sb = new StringBuilder();
        int leftOver = arabicNumber;

        /*
            Future Developer - The order of the statements matters!
         */
        while (leftOver > 0) {
            if (leftOver >= 100) {
                sb.append("C");
                leftOver -= 100;
            } else if (leftOver >= 90) { // interesting how I don't have to test for ANY repetition
                sb.append("XC");
                leftOver -= 90;
            } else if (leftOver >= 50) { // interesting how I don't have to test for ANY repetition
                sb.append("L");
                leftOver -= 50;
            } else if (leftOver >= 40) { // not a terminal point for == (if wishing to over think the 9 and 4)
                sb.append("XL");
                leftOver -= 40;
            } else if (leftOver >= 10) { // interesting how I never have to test for more than 3 repetitions
                sb.append("X");
                leftOver -= 10;
            } else if (leftOver >= 9) { // == would have been sufficient - but will not over think it - per TDD
                sb.append("IX");
                leftOver -= 9;
            } else if (leftOver >= 5) {
                sb.append("V");
                leftOver -= 5;
            } else if (leftOver >= 4) { // == would have been sufficient - but will not over think it - per TDD
                sb.append("IV");
                leftOver -= 4;
            } else if (leftOver >= 1) {
                sb.append("I");
                leftOver--;
            }
        }
        return sb.toString();
    }
}
