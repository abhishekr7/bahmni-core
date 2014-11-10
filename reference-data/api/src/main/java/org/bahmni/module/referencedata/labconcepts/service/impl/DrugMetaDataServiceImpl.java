package org.bahmni.module.referencedata.labconcepts.service.impl;

import org.bahmni.module.referencedata.labconcepts.model.DrugMetaData;
import org.bahmni.module.referencedata.labconcepts.service.DrugMetaDataService;
import org.openmrs.Concept;
import org.openmrs.ConceptClass;
import org.openmrs.Drug;
import org.openmrs.api.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugMetaDataServiceImpl implements DrugMetaDataService {

    private final ConceptService conceptService;

    @Autowired
    public DrugMetaDataServiceImpl(ConceptService conceptService) {
        this.conceptService = conceptService;
    }

    @Override
    public DrugMetaData getDrugMetaData(String drugName, String drugUuid, String genericName, String dosageForm) {
        Drug existingDrug = getExistingDrug(drugName, drugUuid);
        Concept drugConcept = conceptService.getConceptByName(genericName);
        Concept dosageFormConcept = conceptService.getConceptByName(dosageForm);
        ConceptClass drugConceptClass = conceptService.getConceptClassByUuid(ConceptClass.DRUG_UUID);
        return new DrugMetaData(existingDrug, drugConcept, dosageFormConcept, drugConceptClass);
    }

    private Drug getExistingDrug(String drugName, String drugUuid) {
        if (drugUuid != null) {
            return conceptService.getDrugByUuid(drugUuid);
        }
        return conceptService.getDrug(drugName);
    }
}
