package romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.training.tdd.romannumerals.RomanNumeral;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.training.tdd.romannumerals.RomanNumeral.romanNumeral;
import static org.training.tdd.romannumerals.RomanNumeralConverter.romanNumeralConverter;

class RomanNumeralConverterTest {

    //TODO:1 Should be basic roman numeral : X : 10
    //TODO:2 I, X, C and M are roman numeral that can be repeated max 3 times, ex :  20 : XX
    //TODO:3 Should be a roman numeral number after applying subtraction rule , ex :   9 : IX
    //TODO:4 Should be a roman numeral number after addtion from largest to smallest, ex :  8 : VIII
    //TODO:5 Should be a roman numeral number after a mix of subtraction and addition, ex :   91 : XCI
    @ParameterizedTest
//    @CsvSource({
//            "10, X",
//            "20, XX",
//            "30, XXX",
//            "200, CC",
//            "9, IX",
//            "8, VIII",
//            "18, XVIII",
//            "19, XIX",
//            "41, XLI",
//            "91, XCI",
//            "639, DCXXXIX",
//            "1998, MCMXCVIII",
//            "2751, MMDCCLI"
//    })
    @CsvFileSource(resources = "/roman_numerals_test_data.csv", numLinesToSkip = 1)
    void shouldConvertIntToRomanNumeral(String number, String expectedRomanNumeral) {
        RomanNumeral actualRomanNumeral = romanNumeralConverter(Integer.parseInt(number.trim())).toRomanNumeral();
        assertThat(actualRomanNumeral.toString()).isEqualTo(expectedRomanNumeral);

    }


    @Test
    void shouldNotConvertIntToRomanNumeral() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class, () -> romanNumeralConverter(0));
        assertThat(thrown.getMessage()).isEqualTo("Cannot convert 0 to a roman numeral");

    }

    @Test
    void shouldBeAbleToDetectExcessiveRepetition() {
        assertThat(romanNumeral("XXXXI").isValid()).isFalse();
    }

    @Test
    void shouldNotBeAValidRomanNumber() {
        assertThat(romanNumeral("XIXXIX").isValid()).isFalse();
    }





}
