package com.leetcode.binarySearch;

/**
 * @author lwj
 * @date 2022/4/22 14:58
 */
public class Solution_374_1 extends GuessGame1{
    public int guessNumber(int n) {
        int mid = n / 2;
        while(true){
            int res = guess(mid);
            if (res == 0){
                return mid;
            }else if(res == -1){
                mid = mid / 2;
            }else{
                mid = (n - mid) / 2 + mid;
            }
        }
    }

    public static void main(String[] args) {
        Solution_374_1 s = new Solution_374_1();
        System.out.println(s.guessNumber(2));
    }
}


class GuessGame1{
    int res = 2;
    public int guess(int src){
        if (res == src) return  0;
        else if (src < res) return 1;
        else return -1;
    }
}
