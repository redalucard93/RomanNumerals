package org.training.tdd.romannumerals;

import java.util.TreeMap;

public final class RomanNumeralSubtractions extends TreeMap<Integer, String> {

    RomanNumeralSubtractions() {

        this.put(4,"IV");
        this.put(9, "IX");
        this.put(40, "XL");
        this.put(90, "XC");
        this.put(400, "CD");
        this.put(900, "CM");
    }

    boolean isAResultOfSubtraction(int number) {
        return this.containsKey(number);
    }






}
