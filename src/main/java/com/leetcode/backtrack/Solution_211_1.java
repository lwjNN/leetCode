package com.leetcode.backtrack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author lwj
 * @date 2020/10/30 17:28
 */
public class Solution_211_1 {

    Map<Integer, HashSet<String>> map;

    public Solution_211_1() {
        map = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        HashSet<String> set = map.get(word.length());
        if(set == null){
            set = new HashSet<>();
        }
        set.add(word);
        map.put(word.length(), set);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int len = word.length();
        HashSet<String> set = map.get(len);
        if(set == null){
            return false;
        }
        boolean res = false;
        for (String str : set) {
            res = res || helper(word, str);
            if(res){
                return res;
            }
        }
        return res;
    }

    private boolean helper(String tar, String src){
        for (int i = 0; i < src.length(); i++) {
            if(tar.charAt(i)== '.'){
                continue;
            }else if(src.charAt(i) != tar.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_211_1 solu = new Solution_211_1();
//        solu.addWord("bad");
//        solu.addWord("dad");
//        solu.addWord("mad");
        System.out.println(solu.search("pad"));
    }

}
