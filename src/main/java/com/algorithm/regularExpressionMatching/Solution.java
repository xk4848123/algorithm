package com.algorithm.regularExpressionMatching;

public class Solution {

    //动态规划
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }

        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ((p.charAt(j - 1) == '.') || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        // 匹配0个，或多次
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        // 匹配0个
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
    }

}
