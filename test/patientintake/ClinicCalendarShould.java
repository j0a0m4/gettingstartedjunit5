package patientintake;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClinicCalendarShould {

   @Test
   void allowEntryOfAnAppointment() {
      ClinicCalendar calendar = new ClinicCalendar();
      calendar.addAppointment("Jim", "Weaver", "avery",
         "09/01/2018 2:00 pm");

      var appointments = calendar.getAppointments();
      assertNotNull(appointments);
      assertEquals(1, appointments.size());

      var patient = appointments.get(0);
      assertEquals("Jim", patient.getPatientFirstName());
      assertEquals("Weaver", patient.getPatientLastName());
      assertEquals(Doctor.avery, patient.getDoctor());
      assertEquals("9/1/2018 02:00 PM",
         patient.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("M/d/yyyy hh:mm a", Locale.US)));
   }

}