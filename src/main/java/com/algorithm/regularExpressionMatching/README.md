## regular expression matching

Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

* '.' Matches any single character.
* '*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

Constraints:
* 1 <= s.length<= 20
* 1 <= p.length<= 20
* s contains only lowercase English letters.
* p contains only lowercase English letters, '.', and'*'.
* It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.

1. 如果本题使用动态规划，那么用什么样个数组如何存储结果？

            使用dp[i][j]表示s的前i个字符和p的前j个字符是否匹配

2. 简单匹配情况计算dp[i][j]

           if ((p.charAt(j - 1) == '.') || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

3. 出现*如何计算dp[i][j]
            
           else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        // 匹配0个，或多次
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        // 匹配0个
                        dp[i][j] = dp[i][j - 2];
                    }
                }

           //dp[i - 1][j]; s串砍掉一个依然匹配，这里比较难想

4. 其他情况

            dp[i][j]默认为false即不匹配
            

5. 复杂匹配情况的动态规划过程

            dp[i][j] = dp[i][j-2]||dp[i-1][j-2]||dp[i-2][j-2]||dp[i-3][j-2]...||dp[i-k][j-2] （匹配0到k个，连续k个相同）
            dp[i-1][j] = dp[i-1][j-2]||dp[i-2][j-2]||dp[i-3][j-2]...||dp[i-k][j-2](匹配0到k-1个,连续k-1个相同）
            dp[i][j] = dp[i][j-2]||dp[i-1][j]
            
6. 边界情况

            s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
            