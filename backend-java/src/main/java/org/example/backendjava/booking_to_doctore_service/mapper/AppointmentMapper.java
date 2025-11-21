package org.example.backendjava.booking_to_doctore_service.mapper;

import org.example.backendjava.booking_to_doctore_service.model.dto.DoctorAppiontmentResponseDto;
import org.example.backendjava.booking_to_doctore_service.model.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Маппер для преобразования Appointment в DTO и обратно.
 * MapStruct автоматически генерирует код для конвертации.
 */
@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    /**
     * Преобразует сущность Appointment в DTO для ответа.
     * @Mapping указывает, откуда брать данные:
     * - из currentPatientStatus.status берем статус
     * - из currentPatientStatus.symptomsDescribedByPatient берем симптомы
     * - из currentPatientStatus.selfTreatmentMethodsTaken берем методы самолечения
     */
    @Mapping(source = "currentPatientStatus.status", target = "status")
    @Mapping(source = "currentPatientStatus.symptomsDescribedByPatient", target = "symptomsDescribedByPatient")
    @Mapping(source = "currentPatientStatus.selfTreatmentMethodsTaken", target = "selfTreatmentMethodsTaken")
    DoctorAppiontmentResponseDto toDto(Appointment appointment);
}