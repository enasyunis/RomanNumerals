package kata.RomanNumerals;


public class RomanNumeralsConverter {
    public String toRomanNumeral(Integer arabicNumber) {
        StringBuilder sb = new StringBuilder();
        int leftOver = arabicNumber;
        while (leftOver > 0) {
            if (leftOver >= 5) {
                sb.append("V");
                leftOver -= 5;
            } else if (leftOver >= 4) {
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
