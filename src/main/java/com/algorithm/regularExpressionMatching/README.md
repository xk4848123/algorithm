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



1. 简单匹配情况

            情况一：当模式串长度为0时，匹配串长度为0时匹配成功。
            情况二：当匹配长度长度0时，如果模式串时".*"，视为匹配成功，否则匹配失败。
            情况三：当模式串长度为1时，只有匹配串长度也为1才可能匹配，当模式串为.，匹配成功，当模式串不是.时，字符相等则匹配成功。

2. 复杂匹配情况
            
            当模式串长度大于等于2时，将模式串和匹配串的指针都指向第一个字符，开始循环。

            第一个逻辑：
            如果模式串当前指针是最后一个字符或者后一个字符不是*，则判断下当前模式串字符和匹配串字符是否相等，相等则模式串的指针和匹配串的指针都往前移向一个字符，继续匹配。

            第二个逻辑：
            如果下一个字符是*，则判断下当前模式串字符和匹配串字符是否相等，不相等则模式串的指针往后移动两个字符，继续匹配，如果相等，匹配串的指针往前
            移动一个字符进行下一次判断。

3. 复杂匹配情况退出循环的条件
            
            其中一个指针大于或等于串长。

4. 复杂匹配情况的出口在哪

            第一个逻辑中出现不相等，则是出口，匹配失败。
            退出循环则视为匹配成功。
            

            