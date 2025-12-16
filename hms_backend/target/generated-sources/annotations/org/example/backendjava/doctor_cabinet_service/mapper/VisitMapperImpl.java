package org.example.backendjava.doctor_cabinet_service.mapper;

import javax.annotation.processing.Generated;
import org.example.backendjava.auth_service.model.entity.Doctor;
import org.example.backendjava.auth_service.model.entity.Patient;
import org.example.backendjava.doctor_cabinet_service.model.dto.VisitRequestDTO;
import org.example.backendjava.doctor_cabinet_service.model.dto.VisitResponseDTO;
import org.example.backendjava.doctor_cabinet_service.model.entity.Visit;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-17T01:11:42+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Ubuntu)"
)
@Component
public class VisitMapperImpl implements VisitMapper {

    @Override
    public Visit toEntity(VisitRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Visit visit = new Visit();

        visit.setDoctor( visitRequestDTOToDoctor( dto ) );
        visit.setPatient( visitRequestDTOToPatient( dto ) );
        visit.setVisitDate( dto.getVisitDate() );
        visit.setSymptoms( dto.getSymptoms() );
        visit.setDiagnosis( dto.getDiagnosis() );
        visit.setLifeAnamnesis( dto.getLifeAnamnesis() );
        visit.setDiseaseAnamnesis( dto.getDiseaseAnamnesis() );
        visit.setInitialExamination( dto.getInitialExamination() );
        visit.setStateDynamics( dto.getStateDynamics() );
        visit.setLabResults( dto.getLabResults() );
        visit.setInstrumentalResults( dto.getInstrumentalResults() );
        visit.setRecommendations( dto.getRecommendations() );
        visit.setMedications( dto.getMedications() );
        visit.setDosage( dto.getDosage() );
        visit.setDischargeDate( dto.getDischargeDate() );
        visit.setTreatmentDurationDays( dto.getTreatmentDurationDays() );

        return visit;
    }

    @Override
    public VisitResponseDTO toDto(Visit visit) {
        if ( visit == null ) {
            return null;
        }

        VisitResponseDTO visitResponseDTO = new VisitResponseDTO();

        visitResponseDTO.setDoctorId( visitDoctorId( visit ) );
        visitResponseDTO.setPatientId( visitPatientId( visit ) );
        visitResponseDTO.setId( visit.getId() );
        visitResponseDTO.setVisitDate( visit.getVisitDate() );
        visitResponseDTO.setSymptoms( visit.getSymptoms() );
        visitResponseDTO.setDiagnosis( visit.getDiagnosis() );
        visitResponseDTO.setLifeAnamnesis( visit.getLifeAnamnesis() );
        visitResponseDTO.setDiseaseAnamnesis( visit.getDiseaseAnamnesis() );
        visitResponseDTO.setInitialExamination( visit.getInitialExamination() );
        visitResponseDTO.setStateDynamics( visit.getStateDynamics() );
        visitResponseDTO.setLabResults( visit.getLabResults() );
        visitResponseDTO.setInstrumentalResults( visit.getInstrumentalResults() );
        visitResponseDTO.setRecommendations( visit.getRecommendations() );
        visitResponseDTO.setMedications( visit.getMedications() );
        visitResponseDTO.setDosage( visit.getDosage() );
        visitResponseDTO.setDischargeDate( visit.getDischargeDate() );
        visitResponseDTO.setTreatmentDurationDays( visit.getTreatmentDurationDays() );

        return visitResponseDTO;
    }

    @Override
    public void update(Visit visit, VisitRequestDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getVisitDate() != null ) {
            visit.setVisitDate( dto.getVisitDate() );
        }
        if ( dto.getSymptoms() != null ) {
            visit.setSymptoms( dto.getSymptoms() );
        }
        if ( dto.getDiagnosis() != null ) {
            visit.setDiagnosis( dto.getDiagnosis() );
        }
        if ( dto.getLifeAnamnesis() != null ) {
            visit.setLifeAnamnesis( dto.getLifeAnamnesis() );
        }
        if ( dto.getDiseaseAnamnesis() != null ) {
            visit.setDiseaseAnamnesis( dto.getDiseaseAnamnesis() );
        }
        if ( dto.getInitialExamination() != null ) {
            visit.setInitialExamination( dto.getInitialExamination() );
        }
        if ( dto.getStateDynamics() != null ) {
            visit.setStateDynamics( dto.getStateDynamics() );
        }
        if ( dto.getLabResults() != null ) {
            visit.setLabResults( dto.getLabResults() );
        }
        if ( dto.getInstrumentalResults() != null ) {
            visit.setInstrumentalResults( dto.getInstrumentalResults() );
        }
        if ( dto.getRecommendations() != null ) {
            visit.setRecommendations( dto.getRecommendations() );
        }
        if ( dto.getMedications() != null ) {
            visit.setMedications( dto.getMedications() );
        }
        if ( dto.getDosage() != null ) {
            visit.setDosage( dto.getDosage() );
        }
        if ( dto.getDischargeDate() != null ) {
            visit.setDischargeDate( dto.getDischargeDate() );
        }
        if ( dto.getTreatmentDurationDays() != null ) {
            visit.setTreatmentDurationDays( dto.getTreatmentDurationDays() );
        }
    }

    protected Doctor visitRequestDTOToDoctor(VisitRequestDTO visitRequestDTO) {
        if ( visitRequestDTO == null ) {
            return null;
        }

        Doctor doctor = new Doctor();

        doctor.setId( visitRequestDTO.getDoctorId() );

        return doctor;
    }

    protected Patient visitRequestDTOToPatient(VisitRequestDTO visitRequestDTO) {
        if ( visitRequestDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( visitRequestDTO.getPatientId() );

        return patient;
    }

    private Long visitDoctorId(Visit visit) {
        if ( visit == null ) {
            return null;
        }
        Doctor doctor = visit.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        Long id = doctor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long visitPatientId(Visit visit) {
        if ( visit == null ) {
            return null;
        }
        Patient patient = visit.getPatient();
        if ( patient == null ) {
            return null;
        }
        Long id = patient.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
