package com.whale.common.utils;

import java.util.Date;

public class DateTimeUtils {

    /**
     * 判断时间是否重叠
     *
     * @param start1 开始时间1
     * @param end1 开始时间1
     * @param start2 开始时间2
     * @param end2 开始时间2
     * @return 是否重叠
     */
    public static boolean isOverlap(Date start1, Date end1, Date start2, Date end2) {
        // 判断是否重叠：start1 < end2 && end1 > start2
        return start1.before(end2) && end1.after(start2);
    }
}
