package org.openhis.domain.aggregate;

import com.baomidou.mybatisplus.annotation.TableName;
import org.openhis.domain.entity.DeviceDispense;
import org.openhis.domain.entity.ServiceRequest;

import java.util.ArrayList;

/**
 * 诊疗申请单（治疗申请单，手术申请单，检验申请单，输血申请单..）
 * @author zhongyi
 * @date 2025/2/20
 */
@TableName("agg_service_form")
public class ServiceTreatmentFrom extends ServiceRequest{

    private Long id;
    private String busNo;
    private String prescriptionNo;
    private ArrayList<ServiceRequest> serviceRequests ;
    //private ArrayList<DeviceDispense> serviceRequests ;
    //private ArrayList<ServiceRequest> serviceRequests ;
}
