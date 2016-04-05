package kata.RomanNumerals;


public class RomanNumeralsConverter {
    public String toRomanNumeral(Integer arabicNumber) {
        StringBuilder sb = new StringBuilder();
        int leftOver = arabicNumber;

        /*
            Future Developer - The order of the statements matters!
         */
        while (leftOver > 0) {
            if (leftOver >= 500) {
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
}
