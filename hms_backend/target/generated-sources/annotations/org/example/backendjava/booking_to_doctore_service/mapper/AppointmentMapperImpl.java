package org.example.backendjava.booking_to_doctore_service.mapper;

import javax.annotation.processing.Generated;
import org.example.backendjava.auth_service.model.entity.Patient;
import org.example.backendjava.auth_service.model.entity.User;
import org.example.backendjava.booking_to_doctore_service.model.dto.DoctorAppiontmentResponseDto;
import org.example.backendjava.booking_to_doctore_service.model.dto.PatientResponseDto;
import org.example.backendjava.booking_to_doctore_service.model.entity.Appointment;
import org.example.backendjava.booking_to_doctore_service.model.entity.AppointmentStatus;
import org.example.backendjava.booking_to_doctore_service.model.entity.CurrentPatientStatus;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-17T01:11:42+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Ubuntu)"
)
@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public DoctorAppiontmentResponseDto toDto(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        DoctorAppiontmentResponseDto doctorAppiontmentResponseDto = new DoctorAppiontmentResponseDto();

        doctorAppiontmentResponseDto.setPatient( patientToPatientResponseDto( appointment.getPatient() ) );
        doctorAppiontmentResponseDto.setStatus( appointmentCurrentPatientStatusStatus( appointment ) );
        doctorAppiontmentResponseDto.setSymptomsDescribedByPatient( appointmentCurrentPatientStatusSymptomsDescribedByPatient( appointment ) );
        doctorAppiontmentResponseDto.setSelfTreatmentMethodsTaken( appointmentCurrentPatientStatusSelfTreatmentMethodsTaken( appointment ) );
        doctorAppiontmentResponseDto.setId( appointment.getId() );
        doctorAppiontmentResponseDto.setDateTime( appointment.getDateTime() );

        return doctorAppiontmentResponseDto;
    }

    @Override
    public DoctorAppiontmentResponseDto toDoctorAppointmentResponseDto(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }

        DoctorAppiontmentResponseDto doctorAppiontmentResponseDto = new DoctorAppiontmentResponseDto();

        doctorAppiontmentResponseDto.setId( appointment.getId() );
        doctorAppiontmentResponseDto.setPatient( patientToPatientResponseDto1( appointment.getPatient() ) );
        doctorAppiontmentResponseDto.setDateTime( appointment.getDateTime() );

        return doctorAppiontmentResponseDto;
    }

    private String patientUserUsername(Patient patient) {
        if ( patient == null ) {
            return null;
        }
        User user = patient.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    protected PatientResponseDto patientToPatientResponseDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientResponseDto patientResponseDto = new PatientResponseDto();

        patientResponseDto.setId( patient.getId() );
        patientResponseDto.setUsername( patientUserUsername( patient ) );
        patientResponseDto.setPhoneNumber( patient.getPhoneNumber() );
        patientResponseDto.setAddress( patient.getAddress() );
        patientResponseDto.setBirthDate( patient.getBirthDate() );

        return patientResponseDto;
    }

    private AppointmentStatus appointmentCurrentPatientStatusStatus(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }
        CurrentPatientStatus currentPatientStatus = appointment.getCurrentPatientStatus();
        if ( currentPatientStatus == null ) {
            return null;
        }
        AppointmentStatus status = currentPatientStatus.getStatus();
        if ( status == null ) {
            return null;
        }
        return status;
    }

    private String appointmentCurrentPatientStatusSymptomsDescribedByPatient(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }
        CurrentPatientStatus currentPatientStatus = appointment.getCurrentPatientStatus();
        if ( currentPatientStatus == null ) {
            return null;
        }
        String symptomsDescribedByPatient = currentPatientStatus.getSymptomsDescribedByPatient();
        if ( symptomsDescribedByPatient == null ) {
            return null;
        }
        return symptomsDescribedByPatient;
    }

    private String appointmentCurrentPatientStatusSelfTreatmentMethodsTaken(Appointment appointment) {
        if ( appointment == null ) {
            return null;
        }
        CurrentPatientStatus currentPatientStatus = appointment.getCurrentPatientStatus();
        if ( currentPatientStatus == null ) {
            return null;
        }
        String selfTreatmentMethodsTaken = currentPatientStatus.getSelfTreatmentMethodsTaken();
        if ( selfTreatmentMethodsTaken == null ) {
            return null;
        }
        return selfTreatmentMethodsTaken;
    }

    protected PatientResponseDto patientToPatientResponseDto1(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientResponseDto patientResponseDto = new PatientResponseDto();

        patientResponseDto.setId( patient.getId() );
        patientResponseDto.setPhoneNumber( patient.getPhoneNumber() );
        patientResponseDto.setAddress( patient.getAddress() );
        patientResponseDto.setBirthDate( patient.getBirthDate() );

        return patientResponseDto;
    }
}
