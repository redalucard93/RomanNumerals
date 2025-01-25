package org.training.tdd.romannumerals;

import java.util.Map;
import java.util.TreeMap;

import static org.training.tdd.romannumerals.RomanNumeral.romanNumeral;

public final class RomanNumeralConverter {

    BasicRomanNumerals basicRomanNumerals;

    RomanNumeralSubtractions subtractionCases;

    private final int number;

    public RomanNumeralConverter(int number) {

        this.basicRomanNumerals = new BasicRomanNumerals();
        this.subtractionCases = new RomanNumeralSubtractions();
        if (number == 0 || number > 3000)
            throw new IllegalArgumentException(String.format("Cannot convert %d to a roman numeral", number));
        //numbers = 0 or > 3000 are not acceptable
        this.number = number;

    }


    public RomanNumeral toRomanNumeral() {

        if (basicRomanNumerals.isBasicRomanNumeral(number)) return romanNumeral(basicRomanNumerals.get(number));

        if (canBeARepeatedBasicRomanNumeral(number)) {
            return generateRepeatedBasicRomanNumeralOf(number);
        }

        if (subtractionCases.isAResultOfSubtraction(number)) return romanNumeral(subtractionCases.get(number));

        return addOrSubtract();


    }

    private RomanNumeral addOrSubtract() {

        RomanNumeral additionResult = doAnAddition();
        RomanNumeral subtractionResult = doASubtraction();

        if (!subtractionResult.isValid() || subtractionResult.getLength() >= additionResult.getLength())
            return additionResult;
        return subtractionResult;
    }

    private RomanNumeral doASubtraction() {

        String subtractionResult;
        int lowerNumber;
        lowerNumber = (Integer) ((TreeMap) subtractionCases).lowerKey(number);

        subtractionResult = subtractionCases.get(lowerNumber) + new RomanNumeralConverter(number - lowerNumber).toRomanNumeral();

        return romanNumeral(subtractionResult);
    }


    private RomanNumeral doAnAddition() {

        int lowerNumber = basicRomanNumerals.getBasicLowerNumberOf(number);
        String left = basicRomanNumerals.get(lowerNumber);
        String right = new RomanNumeralConverter(number - lowerNumber).toRomanNumeral().toString();

        return romanNumeral(left + right);
    }


    boolean canBeARepeatedBasicRomanNumeral(int number) {

        if (number < 3000 && (isMultipleOf(1000) || (isMultipleOf(100) && (number / 100) <= 3) || (isMultipleOf(10) && (number / 10) <= 3) || number <= 3))
            return true;
        return false;

    }


    RomanNumeral generateRepeatedBasicRomanNumeralOf(int number) {

        String romanNumeralToBeRepeated = getRepeatableBasicRomanNumeralOf(number);
        int numberToRepeat = basicRomanNumerals.entrySet().stream().filter(e -> e.getValue().equals(romanNumeralToBeRepeated)).mapToInt(Map.Entry::getKey).findFirst().getAsInt();
        int numberOfRepeat = number / numberToRepeat;

        return romanNumeral(new RomanNumeralConverter(numberToRepeat).toRomanNumeral().toString()).repeat(numberOfRepeat);
    }


    private String getRepeatableBasicRomanNumeralOf(int number) {

        if (isMultipleOf(1000)) return "M";
        else if (isMultipleOf(100) && (number / 100) <= 3) return "C";
        else if (isMultipleOf(10) && (number / 10) <= 3) return "X";
        else if (number <= 3) return "I";
        else {
            return "";
        }


    }


    private boolean isMultipleOf(int multiplier) {

        return number % multiplier == 0;
    }


}
