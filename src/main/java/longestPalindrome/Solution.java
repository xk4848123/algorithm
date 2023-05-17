package longestPalindrome;

public class Solution {

    private Boolean[][] isPalindromeTags;

    public String longestPalindrome(String s) {

        isPalindromeTags = new Boolean[s.length()][s.length()];

        int maxLength = 1;
        int maxLengthLeft = 0;
        int maxLengthRight = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int left = i;
                int right = j;

                int curLength = right - left + 1;
                if (curLength <= maxLength) {
                    continue;
                }

                if (isPalindrome(s, left, right)) {
                    maxLength = curLength;
                    maxLengthLeft = left;
                    maxLengthRight = right;
                }


            }

        }
        return s.substring(maxLengthLeft, maxLengthRight+1);
    }

    public boolean isPalindrome(String s, int left, int right) {
        if (isPalindromeTags[left][right] != null) {
            return isPalindromeTags[left][right];
        }

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        if (right - left <= 2) {
            isPalindromeTags[left][right] = true;
            return true;
        }

        return isPalindrome(s, left - 1, right - 1);
    }

    public static void main(String[] args) {
       Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

}
