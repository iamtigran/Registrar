package Kings.Registrar.Other;

public class RomanNumeralConverter {
    public  String convertToRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Number out of range");
        }

        // Define the Roman numeral symbols and their corresponding values
        String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] romanValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        StringBuilder romanNumeral = new StringBuilder();

        for (int i = 0; i < romanValues.length; i++) {
            while (number >= romanValues[i]) {
                romanNumeral.append(romanSymbols[i]);
                number -= romanValues[i];
            }
        }

        return romanNumeral.toString();
    }
}
