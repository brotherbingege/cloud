package com.yb.test;

import java.time.ZonedDateTime;

/**
 * 〈功能概述〉<br>
 *
 * @author: yb
 * @date: 2020/6/28 0028 21:32
 */
public class TimeGet {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
