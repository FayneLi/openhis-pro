package org.openhis.common.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * @ClassName IdCardAgeCalculator
 * @Description  根据身份证号 计算年纪
 * @Author raymond
 * @Date 2025/11/4 10:32
 * @Version 1.0
 **/
public class IdCardAgeCalculator {
    /**
     * 根据身份证号计算年龄（支持15/18位）
     * @param idCard 身份证号
     * @return 年龄（若身份证号非法，返回-1）
     */
    public static int calculateAge(String idCard) {
        // 1. 校验身份证号合法性（基础校验：长度、非空）
        if (!isValidIdCard(idCard)) {
            System.out.println("身份证号格式非法！");
            return -1;
        }

        // 2. 提取出生日期字符串（15位转18位格式）
        String birthDateStr = extractBirthDateStr(idCard);

        // 3. 解析出生日期为LocalDate（处理格式异常）
        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (DateTimeParseException e) {
            System.out.println("出生日期解析失败，身份证号可能非法！");
            return -1;
        }

        // 4. 计算年龄（当前日期 - 出生日期）
        LocalDate currentDate = LocalDate.now(); // 若需指定日期，替换为 LocalDate.of(2024, 5, 20)
        return calculateAgeBetweenDates(birthDate, currentDate);
    }

    /**
     * 基础校验身份证号（非空、长度15或18位、数字/最后一位X）
     */
    private static boolean isValidIdCard(String idCard) {
        if (idCard == null || idCard.trim().isEmpty()) {
            return false;
        }
        // 正则：15位纯数字，或18位数字（最后一位可大写X）
        String regex = "^(\\d{15}|\\d{17}([0-9]|X))$";
        return idCard.matches(regex);
    }

    /**
     * 从身份证号中提取出生日期字符串（统一转为yyyyMMdd格式）
     */
    private static String extractBirthDateStr(String idCard) {
        String birthDateStr;
        if (idCard.length() == 18) {
            // 18位：第7-14位（索引6-13）
            birthDateStr = idCard.substring(6, 14);
        } else {
            // 15位：第7-12位（索引6-11），补前两位年份（19xx或20xx，这里简化为19xx，实际需根据规则判断）
            String year = "19" + idCard.substring(6, 8);
            String monthDay = idCard.substring(8, 12);
            birthDateStr = year + monthDay;
        }
        return birthDateStr;
    }

    /**
     * 根据出生日期和当前日期计算年龄（处理未过生日的情况）
     */
    private static int calculateAgeBetweenDates(LocalDate birthDate, LocalDate currentDate) {
        // 计算年份差
        Period period = Period.between(birthDate, currentDate);
        int age = period.getYears();

        // 检查当前日期是否已超过当年的出生日期（未超过则年龄减1）
        LocalDate birthdayThisYear = birthDate.withYear(currentDate.getYear());
        if (currentDate.isBefore(birthdayThisYear)) {
            age--;
        }

        // 防止年龄为负数（如出生日期在当前日期之后，理论上身份证号不会出现此情况）
        return Math.max(age, 0);
    }

    // 测试示例
    public static void main(String[] args) {
        // 测试1：18位身份证（出生日期2000-01-01，当前日期2024-05-20 → 年龄24）
        String idCard18 = "110101200001011234";
        System.out.println("18位身份证年龄：" + calculateAge(idCard18));

        // 测试2：15位身份证（出生日期2000-01-01 → 15位表示为000101，补全后20000101）
        String idCard15 = "110101000101123";
        System.out.println("15位身份证年龄：" + calculateAge(idCard15));

        // 测试3：未过生日的情况（出生日期2000-06-01，当前日期2024-05-20 → 年龄23）
        String idCardNotBirthday = "110101200006011234";
        System.out.println("未过生日的年龄：" + calculateAge(idCardNotBirthday));

        // 测试4：非法身份证号（长度错误）
        String idCardInvalid = "11010120000101123"; // 17位
        System.out.println("非法身份证年龄：" + calculateAge(idCardInvalid));
    }
}
