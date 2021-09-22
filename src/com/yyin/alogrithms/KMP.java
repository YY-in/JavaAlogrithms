package com.yyin.alogrithms;

public class KMP {
    public static void main(String[] args) {
        String str = "ABABCABAA";
        char[] pattern = str.toCharArray();
        int prefix_table =new int
    }

    /**
     * 针对模式串，查找当前模式串的最大前后缀
     * @param pattern
     * @param prefix
     * @param n
     */
    public static void prefix_table(char pattern[],int prefix[],int n){
        prefix[0]=0;
        int i =1;       //i表示模式串当前位置的指针
        int length = 0;     //最长公共前后缀的长度
        while(i<n){     //n表示pattern的长度，用于估计是否匹配成功
            if (pattern[i]==pattern[length])    //匹配前后缀是否相等，并计算最长前后缀的长度
            {
                length ++;
                prefix[i] = length;     //写入，当前位置的前缀长度
                i++;
            }else{
                if (length>0){
                    length = prefix[length-1];
                }else{
                    prefix[i]=0;    //当模式串首部处于初始状态时，或尚未匹配时候
                    i++;        //后移主串指针
                }
            }
        }
    }
}
