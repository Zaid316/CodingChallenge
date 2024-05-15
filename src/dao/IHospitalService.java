package dao;
import entity.*;
import java.util.*;

public interface IHospitalService {
    Appointment getAppointmentById(int appointmentId);
    List<Appointment> getAppointmentsForPatient(int patientId);
    List<Appointment> getAppointmentsForDoctor(int doctorId);
    boolean scheduleAppointment(Appointment appointment);
    boolean updateAppointment(int appointmentId, String newDate );
    boolean cancelAppointment(int appointmentId);
}
