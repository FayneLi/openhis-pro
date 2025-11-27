package org.openhis.domain.service;

import jakarta.servlet.http.HttpServletResponse;
import org.openhis.domain.entity.ActivityDefinition;
import org.springframework.stereotype.Service;

@Service
public class ActivityDefinitionManager {
    public boolean validateEdit(Long Id) {
        return  true;
    }

    public void importTemplate(HttpServletResponse response) {
    }

    public ActivityDefinition CreateDefinition() {
        return  new ActivityDefinition();
    }


    public ActivityDefinition UpdateDefinition(Long id, ActivityDefinition catalogUpdateDto) {
        return  new ActivityDefinition();
    }

    public void export() {
    }
}
