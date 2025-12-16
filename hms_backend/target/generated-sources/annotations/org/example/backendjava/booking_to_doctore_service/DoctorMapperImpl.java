package org.example.backendjava.booking_to_doctore_service;

import javax.annotation.processing.Generated;
import org.example.backendjava.auth_service.model.entity.Doctor;
import org.example.backendjava.booking_to_doctore_service.model.dto.DoctorResponseDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-17T01:11:42+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Ubuntu)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public DoctorResponseDto toDto(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();

        doctorResponseDto.setId( doctor.getId() );
        doctorResponseDto.setUser( doctor.getUser() );
        doctorResponseDto.setSpecialization( doctor.getSpecialization() );
        doctorResponseDto.setPhoneNumber( doctor.getPhoneNumber() );
        doctorResponseDto.setBirthDate( doctor.getBirthDate() );

        return doctorResponseDto;
    }
}
