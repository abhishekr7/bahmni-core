package org.bahmni.module.bahmnicore.service;

import org.openmrs.Concept;
import org.openmrs.Obs;
import org.openmrs.Visit;
import org.openmrs.module.bahmniemrapi.encountertransaction.contract.BahmniObservation;

import java.util.Collection;
import java.util.List;

public interface BahmniObsService {
    public List<Obs> getObsForPerson(String identifier);
    public Collection<BahmniObservation> getInitial(String patientUuid, Collection<Concept> conceptNames,Integer numberOfVisits);
    Collection<BahmniObservation> getInitialObsByVisit(Visit visit, List<Concept> rootConcepts);
    public Collection<BahmniObservation> observationsFor(String patientUuid, Collection<Concept> concepts, Integer numberOfVisits, List<String> obsIgnoreList, Boolean filterObsWithOrders);
    public Collection<BahmniObservation> getLatest(String patientUuid, Collection<Concept> conceptNames,Integer numberOfVisits, List<String> obsIgnoreList, Boolean filterObsWithOrders);
    public List<Concept> getNumericConceptsForPerson(String personUUID);
    public Collection<BahmniObservation> getLatestObsForConceptSetByVisit(String patientUuid, String conceptName, Integer visitId);
    Collection<BahmniObservation> getObservationForVisit(String visitUuid, List<String> conceptNames);
    Collection<BahmniObservation> getLatestObsByVisit(Visit visit, Collection<Concept> concepts, List<String> obsIgnoreList, Boolean filterObsWithOrders);
}
