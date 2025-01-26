package org.training.tdd.romannumerals;

import java.util.Map;
import java.util.TreeMap;


public class Numerals {

    private static final TreeMap<Integer, String> CONVERSIONS = new TreeMap<>(Map.ofEntries(
            Map.entry(1, "I"),
            Map.entry(4, "IV"),
            Map.entry(5, "V"),
            Map.entry(9, "IX"),
            Map.entry(10, "X"),
            Map.entry(40, "XL"),
            Map.entry(50, "L"),
            Map.entry(90, "XC"),
            Map.entry(100, "C"),
            Map.entry(400, "CD"),
            Map.entry(500, "D"),
            Map.entry(900, "CM"),
            Map.entry(1000, "M")

    ));

    public static String toRomanNumeral(int arabic) {

        StringBuilder romanNumeral = new StringBuilder();

        while (arabic > 0) {
            Map.Entry<Integer, String> entry = CONVERSIONS.floorEntry(arabic);
            romanNumeral.append(entry.getValue());
            arabic -= entry.getKey();
        }

        return romanNumeral.toString();


    }


}
