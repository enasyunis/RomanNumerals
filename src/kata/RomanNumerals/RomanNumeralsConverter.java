package kata.RomanNumerals;


public class RomanNumeralsConverter {
    public String toRomanNumeral(Integer arabicNumber) {
        StringBuilder sb = new StringBuilder();
        int leftOver = arabicNumber;
        while (leftOver > 0) {
            if (leftOver >= 10) {
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
