package org.openhis.domain.his.catalogmanage.medicationcatalog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whale.common.annotation.Anonymous;
import com.whale.common.constant.CommonConstants;
import com.whale.common.core.domain.R;
import com.whale.common.utils.DateUtils;
import com.whale.common.utils.QueryUtils;
import com.whale.common.utils.SecurityUtils;
import com.whale.common.utils.bean.BeanUtils;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.openhis.common.enums.PublicationStatus;
import org.openhis.common.enums.Whether;
import org.openhis.domain.entity.*;
import org.openhis.domain.his.catalogmanage.medicationcatalog.dto.*;
import org.openhis.domain.repository.IMedicationDefinitionRepository;
import org.openhis.domain.service.ChargeItemDefintionManager;
import org.openhis.domain.service.MedicationDefinitionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 订单管理控制器
 * <p>
 * 提供订单的创建、查询、修改和删除等功能。
 * 支持按条件查询订单和导出订单数据。
 * </p>
 *
 * @author lcz
 * @version 1.0.0
 * @since 1.0.0
 */
@Tag(name = "药品目录管理", description = "药品目录相关操作接口")
@RestController
@RequestMapping("/api/medication-catalog")
@Slf4j
@AllArgsConstructor
public class MedicationCatalogController {

    @Autowired
    private final MedicationDefinitionManager medicationManager;
    private final ChargeItemDefintionManager chargeItemDefintionManager;
    private final IMedicationDefinitionRepository medicationRepository;

    /**
     * 分页查询药品目录列表
     */
    @Hidden
    @Anonymous
    @PostMapping(value="/page")
    public R<?> getPage(@RequestBody MedicationCatalogQuery query) {

        // 构建查询条件
        QueryWrapper<MedicationDefinition> queryWrapper = QueryUtils.buildQueryWrapper(query,
                query.searchKey, new HashSet<>(Arrays.asList("name", "name_en", "merchandise_name", "bus_no", "py_str", "wb_str",
                        "merchandise_py_str", "merchandise_wb_str")),
                null);

        Page<MedicationDefinition> page =
                medicationRepository.selectPage(new Page<>(query.pageNo, query.pageSize), queryWrapper);
        return R.ok(page);
    }

    /**
     * 根据ID查询药品详情
     * @param id 药品ID
     */
    @Hidden
    @Anonymous
    @GetMapping("/{id}")
    public R<?> getById(@PathVariable Long id) {
         MedicationDefinition medication = medicationRepository.selectById(id);
        throw  new RuntimeException();
    }

    /**
     * 新增药品目录   完成
     */
    @Anonymous
    @GetMapping("/add")
    @Operation(summary = "添加", description = "增加目录信息")
    @Parameter(description="药品目录Dto")
    public R<?> add(@RequestBody MedicationDetailDto medicationDetailDto) {
        //业务类对应返回的实体类
        MedicationDefinition medication = new MedicationDefinition();
        ChargeItemDefinition chargeItemDefinition = new ChargeItemDefinition();

        //药品目录
        MedicationManageUpDto upDto = new MedicationManageUpDto();
        BeanUtils.copyProperties(medicationDetailDto, upDto);
        R<MedicationDefinition> medicationDefinitionR = medicationManager.create(upDto);
        if (medicationDefinitionR.getCode() == 200) {
            medication = medicationDefinitionR.getData();
        }

        //价格
        ItemUpFromDirectoryDto itemUpFromDirectoryDto = new ItemUpFromDirectoryDto();
        BeanUtils.copyProperties(medicationDetailDto, itemUpFromDirectoryDto);
        itemUpFromDirectoryDto.setInstanceId(medication.getMedicationDefId())
                .setStatusEnum(PublicationStatus.ACTIVE.getValue())
                .setInstanceTable(CommonConstants.TableName.MED_MEDICATION_DEFINITION)
                .setEffectiveStart(DateUtils.getNowDate()).setOrgId(SecurityUtils.getLoginUser().getOrgId())
                .setConditionFlag(Whether.YES.getValue()).setChargeName(medication.getName())
                .setPrice(upDto.getRetailPrice());
        R<ChargeItemDefinition> chargeItemDefinitionR = chargeItemDefintionManager.addItem(itemUpFromDirectoryDto);
        if (chargeItemDefinitionR.getCode() == 200) {
            chargeItemDefinition = chargeItemDefinitionR.getData();
        }


        //价格明细
        itemUpFromDirectoryDto.setDefinitionId(chargeItemDefinition.getId());
        R<List<ChargeItemDefDetail>> listR = chargeItemDefintionManager.addItemDetail(itemUpFromDirectoryDto);
        if (listR.getCode() == 200) {

        }


        return R.ok();

    }

    /**
     * 修改药品目录
     *
     * @param id 药品ID
     * @param catalogUpDto 药品目录信息
     */
    @Hidden
    @PostMapping("/{id}")
    public R<?> update(@PathVariable Long id, @RequestBody MedicationCatalogUpdateCommond catalogUpDto) {
        throw  new RuntimeException();

       // return medicationManager.update(id, catalogUpDto);
    }

    /**
     * 批量停用药品目录
     *
     * @param ids 药品ID列表
     */
    @Hidden
    @PostMapping("/status/stop")
    public R<?> stopBatch(@RequestBody List<Long> ids) {
        throw  new RuntimeException();

//        return medicationManager.stopBatch(ids);
    }

    /**
     * 批量启用药品目录
     *
     * @param ids 药品ID列表
     */
    @Hidden
    @PostMapping("/status/start")
    public R<?> startBatch(@RequestBody List<Long> ids) {
        throw  new RuntimeException();

//        return medicationManager.startBatch(ids);
    }

    /**
     * 导出药品目录
     */
    @Hidden
    @GetMapping("/export")
    public R<?> export(@RequestBody MedicationCatalogExportQuery query ) {
        throw  new RuntimeException();
//
//        return medicationManager.export(
//                query.searchKey,
//                query.ybMatchFlag,
//                query.tatusEnum,
//                query.categoryCode,
//                query.response);
    }

    /**
     * 导入药品目录
     *
     * @param file 导入文件
     */
    @Hidden
    @PostMapping("/template")
    public R<?> importData(@RequestParam("file") MultipartFile file) {
        throw  new RuntimeException();

//        boolean result= medicationManager.importData(file);
//        return R.ok(result);
    }

    /**
     * 获取导入模板
     *
     * @param response 响应对象
     */
    @Hidden
    @GetMapping("/template")
    public void importTemplate(HttpServletResponse response) {

        medicationManager.importTemplate(response);
    }

    /**
     * 校验药品是否可编辑
     *
     * @param medicationId 药品ID
     */
    @Hidden
    @GetMapping("/validate-edit")
    public R<?> validateEdit(@RequestParam Long medicationId) {
        boolean retsult = medicationManager.validateEdit(medicationId);
        return R.ok(retsult);
    }
}