package dao;
import entity.*;
import util.DBConnection;
import java.sql.*;
import java.util.*;

public class HospitalServiceImpl implements IHospitalService {
    private Connection con;
	private PreparedStatement stat;

    public HospitalServiceImpl(){
        con = DBConnection.getConnect();
    }

    public Appointment getAppointmentById(int appointmentId){
        Appointment appointment = null;
    try {
        stat = con.prepareStatement("SELECT * FROM Appointment WHERE appointmentId = ?");
        stat.setInt(1, appointmentId);
        ResultSet resultSet = stat.executeQuery();
        if (resultSet.next()) {
            appointment = new Appointment();
            appointment.setAppointmentId(resultSet.getInt("appointmentId"));
            appointment.setPatientId(resultSet.getInt("patientId"));
            appointment.setDoctorId(resultSet.getInt("doctorId"));
            appointment.setAppointmentDate(resultSet.getString("appointmentDate"));
            appointment.setDescription(resultSet.getString("description"));
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return appointment;
}
public List<Appointment> getAppointmentsForPatient(int patientId) {
    List<Appointment> appointments = new ArrayList<>();
    try {
        stat = con.prepareStatement("SELECT * FROM Appointment WHERE patientId = ?");
        stat.setInt(1, patientId);
        ResultSet resultSet = stat.executeQuery();
        while (resultSet.next()) {
            Appointment appointment = new Appointment();
            appointment.setAppointmentId(resultSet.getInt("appointmentId"));
            appointment.setPatientId(resultSet.getInt("patientId"));
            appointment.setDoctorId(resultSet.getInt("doctorId"));
            appointment.setAppointmentDate(resultSet.getString("appointmentDate"));
            appointment.setDescription(resultSet.getString("description"));
            appointments.add(appointment);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return appointments;

}

public List<Appointment> getAppointmentsForDoctor(int doctorId) {
    List<Appointment> appointments = new ArrayList<>();
    try {
        stat = con.prepareStatement("SELECT * FROM Appointment WHERE doctorId = ?");
        stat.setInt(1, doctorId);
        ResultSet resultSet = stat.executeQuery();
        while (resultSet.next()) {
            Appointment appointment = new Appointment();
            appointment.setAppointmentId(resultSet.getInt("appointmentId"));
            appointment.setPatientId(resultSet.getInt("patientId"));
            appointment.setDoctorId(resultSet.getInt("doctorId"));
            appointment.setAppointmentDate(resultSet.getString("appointmentDate"));
            appointment.setDescription(resultSet.getString("description"));
            appointments.add(appointment);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return appointments;
}
public boolean scheduleAppointment(Appointment appointment) {
    try {
        PreparedStatement statement = con.prepareStatement("INSERT INTO Appointment (appointmentId, patientId, doctorId, appointmentDate, description) VALUES (?, ?, ?, ?, ?)");
        statement.setInt(1, appointment.getAppointmentId());
        statement.setInt(2, appointment.getPatientId());
        statement.setInt(3, appointment.getDoctorId());
        statement.setString(4, appointment.getAppointmentDate());
        statement.setString(5, appointment.getDescription());

        int rows = statement.executeUpdate();
        if (rows > 0) {
            System.out.println("Appointment scheduled successfully" );
            return true;
        }
    } catch (SQLException e) {
        System.out.println( e.getMessage());
    }
    return false;
}
    
public boolean updateAppointment(int appointmentId, String newDate) {
    try {
        PreparedStatement statement = con.prepareStatement("UPDATE Appointment SET appointmentDate = ? WHERE appointmentId = ?");
        statement.setString(1, newDate);
        statement.setInt(2, appointmentId);

        int rows = statement.executeUpdate();
        if (rows > 0) {
            System.out.println("Appointment date updated successfully for appointment id " + appointmentId);
            return true;
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return false;
}

public boolean cancelAppointment(int appointmentId) {
    try {
        PreparedStatement statement = con.prepareStatement("DELETE FROM Appointment WHERE appointmentId = ?");
        statement.setInt(1, appointmentId);

        int rows = statement.executeUpdate();
        if (rows > 0) {
        }
            System.out.println("appointment cancelled successfully for " + appointmentId);
            return true;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return false;



}
}




