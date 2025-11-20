package org.example.backendjava.booking_to_doctore_service.controller;

import lombok.RequiredArgsConstructor;
import org.example.backendjava.autth_service.service.UserService;
import org.example.backendjava.booking_to_doctore_service.model.dto.AppointmentRequestDto;
import org.example.backendjava.booking_to_doctore_service.model.dto.DoctorResponseDto;
import org.example.backendjava.booking_to_doctore_service.model.entity.Appointment;
import org.example.backendjava.booking_to_doctore_service.service.AppointmentService;
import org.example.backendjava.booking_to_doctore_service.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private final UserService userService;

    /**
     * Регистрирует запись на прием к врачу.
     * Patient ID автоматически берется из JWT токена текущего пользователя.
     *
     * @param dto запрос с данными записи (doctorId, dateTime)
     * @return сообщение об успешной регистрации
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerAppointment(@RequestBody AppointmentRequestDto dto) {
        // Получаем Authentication из SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Извлекаем username из токена
        String username = authentication.getName();

        // Получаем ID пользователя по username
        Long userId = userService.findUserIdByUsername(username);

        // Устанавливаем patientId автоматически (пользователь не может подделать свой ID)
        dto.setPatientId(userId);

        Appointment appointment = appointmentService.registerAppointment(dto);
        return ResponseEntity.ok("Appointment registered with ID: " + appointment.getId());
    }

    /**
     * Получает все записи конкретного врача.
     *
     * @param id ID врача
     * @return список записей врача
     */
    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<Appointment>> getDoctorAppointments(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentsForDoctor(id));
    }

    /**
     * Получает все записи конкретного пациента.
     *
     * @param id ID пациента
     * @return список записей пациента
     */
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<Appointment>> getPatientAppointments(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentsForPatient(id));
    }

    /**
     * Получает все записи текущего авторизованного пациента.
     * Patient ID автоматически берется из JWT токена.
     *
     * @return список записей текущего пациента
     */
    @GetMapping("/my-appointments")
    public ResponseEntity<List<Appointment>> getMyAppointments() {
        // Получаем username из SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Получаем ID пользователя
        Long userId = userService.findUserIdByUsername(username);

        return ResponseEntity.ok(appointmentService.getAppointmentsForPatient(userId));
    }

    /**
     * Получает список всех врачей.
     *
     * @return список врачей
     */
    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.findAllDoctors());
    }
}