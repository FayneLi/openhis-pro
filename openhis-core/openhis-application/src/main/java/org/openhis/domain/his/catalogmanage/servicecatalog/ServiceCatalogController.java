package org.openhis.domain.his.catalogmanage.servicecatalog;

import com.whale.common.annotation.Anonymous;
import com.whale.common.core.domain.R;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openhis.domain.his.catalogmanage.medicationcatalog.dto.MedicationCatalogExportQuery;
import org.openhis.domain.his.catalogmanage.medicationcatalog.dto.MedicationCatalogQuery;
import org.openhis.domain.his.catalogmanage.servicecatalog.dto.ServiceCatalogCreateCommond;
import org.openhis.domain.his.catalogmanage.servicecatalog.dto.ServiceCatalogQuery;
import org.openhis.domain.his.catalogmanage.servicecatalog.dto.ServiceCatalogUpdateCommond;
import org.openhis.domain.repository.IActivityDefinitionRepository;
import org.openhis.domain.service.ActivityDefinitionManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
public class ServiceCatalogController {

    private final ActivityDefinitionManager activityManager;
    private final IActivityDefinitionRepository activityRepository;

    /**
     * 分页查询药品目录列表
     */
    @Anonymous
    @GetMapping("/page")
    public R<?> getPage(ServiceCatalogQuery query) {
        return activityRepository.selectPage(query);
    }

    /**
     * 根据ID查询药品详情
     * @param id 药品ID
     */
    @GetMapping("/{id}")
    public R<?> getById(@PathVariable Long id) {
        return activityRepository.getById(id);
    }

    /**
     * 新增药品目录
     */
    @PostMapping
    public R<?> add(@RequestBody ServiceCatalogCreateCommond commond) {
        ActivityDefinition result = activityManager.CreateDefinition();
        return R.ok(result);
    }

    /**
     * 修改药品目录
     *
     * @param id 药品ID
     * @param catalogUpDto 药品目录信息
     */
    @PostMapping("/{id}")
    public R<?> update(@PathVariable Long id, @RequestBody ServiceCatalogUpdateCommond commond) {
        ActivityDefinition  activityDefinition = activityManager.UpdateDefinition(id, null);
        return R.ok(activityDefinition);
    }

    /**
     * 批量停用药品目录
     *
     * @param ids 药品ID列表
     */
    @PostMapping("/status/stop")
    public R<?> stopBatch(@RequestBody List<Long> ids) {
        return activityManager.stopBatch(ids);
    }

    /**
     * 批量启用药品目录
     *
     * @param ids 药品ID列表
     */
    @PostMapping("/status/start")
    public R<?> startBatch(@RequestBody List<Long> ids) {
        return activityManager.startBatch(ids);
    }

    /**
     * 导出药品目录
     */
    @GetMapping("/export")
    public R<?> export(@RequestBody MedicationCatalogExportQuery query ) {
        return activityManager.export();
    }

    /**
     * 导入药品目录
     *
     * @param file 导入文件
     */
    @PostMapping("/template")
    public R<?> importData(@RequestParam("file") MultipartFile file) {
        return activityManager.importData(file);
    }

    /**
     * 获取导入模板
     *
     * @param response 响应对象
     */
    @GetMapping("/template")
    public void importTemplate(HttpServletResponse response) {
        activityManager.importTemplate(response);
        return;
    }

    /**
     * 校验药品是否可编辑
     *
     * @param medicationId 药品ID
     */
    @GetMapping("/validate-edit")
    public R<?> validateEdit(@RequestParam Long medicationId) {
        boolean retsult = activityManager.validateEdit(medicationId);
        return R.ok(retsult);
    }
}