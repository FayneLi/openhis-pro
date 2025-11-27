package com.whale.common.constant;

import java.math.BigDecimal;

/**
 * 常量
 * 
 * @author system
 */
public class CommonConstants {

    /**
     * 共同常量
     */
    public interface Common {
        /**
         * 租户ID字段名称
         */
        String TENANT_ID = "tenant_id";

        /**
         * 开始时间（用于分页条件查询）
         */
        String S_TIME = "STime";

        /**
         * 结束时间（用于分页条件查询）
         */
        String E_TIME = "ETime";

        /**
         * 逗号（用于拼接）
         */
        String COMMA_FORMAT = "%s,%s";

        /**
         * 拼接符（三项）
         */
        String MONTAGE_FORMAT = "%s%s%s";

        /**
         * 拼接符(s-s-d-d)
         */
        String SS_DD_FORMAT = "%s-%s-%d-%d";

        /**
         * 逗号
         */
        String COMMA = ",";

        /**
         * 点
         */
        String POINT = ".";

        /**
         * 3（用于字符串截位）
         */
        Integer THREE = 3;

        /**
         * 中杠
         */
        String DASH = "-";

        /**
         * 耗材万能追溯码
         */
        String DEV_TRACE_NO = "22000000000000000000";

        /**
         * 地区码
         */
        String AREA_CODE = "000000";

        /**
         * GET
         */
        String REQUEST_MAPPING_METHOD_GET = "GET";

        /**
         * POST
         */
        String REQUEST_MAPPING_METHOD_POST = "POST";
    }

    /**
     * 表名常量
     */
    public interface TableName {

        /**
         * 服务管理(号源)
         */
        String ADM_HEALTHCARE_SERVICE = "adm_healthcare_service";

        /**
         * 药品定义
         */
        String MED_MEDICATION_DEFINITION = "med_medication_definition";

        /**
         * 药品信息
         */
        String MED_MEDICATION = "med_medication";

        /**
         * 器材定义
         */
        String ADM_DEVICE_DEFINITION = "adm_device_definition";

        /**
         * 器材信息
         */
        String ADM_DEVICE = "adm_device";

        /**
         * 活动定义
         */
        String WOR_ACTIVITY_DEFINITION = "wor_activity_definition";

        /**
         * 发放请求
         */
        String WOR_SUPPLY_REQUEST = "wor_supply_request";

        /**
         * 药品请求
         */
        String MED_MEDICATION_REQUEST = "med_medication_request";
        /**
         * 药品发放
         */
        String MED_MEDICATION_DISPENSE = "med_medication_dispense";

        /**
         * 服务(项目)请求
         */
        String WOR_SERVICE_REQUEST = "wor_service_request";

        /**
         * 耗材请求
         */
        String WOR_DEVICE_REQUEST = "wor_device_request";

        /**
         * 耗材发放
         */
        String WOR_DEVICE_DISPENSE = "wor_device_dispense";
    }

    /**
     * 字段名常量
     */
    public interface FieldName {

        /**
         * 单据号
         */
        String SupplyBusNo = "supply_bus_no";

        /**
         * 患者院内编码
         */
        String PatientBusNo = "patient_bus_no";

        /**
         * 患者ID
         */
        String PatientId = "patient_id";

        /**
         * 就诊号
         */
        String EncounterBusNo = "encounter_bus_no";
        /**
         * 身份证号
         */
        String IdCard = "id_card";

        /**
         * 拼音码
         */
        String PatientPyStr = "patient_py_str";

        /**
         * 五笔码
         */
        String PatientWbStr = "patient_wb_str";

        /**
         * 患者姓名
         */
        String PatientName = "patient_name";

        /**
         * 耗材拼音码
         */
        String DevicePyStr = "device_py_str";

        /**
         * 五笔码
         */
        String DeviceWbStr = "device_wb_str";

        /**
         * 耗材名称
         */
        String DeviceName = "device_name";

        /**
         * 诊疗拼音码
         */
        String ActivityPyStr = "activity_py_str";

        /**
         * 诊疗五笔码
         */
        String ActivityWbStr = "activity_wb_str";

        /**
         * 诊疗名称
         */
        String ActivityName = "activity_name";

        /**
         * 请求状态
         */
        String RequestStatus = "request_status";

        /**
         * 创建时间
         */
        String CreateTime = "create_time";

        /**
         * 请求基于什么的ID
         */
        String BasedOnId = "based_on_id";

        /**
         * 请求基于什么的ID
         */
        String BasedOnTable = "based_on_table";

        /**
         * 药品id
         */
        String MedicationId = "medication_id";

