package org.openhis.domain.service;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class MedicationDefinitionManager {

    public boolean validateEdit(Long medicationId) {
        return true;
    }

    public void importTemplate(HttpServletResponse response) {
    }
}
