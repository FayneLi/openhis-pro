package com.whale.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whale.admin.domain.SysTenantOption;
import com.whale.admin.mapper.SysTenantOptionMapper;
import com.whale.admin.service.ISysTenantOptionService;
import com.whale.admin.web.dto.SaveTenantOptionDetailDto;
import com.whale.admin.web.dto.TenantOptionDto;
import com.whale.common.core.domain.R;
import com.whale.common.enums.TenantOptionDict;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 租户配置项表Service业务层处理
 *
 * @author system
 */
@Service
public class SysTenantOptionServiceImpl extends ServiceImpl<SysTenantOptionMapper, SysTenantOption>
        implements ISysTenantOptionService {

    /**
     * 查询全部租户配置项
     *
     * @param tenantId 租户ID
     * @return 全部租户配置项
     */
    @Override
    public Map<String, String> getAllTenantOption(Integer tenantId) {
        // 查询该租户所有配置项
        List<SysTenantOption> sysTenantOptionList =
                baseMapper.selectList(new LambdaQueryWrapper<SysTenantOption>().eq(SysTenantOption::getTenantId, tenantId));
        if (sysTenantOptionList.isEmpty()) {
            return Collections.emptyMap();
        }
        // 作成Map
        return sysTenantOptionList.stream()
                .collect(Collectors.toMap(SysTenantOption::getOptionCode, SysTenantOption::getOptionContent));
    }

    /**
     * 查询租户配置项详情列表
     *
     * @param tenantId 租户ID
     * @return 租户配置项详情列表
     */
    @Override
    public List<TenantOptionDto> getTenantOptionDetailList(Integer tenantId) {
        // 获取全部租户配置项字典，并按照指定顺序排序
        TenantOptionDict[] optionDictArray = TenantOptionDict.values();
        List<TenantOptionDict> optionDictList = Arrays.stream(optionDictArray)
                .sorted(Comparator.comparing(TenantOptionDict::getSort)).collect(Collectors.toList());
        // 查询该租户所有配置项，并作成Map
        List<SysTenantOption> sysTenantOptionList =
                baseMapper.selectList(new LambdaQueryWrapper<SysTenantOption>().eq(SysTenantOption::getTenantId, tenantId));
        Map<String, String> sysTenantOptionMap = sysTenantOptionList.stream()
                .collect(Collectors.toMap(SysTenantOption::getOptionCode, SysTenantOption::getOptionContent));
        // 循环查询结果，返回字典项和实际配置的值
        List<TenantOptionDto> dtoList = new ArrayList<>();
        TenantOptionDto dto;
        for (TenantOptionDict dict : optionDictList) {
            dto = new TenantOptionDto();
            dto.setCode(dict.getCode()).setName(dict.getName()).setContent(sysTenantOptionMap.get(dict.getCode()));
            dtoList.add(dto);
        }
        return dtoList;
    }

    /**
     * 保存租户配置项详情列表
     *
     * @param saveTenantOptionDetailDto 参数DTO
     * @return 结果
     */
    @Override
    public R<?> saveTenantOptionDetailList(SaveTenantOptionDetailDto saveTenantOptionDetailDto) {
        // 入参配置项详情列表作成Map
        Map<String, TenantOptionDto> tenantOptionDtoMap = saveTenantOptionDetailDto.getOptionList().stream()
                .collect(Collectors.toMap(TenantOptionDto::getCode, Function.identity()));
        // 查询该租户所有配置项，并作成Map
        List<SysTenantOption> sysTenantOptionList = baseMapper.selectList(new LambdaQueryWrapper<SysTenantOption>()
                .eq(SysTenantOption::getTenantId, saveTenantOptionDetailDto.getTenantId()));
        Map<String, SysTenantOption> sysTenantOptionMap =
                sysTenantOptionList.stream().collect(Collectors.toMap(SysTenantOption::getOptionCode, Function.identity()));
        // 循环配置项字典
        List<SysTenantOption> newOptionList = new ArrayList<>();
        List<SysTenantOption> existOptionList = new ArrayList<>();
        SysTenantOption newOption;
        for (TenantOptionDict dict : TenantOptionDict.values()) {
            // 根据是否输入，是否已存在，区分并作成新增列表和更新列表
            TenantOptionDto inputOption = tenantOptionDtoMap.getOrDefault(dict.getCode(), new TenantOptionDto());
            SysTenantOption existOption = sysTenantOptionMap.get(dict.getCode());
            if (existOption == null) {
                newOption = new SysTenantOption().setTenantId(saveTenantOptionDetailDto.getTenantId())
                        .setOptionCode(dict.getCode())
                        .setOptionContent(Optional.ofNullable(inputOption.getContent()).orElse(""));
                newOptionList.add(newOption);
            } else {
                existOption.setOptionContent(Optional.ofNullable(inputOption.getContent()).orElse(""));
                existOptionList.add(existOption);
            }
        }
        // 新增
        if (!newOptionList.isEmpty()) {
            this.saveBatch(newOptionList);
        }
        // 更新
        if (!existOptionList.isEmpty()) {
            this.updateBatchById(existOptionList);
        }
        return R.ok();
    }

    /**
     * 查询租户配置项前端form表单列表
     *
     * @return 租户配置项前端form表单列表
     */
    @Override
    public List<TenantOptionDto> getTenantOptionFormList() {
        return Arrays.stream(TenantOptionDict.values()).sorted(Comparator.comparing(TenantOptionDict::getSort))
                .map(dict -> new TenantOptionDto().setCode(dict.getCode()).setName(dict.getName()))
                .collect(Collectors.toList());
    }

}
