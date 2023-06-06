package com.algorithm.longestCommonPrefix;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefixBuilder = new StringBuilder();

        for (int i = 0; ; i++) {
            char curC = 0;
            boolean newCompare = true;
            for (String str : strs) {
                if (i == str.length()) {
                    return commonPrefixBuilder.toString();
                }
                if (newCompare) {
                    curC = str.charAt(i);
                    newCompare = false;
                } else {
                    if (curC != str.charAt(i)) {
                        return commonPrefixBuilder.toString();
                    }

                }

            }
            commonPrefixBuilder.append(curC);
        }


    }

}
