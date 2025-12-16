package org.example.backendjava.auth_service.mapper;

import javax.annotation.processing.Generated;
import org.example.backendjava.auth_service.model.dto.DoctorResumeRequestDto;
import org.example.backendjava.auth_service.model.dto.DoctorResumeResponseDto;
import org.example.backendjava.auth_service.model.entity.Doctor;
import org.example.backendjava.auth_service.model.entity.DoctorResume;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-17T01:11:42+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Ubuntu)"
)
@Component
public class DoctorResumeMapperImpl implements DoctorResumeMapper {

    @Override
    public DoctorResume toEntity(DoctorResumeRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        DoctorResume doctorResume = new DoctorResume();

        doctorResume.setStage( dto.getStage() );
        doctorResume.setExperienceYears( dto.getExperienceYears() );
        doctorResume.setEducation( dto.getEducation() );
        doctorResume.setCertificates( dto.getCertificates() );
        doctorResume.setDescription( dto.getDescription() );

        return doctorResume;
    }

    @Override
    public DoctorResumeResponseDto toDto(DoctorResume entity) {
        if ( entity == null ) {
            return null;
        }

        DoctorResumeResponseDto doctorResumeResponseDto = new DoctorResumeResponseDto();

        doctorResumeResponseDto.setDoctorId( entityDoctorId( entity ) );
        doctorResumeResponseDto.setId( entity.getId() );
        doctorResumeResponseDto.setStage( entity.getStage() );
        doctorResumeResponseDto.setExperienceYears( entity.getExperienceYears() );
        doctorResumeResponseDto.setEducation( entity.getEducation() );
        doctorResumeResponseDto.setCertificates( entity.getCertificates() );
        doctorResumeResponseDto.setPhotoUrl( entity.getPhotoUrl() );
        doctorResumeResponseDto.setDescription( entity.getDescription() );

        return doctorResumeResponseDto;
    }

    @Override
    public void update(DoctorResume entity, DoctorResumeRequestDto dto) {
        if ( dto == null ) {
            return;
        }

        entity.setStage( dto.getStage() );
        entity.setExperienceYears( dto.getExperienceYears() );
        entity.setEducation( dto.getEducation() );
        entity.setCertificates( dto.getCertificates() );
        entity.setDescription( dto.getDescription() );
    }

    private Long entityDoctorId(DoctorResume doctorResume) {
        if ( doctorResume == null ) {
            return null;
        }
        Doctor doctor = doctorResume.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        Long id = doctor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
