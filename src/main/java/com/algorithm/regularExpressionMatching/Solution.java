package com.algorithm.regularExpressionMatching;

public class Solution {

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {

            return s.length() == 0;

        } else if (p.length() == 1) {

            if (s.length() != 1) {
                return false;
            } else {
                if (s.charAt(0) == '.') {
                    return true;
                } else {
                    return s.charAt(0) == p.charAt(0);
                }
            }

        } else {
            if (s.length() == 0 && p.length() == 2) {
                return p.charAt(1) == '*';
            }

            int sLength = s.length();
            int pLength = p.length();

            int i = 0, j = 0;

            for (; i < sLength && j < pLength; ) {
                if (j == pLength - 1 || p.charAt(j + 1) != '*') {
                    if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                        i++;
                        j++;
                    } else {
                        return false;
                    }
                } else {
                    if (p.charAt(j) == '.' ||s.charAt(i) == p.charAt(j)) {
                        i++;
                    } else {
                        j += 2;
                    }

                }


            }

            if (i == sLength ) {
                if (pLength)

                return true;
            }

            return false;

        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
    }

}
