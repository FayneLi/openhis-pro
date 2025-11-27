package com.whale.common.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whale.common.core.page.PageDomain;
import com.whale.common.core.page.TableSupport;
import com.whale.common.utils.sql.SqlUtil;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 分页工具类 (基于MyBatis-Plus)
 *
 * @author system
 */
public class PageUtils {
    private static final ThreadLocal<Page<?>> PAGE_HOLDER = new ThreadLocal<>();
    private static final ThreadLocal<String> ORDER_BY_HOLDER = new ThreadLocal<>();

    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());

        Page<?> page = new Page<>(pageNum, pageSize);
        PAGE_HOLDER.set(page);

        // 保存排序信息
        if (orderBy != null && !orderBy.isEmpty()) {
            ORDER_BY_HOLDER.set(orderBy);
        }
    }

    /**
     * 获取分页对象
     */
    @SuppressWarnings("unchecked")
    public static <T> Page<T> getPage() {
        return (Page<T>) PAGE_HOLDER.get();
    }

    /**
     * 设置排序字段
     */
    public static void orderBy(String orderBy) {
        ORDER_BY_HOLDER.set(SqlUtil.escapeOrderBySql(orderBy));
    }

    /**
     * 获取排序字段
     */
    public static String getOrderBy() {
        return ORDER_BY_HOLDER.get();
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage() {
        PAGE_HOLDER.remove();
        ORDER_BY_HOLDER.remove();
    }

    /**
     * 执行分页查询并转换为目标类型
     *
     * @param mapper MyBatis Plus Mapper 接口
     * @param queryWrapper 查询条件
     * @param pageNo 当前页
     * @param pageSize 每页大小
     * @param targetClass 目标类（如 MedicationDto.class）
     * @param <T> 源对象类型（数据库实体类）
     * @param <R> 目标对象类型（DTO 类）
     * @return 分页结果（目标类型）
     */
    public static <T, R> Page<R> selectPage(BaseMapper<T> mapper, QueryWrapper<T> queryWrapper, int pageNo,
                                            int pageSize, Class<R> targetClass) {
        // 构建分页对象
        Page<T> page = new Page<>(pageNo, pageSize);
        // 执行分页查询
        Page<T> sourcePage = mapper.selectPage(page, queryWrapper);
        // 转换为目标类型的分页对象
        Page<R> targetPage = new Page<>();
        // 复制分页信息
        BeanUtils.copyProperties(sourcePage, targetPage);
        // 转换记录列表
        targetPage.setRecords(convertToDtoList(sourcePage.getRecords(), targetClass));
        return targetPage;
    }

    /**
     * 将源对象列表转换为目标对象列表
     *
     * @param sourceList 源对象列表
     * @param targetClass 目标类
     * @param <T> 源对象类型
     * @param <R> 目标对象类型
     * @return 目标对象列表
     */
    private static <T, R> List<R> convertToDtoList(List<T> sourceList, Class<R> targetClass) {
        return sourceList.stream().map(source -> convertToDto(source, targetClass)).collect(Collectors.toList());
    }

    /**
     * 将源对象转换为目标对象
     *
     * @param source 源对象
     * @param targetClass 目标类
     * @param <T> 源对象类型
     * @param <R> 目标对象类型
     * @return 目标对象
     */
    private static <T, R> R convertToDto(T source, Class<R> targetClass) {
        try {
            // 创建目标对象实例
            R target = targetClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, target); // 复制属性
            return target;
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert object to DTO", e);
        }
    }
}
