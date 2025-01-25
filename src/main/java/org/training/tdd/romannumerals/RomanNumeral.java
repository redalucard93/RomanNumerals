package org.training.tdd.romannumerals;

import org.apache.commons.lang3.StringUtils;

public final class RomanNumeral {

    static final String INVALID_REPETITION_CASES = "IIII|VVVV|XXXX|LLLL|CCCC|DDDD|MMMM";

    private final String stringRepresentation;

    RomanNumeral(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }


    RomanNumeral repeat(int numberOfRepetition) {

        StringBuilder repeatedRomanNumeralBuilder = new StringBuilder();
        for(int j = 0; j < numberOfRepetition; j++) {
            repeatedRomanNumeralBuilder.append(stringRepresentation);
        }
        return romanNumeral(repeatedRomanNumeralBuilder.toString());
    }

    public boolean isValid() {

        RomanNumeralSubtractions subtractionCases = new RomanNumeralSubtractions();
        String invalidRepetitionPattern = ".*(" + INVALID_REPETITION_CASES + ").*";


        boolean subtractedCount = subtractionCases.values()
                .stream()
                .map( value -> StringUtils.countMatches(stringRepresentation, value))
                .anyMatch(count -> count > 1);

        return !stringRepresentation.isEmpty() && !stringRepresentation.matches(invalidRepetitionPattern) && !subtractedCount;
    }


    public static RomanNumeral romanNumeral(String input) {

        return new RomanNumeral(input);
    }

    int getLength() {

        return this.stringRepresentation.length();
    }

    public String toString() {
        return this.stringRepresentation;
    }



}