        /**
         * 就诊Id
         */
        String EncounterId = "encounter_id";

        /**
         * 合同编码
         */
        String ContractNo = "contract_no";

        /**
         * 支付流水
         */
        String PaymentNo = "payment_no";
        /**
         * 拼音码
         */
        String PyStr = "py_str";

        /**
         * 五笔码
         */
        String WbStr = "wb_str";

        /**
         * 名字
         */
        String Name = "name";

        /**
         * 编码
         */
        String BusNo = "bus_no";

        /**
         * 处方号
         */
        String PrescriptionNo = "prescription_no";

        /**
         * 项目分类
         */
        String MedCategoryCode = "med_category_code";

        /**
         * 耗材分类
         */
        String DevCategoryCode = "dev_category_code";

        /**
         * 门诊号
         */
        String IptOtpNo = "ipt_otp_no";

        /**
         * 医保号
         */
        String YbCode = "yb_code";

        /**
         * 项目名
         */
        String ClinicalName = "clinical_name";
        /**
         * 项目编码
         */
        String ClinicalNo = "clinical_no";

        /**
         * 类型
         */
        String TypeEnum = "type_enum";

        /**
         * 删除标志
         */
        String DeleteFlag = "delete_flag";

        /**
         * 费用项id
         */
        String ChargeId = "charge_id";

        /**
         * 费用项时间
         */
        String ChargeTime = "charge_time";

        /**
         * 审批时间
         */
        String ApplicantName = "applicant_name";

        /**
         * 病床
         */
        String InpatientBed = "inpatient_bed";

        /**
         * 预计发药时间
         */
        String PlannedDispenseTime = "planned_dispense_time";

        /**
         * 项目id
         */
        String ItemId = "item_id";

        /**
         * 项目所在表
         */
        String ItemTable = "item_table";

        /**
         * 项目名
         */
        String ItemName = "item_name";

        /**
         * 申请时间
         */
        String ApplyTime = "apply_time";

        /**
         * 校对人Id
         */
        String PerformerCheckId = "performer_check_id";

        /**
         * 单位
         */
        String UnitCode = "unit_code";

        /**
         * 用法
         */
        String MethodCode = "method_code";

        /**
         * 用药频次
         */
        String RateCode = "rate_code";

        /**
         * 住院开始时间
         */
        String StartTime = "start_time";

        /**
         * 数量
         */
        String Quantity = "quantity";

        /**
         * 所在位置
         */
        String LocationId = "location_id";

        /**
         * 供应商
         */
        String SupplierId = "supplier_id";

        /**
         * 过期天数
         */
        String RemainingDays = "remaining_days";

        /**
         * 过期天数
         */
        String paymentNo = "payment_no";
    }

    /**
     * 业务常量
     */
    public interface BusinessName {

        /**
         * 西医诊断
         */
        String WESTERN_MEDICINE_DIAGNOSIS = "西医诊断";

        /**
         * 中医诊断
         */
        String TCM_DIAGNOSIS = "中医诊断";

        /**
         * 中医证候
         */
        String TCM_SYNDROME_CATALOG = "中医证候";

        /**
         * 耗材类型：单次消耗类
         */
        String SINGLE_CONSUMPTION = "7";

        /**
         * 默认合同编码
         */
        String DEFAULT_CONTRACT_NO = "0000";

        /**
         * 默认合同编码
         */
        String DEFAULT_STUDENT_CONTRACT_NO = "STUDENT0000";

        /**
         * 默认合同编码
         */
        String CONTRACT_STUDENT = "STUDENT";

        /**
         * 皮试检查
         */
        String SKIN_TEST_INSPECTION = "皮试检查";

        /**
         * 静脉输液
         */
        String INTRAVENOUS_INFUSION = "静脉输液";

        /**
         * 代煎中药
         */
        String SUFFERING_TCM = "代煎中药";

        /**
         * 转科
         */
        String TRANSFER_ORGANIZATION = "转科";

        /**
         * 出院
         */
        String LEAVE_HOSPITAL = "出院";

    }

    /**
     * 字典名常量
     */
    public interface DictName {
        /**
         * 药品分类
         */
        String MED_CATEGORY_CODE = "med_category_code";
        /**
         * 器材分类
         */
        String DEVICE_CATEGORY_CODE = "device_category_code";
        /**
         * 诊疗分类
         */
        String DIAGNOSIS_CATEGORY_CODE = "activity_category_code";

    }

    /**
     * sql条件常量
     */
    public interface SqlCondition {
        /**
         * 关于库存的表名str
         */
        String ABOUT_INVENTORY_TABLE_STR = "'med_medication_definition', 'adm_device_definition'";
    }

