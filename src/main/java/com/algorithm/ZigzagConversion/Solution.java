package com.algorithm.ZigzagConversion;

class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        Character[][] charsArray = new Character[numRows][s.length()];

        //flag为false时代表从上往下，true代表从左下往右上
        boolean flag = false;

        //摆好位置
        for (int i = 0, j = 0, k = 0; k < s.length(); k++) {
            charsArray[i][j] = s.charAt(k);

            if (!flag) {
                if (++i == numRows - 1) {
                    flag = true;
                }
            } else {
                j++;
                if (--i == 0) {
                    flag = false;
                }
            }


        }

        //按行读取
        StringBuffer res = new StringBuffer();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                Character c = charsArray[i][j];
                if (c != null) {
                    res.append(c);
                }

            }
        }
        return res.toString();
    }
}
