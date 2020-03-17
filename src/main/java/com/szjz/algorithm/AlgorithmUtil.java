package com.szjz.algorithm;

import java.util.Stack;

/**
 * author:szjz
 * date:2019/7/17
 * 算法工具类
 */
public class AlgorithmUtil {

    public static void main(String[] args) {

//        String str = "cabcdc";
//        int length = lengthOfLongestSubstring(str);
//        System.err.println(length);

        System.out.println(isValid("{}"));

    }


    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public static int lengthOfLongestSubstring(String s) {
        int l = 0;   //记录子串中第一次出现重复字符的最左边的位置
        int[] dp = new int[s.length() + 1]; // 记录有效的子串长度
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String substring = s.substring(l, i);
            if (substring.indexOf(c) != -1)
                l = s.indexOf(c, l) + 1;
            dp[i + 1] = Math.max(dp[i], i - l + 1);
        }
        return dp[s.length()];
    }

    public  static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character popC = stack.pop();
                if (c == ')' && popC != '(') {
                    return false;
                }
                if (c == '}' && popC != '{') {
                    return false;
                }
                if (c == ']' && popC != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
