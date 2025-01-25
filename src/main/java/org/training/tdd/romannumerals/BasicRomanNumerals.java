package org.training.tdd.romannumerals;

import java.util.TreeMap;

class BasicRomanNumerals extends TreeMap<Integer, String> {

    BasicRomanNumerals() {

        this.put(1, "I");
        this.put(5, "V");
        this.put(10, "X");
        this.put(50, "L");
        this.put(100, "C");
        this.put(500, "D");
        this.put(1000, "M");
    }


    int getBasicLowerNumberOf(int number) {

        return (number < 5) ? 1 : this.lowerKey(number);
    }


    boolean isBasicRomanNumeral(int number) {

        return this.containsKey(number);
    }


}
