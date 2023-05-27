package com.algorithm.StringToInteger;

public class Solution {

    public int myAtoi(String s) {
        int length = s.length();

        boolean startReadDigit = false;

        boolean isPositive = true;

        int res = 0;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!startReadDigit) {
                if (isWhitespace(c)) {
                    continue;
                }
                if (isNegative(c)) {
                    isPositive = false;
                    startReadDigit = true;
                    continue;
                }

                if (isPositive(c)) {
                    startReadDigit = true;
                    continue;
                }
                if (isDigit(c)) {
                    res = coverToInt(c);
                    startReadDigit = true;
                    continue;
                }

                return 0;
            }
            if (startReadDigit) {
                if (isDigit(c)) {
                    int curRes = coverToInt(c);
                    if (!isPositive) {
                        curRes = -curRes;
                    }

                    if (isPositive) {
                        if (res > 214748364 || res == 214748364 && curRes > 7) {
                            return 2147483647;
                        }
                    } else {
                        if (res < -214748364 || res == -214748364 && curRes < -8) {
                            return -2147483648;
                        }
                    }
                    res = res * 10 + curRes;

                } else {
                    return res;
                }
            }

        }

        return res;
    }

    boolean isPositive(char c) {
        return c == '+';
    }

    boolean isNegative(char c) {
        return c == '-';
    }

    boolean isDigit(char c) {
        return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9';
    }

    boolean isWhitespace(char c) {
        return c == ' ';
    }

    int coverToInt(char c) {
        return c - 48;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("4193 with words"));
    }

}
