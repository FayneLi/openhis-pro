package org.openhis.domain.aggregate;

import org.openhis.domain.entity.ChargeItem;

import java.util.ArrayList;

public class BillForm {

    private Long id;
    //病历号、住院号
    private Long encounterId;
    private String busNo;
    private Long patientId;
    private String patientName;
    private ArrayList<ChargeItem> billItems;
}
