package com.leetcode;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

@SpringBootTest
class LeetcodeApplicationTests {

    public static void main(String[] args) {
        Date date = DateUtils.addDays(new Date(), -3);
        System.out.println(date);
    }

}
