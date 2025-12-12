package org.openhis.domain.his.catalogmanage.medicationcatalog.converter;

import org.openhis.common.enums.*;
import com.whale.common.utils.EnumUtils;
import org.openhis.domain.entity.MedicationDefinition;
import org.openhis.domain.his.catalogmanage.medicationcatalog.dto.MedicationDetailDto;

/**
 * 将领域对象转换为DTO
 * @return DTO对象
 */

public class MedicationCatalogConverter {
    public static MedicationDetailDto convertToDto(MedicationDefinition domain) {
        if (domain == null) {
            return null;
        }
        MedicationDetailDto dto = new MedicationDetailDto();
        // 药品状态
        dto.setStatusEnum_enumText(EnumUtils.getInfoByValue(PublicationStatus.class, dto.getStatusEnum()));
        // 权限限制
        dto.setRestrictedEnum_enumText(EnumUtils.getInfoByValue(PermissionLimit.class, dto.getRestrictedEnum()));
        // 是否为活性
        dto.setActiveFlag_enumText(EnumUtils.getInfoByValue(Whether.class, dto.getActiveFlag()));
        // 医保是否对码
        dto.setYbMatchFlag_enumText(EnumUtils.getInfoByValue(Whether.class, dto.getYbMatchFlag()));
        // 是否皮试
        dto.setSkinTestFlag_enumText(EnumUtils.getInfoByValue(Whether.class, dto.getSkinTestFlag()));;
        // 是否为注射药物
        dto.setInjectFlag_enumText(EnumUtils.getInfoByValue(Whether.class, dto.getInjectFlag()));
        // 是否限制使用
        dto.setRestrictedFlag_enumText(EnumUtils.getInfoByValue(Whether.class, dto.getRestrictedFlag()));
        // 儿童用药标志
        dto.setChildrenFlag_enumText(EnumUtils.getInfoByValue(Whether.class, dto.getChildrenFlag()));
        // 适用范围
        dto.setDomainEnum_enumText(EnumUtils.getInfoByValue(ApplicableScope.class, dto.getDomainEnum()));
        // 是否自制
        dto.setSelfFlag_enumText(EnumUtils.getInfoByValue(Whether.class, dto.getSelfFlag()));
        // 是否抗生素
        dto.setAntibioticFlag_enumText(EnumUtils.getInfoByValue(Whether.class, dto.getAntibioticFlag()));
        // 基药标识
        dto.setBasicFlag_enumText(EnumUtils.getInfoByValue(Whether.class, dto.getBasicFlag()));
        // 拆分分属性
        dto.setPartAttributeEnum_enumText(
                EnumUtils.getInfoByValue(SplitPropertyCode.class, dto.getPartAttributeEnum()));
        // 住院临时医嘱拆分属性
        dto.setThoPartAttributeEnum_enumText(
                EnumUtils.getInfoByValue(TempOrderSplitPropertyCode.class, dto.getThoPartAttributeEnum()));
        return dto;
    }
}
