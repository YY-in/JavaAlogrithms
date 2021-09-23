package com.yyin.alogrithms;

public class KMP {
    public static void main(String[] args) {
        String pattern_str = "ABABCABAA";
        String text_str = "ABABABCABAABABABAB";
        char[] pattern = pattern_str.toCharArray();
        char[] text = text_str.toCharArray();
        /*int[] prefix_table = new int[9]; int n = 9; prefix_table(pattern, prefix_table, n); move_prefix_table(prefix_table, n); for (int i : prefix_table) { System.out.print(i); }*/
        kmp_search(text, pattern);
        }

    /**
     * 针对模式串，查找当前模式串的最大前后缀
     * 构建前缀表，
     *
     * @param pattern
     * @param prefix
     * @param n
     */
    public static void prefix_table(char pattern[], int prefix[], int n) {
        prefix[0] = 0;
        int i = 1;       //i表示模式串当前位置的指针
        int length = 0;     //最长公共前后缀的长度
        while (i < n) {     //n表示pattern的长度，用于估计是否匹配成功
            if (pattern[i] == pattern[length])    //匹配前后缀是否相等，并计算最长前后缀的长度
            {
                length++;
                prefix[i] = length;     //写入，当前位置对应的前缀长度
                i++;
            } else {
                if (length > 0) {
                    length = prefix[length - 1];
                } else {
                    prefix[i] = 0;    //当模式串首部处于初始状态时，或尚未匹配时候
                    i++;        //后移主串指针
                }
            }
        }
    }
    //为方便后面的匹配，对前缀表进行位移
    static void move_prefix_table(int[] prefix, int n) {
        for (int i = n - 1; i > 0; i--) {
            prefix[i]=prefix[i-1];
        }
        prefix[0]=-1;
    }

    static  void kmp_search (char[] text,char[] pattern){
        int n = pattern.length;
        int m = text.length;
        int[] prefix = new int[n];
        prefix_table(pattern, prefix, n);
        move_prefix_table(prefix, n);
        int i = 0;
        int j = 0;

        // text[i], len(text) = m
        // pattern[j], len(pattern) = n
        while (i < m) {

            if(j == n-1 && text[i] == pattern[j]){
                System.out.println("Found pattern at " + (i-j));
                j = prefix[j];
            }

            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = prefix[j];
                if (j == -1) {
                    j++;
                    i++;
                }
            }
        }
    }

}
