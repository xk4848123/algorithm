package com.algorithm.integerToRoman;

public class Solution {

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();

        //处理千位
        int k = num / 1000;
        for (int i = 0; i < k; i++) {
            res.append("M");
        }
        int rest = num % 1000;
        //处理百位
        int h = rest / 100;
        if (h <= 3) {
            for (int i = 0; i < h; i++) {
                res.append("C");
            }
        } else if (h == 4) {
            res.append("CD");
        } else if (h == 5) {
            res.append("D");
        } else if (h == 9) {
            res.append("CM");
        } else {
            res.append("D");
            for (int i = 5; i < h; i++) {
                res.append("C");
            }
        }
        rest = rest % 100;
        //处理十位
        int t = rest / 10;
        if (t <= 3) {
            for (int i = 0; i < t; i++) {
                res.append("X");
            }
        } else if (t == 4) {
            res.append("XL");
        } else if (t == 5) {
            res.append("L");
        } else if (t == 9) {
            res.append("XC");
        } else {
            res.append("L");
            for (int i = 5; i < t; i++) {
                res.append("X");
            }
        }

         rest = rest % 10;
        //处理个位
        int one = rest;
        if (one <= 3) {
            for (int i = 0; i < one; i++) {
                res.append("I");
            }
        } else if (one == 4) {
            res.append("IV");
        } else if (one == 5) {
            res.append("V");
        } else if (one == 9) {
            res.append("IX");
        } else {
            res.append("V");
            for (int i = 5; i < one; i++) {
                res.append("I");
            }
        }

        return res.toString();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(58));
    }

}
