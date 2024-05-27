package org.iesvdm.appointment.repository;

import org.iesvdm.appointment.entity.Appointment;
import org.iesvdm.appointment.entity.User;
import org.iesvdm.appointment.repository.impl.AppointmentRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class AppointmentRepositoryImplTest {

    private Set<Appointment> appointments;

    private AppointmentRepository appointmentRepository;

    @BeforeEach
    public void setup() {
        appointments = new HashSet<>();
        appointmentRepository = new AppointmentRepositoryImpl(appointments);
    }

    /**
     * Crea 2 citas (Appointment) una con id 1 y otra con id 2,
     * resto de valores inventados.
     * Agrégalas a las citas (appointments) con la que
     * construyes el objeto appointmentRepository bajo test.
     * Comprueba que cuando invocas appointmentRepository.getOne con uno
     * de los id's anteriores recuperas obtienes el objeto.
     * Pero si lo invocas con otro id diferente recuperas null
     */
    @Test
    void getOneTest() {
        // WHEN
        Appointment cita1 = new Appointment();
        Appointment cita2 = new Appointment();

        cita1.setId(1);
        cita2.setId(2);

        appointments.add(cita1);
        appointments.add(cita2);

        // DO
        Appointment cita3 = appointmentRepository.getOne(1);
        Appointment cita4 = appointmentRepository.getOne(2);
        Appointment cita5 = appointmentRepository.getOne(3);

        // THEN
        assertThat(cita1).isEqualTo(cita3);
        assertThat(cita2).isEqualTo(cita4);
        assertThat(cita5).isNull();

    }

    /**
     * Crea 2 citas (Appointment) y guárdalas mediante
     * appointmentRepository.save.
     * Comprueba que la colección appointments
     * contiene sólo esas 2 citas.
     */
    @Test
    void saveTest() {
        // WHEN
        Appointment cita1 = new Appointment();
        Appointment cita2 = new Appointment();

        cita1.setId(1);
        cita2.setId(2);

        appointmentRepository.save(cita1);
        appointmentRepository.save(cita2);

        // DO
        Appointment cita3 = appointmentRepository.getOne(1);
        Appointment cita4 = appointmentRepository.getOne(2);

        // THEN
        assertThat(cita1).isEqualTo(cita3);
        assertThat(cita2).isEqualTo(cita4);
    }

    /**
     * Crea 2 citas (Appointment) una cancelada por un usuario y otra no,
     * (atención al estado de la cita, lee el código) y agrégalas mediante
     * appointmentRepository.save a la colección de appointments
     * Comprueba que mediante appointmentRepository.findCanceledByUser
     * obtienes la cita cancelada.
     */
    @Test
    void findCanceledByUserTest() {
        // WHEN
        Appointment cita1 = new Appointment();
        Appointment cita2 = new Appointment();

        cita1.setId(1);
        cita2.setId(2);

        User user = new User(101,"usuario0","contraseña");
        cita1.setCanceler(user);

        appointmentRepository.save(cita1);
        appointmentRepository.save(cita2);

        // DO
        Appointment cita3 = appointmentRepository.findCanceledByUser(user.getId()).getFirst();

        // THEN
        assertThat(cita1).isEqualTo(cita3);
    }

    /**
     * Crea 3 citas (Appointment), 2 para un mismo cliente (Customer)
     * con sólo una cita de ellas presentando fecha de inicio (start)
     * y fin (end) dentro del periodo de búsqueda (startPeriod,endPeriod).
     * Guárdalas mediante appointmentRepository.save.
     * Comprueba que appointmentRepository.findByCustomerIdWithStartInPeroid
     * encuentra la cita en cuestión.
     * Nota: utiliza LocalDateTime.of(...) para crear los LocalDateTime
     */
    @Test
    void findByCustomerIdWithStartInPeroidTest() {
        // WHEN


        // DO


        // THEN

    }


    /**
     * Crea 2 citas (Appointment) una planificada (SCHEDULED) con tiempo fin
     * anterior a la tiempo buscado por appointmentRepository.findScheduledWithEndBeforeDate
     * guardándolas mediante appointmentRepository.save para la prueba de findScheduledWithEndBeforeDate
     *
     */
    @Test
    void findScheduledWithEndBeforeDateTest() {
        // WHEN


        // DO


        // THEN

    }


    /**
     * Crea 3 citas (Appointment) planificadas (SCHEDULED)
     * , 2 para un mismo cliente, con una elegible para cambio (con fecha de inicio, start, adecuada)
     * y otra no.
     * La tercera ha de ser de otro cliente.
     * Guárdalas mediante appointmentRepository.save
     * Comprueba que getEligibleAppointmentsForExchange encuentra la correcta.
     */
    @Test
    void getEligibleAppointmentsForExchangeTest() {
        // WHEN


        // DO


        // THEN

    }


    /**
     * Igual que antes, pero ahora las 3 citas tienen que tener
     * clientes diferentes y 2 de ellas con fecha de inicio (start)
     * antes de la especificada en el método de búsqueda para
     * findExchangeRequestedWithStartBefore
     */
    @Test
    void findExchangeRequestedWithStartBeforeTest() {
        // WHEN


        // DO


        // THEN

    }
}
