package com.whale.common.utils;

import java.io.IOException;
import java.util.List;
import com.whale.common.core.domain.R;
import com.whale.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;


/**
 * 通用工具类
 * 适配 Spring Boot 3，基于 Apache HttpClient 5 实现 SSL 配置
 *
 * @author system
 */
public class CommonUtil {

    /**
     * 尝试将字符串转换为 Integer
     * 转换失败时返回 null，避免抛出异常
     *
     * @param intStr 待转换的整数字符串
     * @return 转换后的 Integer，失败则返回 null
     */
    public static Integer tryParseInt(String intStr) {
        try {
            return Integer.parseInt(intStr);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 读取导入的 Excel 文件并转换为指定类型的实体列表
     *
     * @param file  上传的 Excel 文件
     * @param clazz 目标实体类的 Class 对象
     * @param <T>   实体类泛型
     * @return 封装结果的 R 对象（成功返回列表，失败返回错误信息）
     */
    public static <T> R<List<T>> readImportedExcelFile(MultipartFile file, Class<T> clazz) {
        ExcelUtil<T> util = new ExcelUtil<>(clazz);
        List<T> importDtoList;
        try {
            importDtoList = util.importExcel(file.getInputStream());
        } catch (IOException e) {
            return R.fail("导入失败！文件读取异常：" + e.getMessage());
        }
        if (importDtoList.isEmpty()) {
            return R.fail("导入失败！文件不能为空或无有效数据");
        }
        return R.ok(importDtoList);
    }
}

