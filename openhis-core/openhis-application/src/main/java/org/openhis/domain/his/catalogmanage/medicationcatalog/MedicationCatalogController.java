package org.openhis.domain.his.catalogmanage.medicationcatalog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whale.common.annotation.Anonymous;
import com.whale.common.core.domain.R;
import com.whale.common.utils.QueryUtils;
import com.whale.common.utils.bean.BeanUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.openhis.domain.entity.MedicationDefinition;
import org.openhis.domain.his.catalogmanage.medicationcatalog.dto.MedicationCatalogCreateCommond;
import org.openhis.domain.his.catalogmanage.medicationcatalog.dto.MedicationCatalogExportQuery;
import org.openhis.domain.his.catalogmanage.medicationcatalog.dto.MedicationCatalogQuery;
import org.openhis.domain.his.catalogmanage.medicationcatalog.dto.MedicationDto;
import org.openhis.domain.repository.IMedicationDefinitionRepository;
import org.openhis.domain.service.MedicationDefinitionManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 药品目录
 *
 * @author SunJQ
 * @date 2025-04-09
 */
@RestController
@RequestMapping("/catalog-manager/medication-catalog")
@Slf4j
@AllArgsConstructor
public class MedicationCatalogController {

    private final MedicationDefinitionManager medicationManager;
    private final IMedicationDefinitionRepository medicationRepository;

    /**
     * 分页查询药品目录列表
     */
    @Anonymous
    @GetMapping("/page")
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
    @GetMapping("/{id}")
    public R<?> getById(@PathVariable Long id) {
         MedicationDefinition medication = medicationRepository.selectById(id);
        BeanUtils.copyProperties(medication, dto);
        return ;
    }

    /**
     * 新增药品目录
     */
    @PostMapping
    public R<?> add(@RequestBody MedicationCatalogCreateCommond commond) {
        return medicationManager.Create(catalogUpDto);
    }

    /**
     * 修改药品目录
     *
     * @param id 药品ID
     * @param catalogUpDto 药品目录信息
     */
    @PostMapping("/{id}")
    public R<?> update(@PathVariable Long id, @RequestBody MedicationCatalogUpdateCommond catalogUpDto) {
        return medicationManager.update(id, catalogUpDto);
    }

    /**
     * 批量停用药品目录
     *
     * @param ids 药品ID列表
     */
    @PostMapping("/status/stop")
    public R<?> stopBatch(@RequestBody List<Long> ids) {
        return medicationManager.stopBatch(ids);
    }

    /**
     * 批量启用药品目录
     *
     * @param ids 药品ID列表
     */
    @PostMapping("/status/start")
    public R<?> startBatch(@RequestBody List<Long> ids) {
        return medicationManager.startBatch(ids);
    }

    /**
     * 导出药品目录
     */
    @GetMapping("/export")
    public R<?> export(@RequestBody MedicationCatalogExportQuery query ) {
        return medicationManager.export(
                query.searchKey,
                query.ybMatchFlag,
                query.tatusEnum,
                query.categoryCode,
                query.response);
    }

    /**
     * 导入药品目录
     *
     * @param file 导入文件
     */
    @PostMapping("/template")
    public R<?> importData(@RequestParam("file") MultipartFile file) {
        boolean result= medicationManager.importData(file);
        return R.ok(result)
    ;
    }

    /**
     * 获取导入模板
     *
     * @param response 响应对象
     */
    @GetMapping("/template")
    public void importTemplate(HttpServletResponse response) {

        medicationManager.importTemplate(response);
    }

    /**
     * 校验药品是否可编辑
     *
     * @param medicationId 药品ID
     */
    @GetMapping("/validate-edit")
    public R<?> validateEdit(@RequestParam Long medicationId) {
        boolean retsult = medicationManager.validateEdit(medicationId);
        return R.ok(retsult);
    }
}