package romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.training.tdd.romannumerals.Numerals;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumeralsTest {


    @Test
    void shouldConvert0ToEmptyString() {
        assertThat(Numerals.toRomanNumeral(0)).isEqualTo("");
    }

    @Test
    void shouldConvert1ToI() {
        assertThat(Numerals.toRomanNumeral(1)).isEqualTo("I");
    }

    @Test
    void shouldConvert2ToII() {
        assertThat(Numerals.toRomanNumeral(2)).isEqualTo("II");
    }

    @Test
    void shouldConvert4ToIV() {
        assertThat(Numerals.toRomanNumeral(4)).isEqualTo("IV");
    }

    @Test
    void shouldConvert5ToV() {
        assertThat(Numerals.toRomanNumeral(5)).isEqualTo("V");
    }

    @Test
    void shouldConvert6ToVI() {
        assertThat(Numerals.toRomanNumeral(6)).isEqualTo("VI");
    }

    @Test
    void shouldConvert9ToIX() {
        assertThat(Numerals.toRomanNumeral(9)).isEqualTo("IX");
    }

    @Test
    void shouldConvert10ToX() {
        assertThat(Numerals.toRomanNumeral(10)).isEqualTo("X");
    }

    @Test
    void shouldConvert40ToXL() {
        assertThat(Numerals.toRomanNumeral(100)).isEqualTo("C");
    }

    @Test
    void shouldConvert50ToL() {
        assertThat(Numerals.toRomanNumeral(50)).isEqualTo("L");
    }

    @Test
    void shouldConvert90ToXC() {
        assertThat(Numerals.toRomanNumeral(90)).isEqualTo("XC");
    }

    @Test
    void shouldConvert100ToC() {
        assertThat(Numerals.toRomanNumeral(100)).isEqualTo("C");
    }

    @Test
    void shouldConvert400ToCD() {
        assertThat(Numerals.toRomanNumeral(400)).isEqualTo("CD");
    }

    @Test
    void shouldConvert500ToD() {
        assertThat(Numerals.toRomanNumeral(500)).isEqualTo("D");
    }

    @Test
    void shouldConvert900ToCM() {
        assertThat(Numerals.toRomanNumeral(900)).isEqualTo("CM");
    }

    @Test
    void shouldConvert1000ToM() {
        assertThat(Numerals.toRomanNumeral(1000)).isEqualTo("M");
    }


}
