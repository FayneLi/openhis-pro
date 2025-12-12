package org.openhis.domain.handle;

import org.axonframework.eventhandling.EventHandler;
import org.openhis.common.event.MedicationDefinitionCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class MedicationDefinitionHandle {
    public MedicationDefinitionHandle() {
        System.out.println("MedicationDefintionHandle initialized");
    }

    @EventHandler
    public void on(MedicationDefinitionCreatedEvent a) {
        System.out.println("这里是实体类监听" + a);
    }
}