    /**
     * 租户option的key键信息
     */
    public interface Option {

        String APP_ID = "app_id";

        String HOSPITAL_NAME = "hospital_name";

        String HOSPITAL_CODE = "hospital_code";

        String KEY = "key";

        String URL = "url";

        String YB_SWITCH = "yb_switch"; // 医保开关

        String CLI_PRV_KEY = "cliPrvKey";
        String CLI_PUB_KEY = "cliPubKey";
        String SERVER_PUB_KEY = "serverPubKey";
        String FIXMEDINS_NAME = "fixmedinsName";
        String FIXMEDINS_CODE = "fixmedinsCode";
        String ADMVS = "admvs";
        String SCOPE = "scope";
        String GRANT_TYPE = "grantType";
        String PASSWORD = "password";
        String USERNAME = "username";
        String CLIENT_SECRET = "clientSecret";
        String CLIENT_ID = "clientId";
        String PROD_CLI_PUB_KEY = "prod_cliPubKey";
        String PROD_CLI_PRV_KEY = "prod_cliPrvKey";
        String PROD_CLIENT_ID = "prod_clientId";
        String FILE_PATH = "filePath";
        String ELE_ADDRESS = "eleAddress";
        String ADDRESS = "address";
        String TIME = "time";
        String IS_ENCRYPT = "isEncrypt";
        String INSUPLC_ADMDVS = "insuplc_admdvs"; // 参保地区编码
        String PRE_APP_ID = "pre_app_id";
        String PRE_APP_SECRET = "pre_app_secret";
        String APP_PRVKEY = "APP_PRVKEY";
        String PLAF_PUBKEY = "PLAF_PUBKEY";
        String TEMPLATE_PATH = "templatePath";
        String OUTPUT_PATH = "outputPath";
        String HOSPITAL_SEAL_PATH = "hospitalSealPath";
    }

    /**
     * 长大个性化常量
     */
    public interface CCU {

        // 耗材发放人
        Long DisDeviceDoctor = 1934507489239801857L;

        // 耗材发放人姓名
        String DisDeviceDoctorName = "张桂英";
    }

    /**
     * excel导出常量
     */
    public interface ExcelOut {
        // "0"的
        String CONSTANTZERO = "0";
        // 0.00
        String CONSTANT_ZERO_DML = "0.00";
        // 药品
        String MEDICATION = "药品";
        // 耗材
        String DEVICE = "耗材";
        // 未知类型
        String UNKONWN_TYPE = "未知类型";
        // 否
        String NO = "否";
        // 是
        String YES = "是";
        // BigDecimal类型的0
        BigDecimal ZERO = new BigDecimal(0);
        // 元
        String YUAN = "元";

    }

    /**
     * excel导出的sheet名称
     */
    public interface SheetName {
        /**
         * 发药明细
         */
        String SHEET_NAME_DRUG_DETAIL = "发药明细";
        /**
         * 住院发药单
         */
        String INPATIENT_DISPENSING = "住院发药单";
        /**
         * 库存明细记录
         */
        String INVENTORY_DETAIL_RECORD = "库存明细记录";
        /**
         * 住院汇总单
         */
        String INPATIENT_AGGREGATE_ORDER = "住院汇总单";
        /**
         * 调拨单据明细
         */
        String TRANSFER_DOCUMENT_DETAIL = "调拨单据明细";
        /**
         * 入库单明细
         */
        String WAREHOUSE_ENTRY_DETAIL = "入库单明细";
        /**
         * 盘点单明细
         */
        String INVENTORY_LIST_DETAIL = "盘点单明细";
        /**
         * 采购退货明细
         */
        String PURCHASE_RETURN_DETAIL = "采购退货明细";
        /**
         * 报损单据明细
         */
        String LOSS_REPORT_DETAIL = "报损单据明细";
        /**
         * 领用单据明细
         */
        String REQUISITION_FORM_DETAIL = "领用单据明细";
        /**
         * 退库单据明细
         */
        String RETURN_WAREHOUSE_DETAIL = "退库单据明细";

    }

    /**
     * 导出时需要隐藏的列
     */
    public interface CellName {
        /**
         * 源仓库
         */
        String SOURCE_LOCATION_NAME = "sourceLocationName";
        /**
         * 目的仓库
         */
        String PURPOSE_LOCATION_NAME = "purposeLocationName";

    }

    /**
     * 工具方法常量
     */
    public interface UtilMethodConstant {
        /**
         * 是否四舍五入(与余数作比较)的临界值
         * 例：0.86 -> 0.85
         *    0.88 -> 0.90
         */
        Double THRESHOLD_VALUE = 0.02;
    }

}
