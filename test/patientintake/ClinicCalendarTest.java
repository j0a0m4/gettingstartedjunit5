package patientintake;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {

   @Test
   void allowEntryOfAnAppointment() {
      final var calendar = new ClinicCalendar();
      calendar.addAppointment("Jim", "Weaver", "avery",
         "09/01/2018 2:00 pm");

      final var appointments = calendar.getAppointments();
      assertNotNull(appointments);
      assertEquals(1, appointments.size());

      final var patient = appointments.get(0);
      assertEquals("Jim", patient.getPatientFirstName());
      assertEquals("Weaver", patient.getPatientLastName());
      assertSame(Doctor.avery, patient.getDoctor());
      assertEquals("9/1/2018 02:00 PM",
         patient.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a", Locale.US)));
   }

   @Test
   public void returnTrueForHasAppointmentsIfThereAreNoAppointments() {
      final var calendar = new ClinicCalendar();
      calendar.addAppointment("Benjamin", "Deux", "avery", "09/01/2018 2:00 pm");

      final var date = LocalDate.of(2018, 9, 1);
      assertTrue(calendar.hasAppointment(date));
   }

   @Test
   public void returnFalseForHasAppointmentsIfThereAreAppointments() {
      final var calendar = new ClinicCalendar();

      final var date = LocalDate.of(2018, 9, 1);
      assertFalse(calendar.hasAppointment(date));
   }
}