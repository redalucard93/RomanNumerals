# Roman Numerals Kata

This repository contains a solution for the Roman Numerals Kata implemented in TDD, as described at [Coding Dojo](https://codingdojo.org/kata/RomanNumerals/). The kata involves converting between Roman numerals and integers. This README covers **Part 1** of the kata.

## Part 1: Converting from Integer to Roman Numerals

The objective is to implement a function that converts an integer (from 1 to 3000) into its Roman numeral representation.

### Roman Numeral System

Roman numerals are based on the following symbols:

| Symbol | Value |
|--------|-------|
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

### Rules for Roman Numerals

1. Symbols are placed from left to right in order of value, starting with the largest.
2. No symbol can be repeated more than three times in a row.
3. Subtractive notation is used for specific numbers:
   - **4** is written as `IV` (5 - 1).
   - **9** is written as `IX` (10 - 1).
   - **40** is written as `XL` (50 - 10).
   - **90** is written as `XC` (100 - 10).
   - **400** is written as `CD` (500 - 100).
   - **900** is written as `CM` (1000 - 100).

### Examples

- **1** -> `I`
- **4** -> `IV`
- **9** -> `IX`
- **58** -> `LVIII` (50 + 5 + 3)
- **1994** -> `MCMXCIV` (1000 + 900 + 90 + 4)

## Objective

Create a function that converts integers into Roman numerals. The function should handle integers in the range from 1 to 3000.


## License

This project is open-source and available under the MIT License.
