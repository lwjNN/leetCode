package com.leetcode.everyday;

import java.util.Arrays;
import java.util.List;

/**
 *
 * 理解错题了
 * @author LWJ
 * @date 2020/6/25 10:02
 */
public class Solution_139 {
    public  boolean wordBreak(String s, List<String> wordDict) {
        String tmp = s;
        for (String str:wordDict) {
            if(tmp.indexOf(str)>-1){
                tmp = getNewString(tmp, str);
            }else{
                return false;
            }
        }
        return true;
    }

    public  String getNewString(String src, String tag) {
        int index = src.indexOf(tag);
        String res = "";
        if (index > -1) {
            //原字符串包含目标字符串，返回去除掉目标字符串之后的新字符串
            //leetcode   leet
             res = src.substring(0, index) + src.substring(index + tag.length());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"cats", "dog", "an"};
        List<String> list = Arrays.asList(str);
//        System.out.println(wordBreak("catsandog", list));
    }
}
