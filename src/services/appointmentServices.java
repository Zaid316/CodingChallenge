package services;
import dao.*;
import entity.*;
import java.util.*;

public class appointmentServices {
    Scanner sc;
    HospitalServiceImpl hdao;

    public appointmentServices(){
        hdao = new HospitalServiceImpl();
        sc = new Scanner(System.in);
    }

    public void getappbyid(){
        System.out.println("Enter appointment id: ");
        int appointmentId = sc.nextInt();
        sc.nextLine();
        Appointment appointment = hdao.getAppointmentById(appointmentId);
        if(appointment!=null){
            System.out.println(appointment.toString());
        }
        else{
            System.out.println("appointment not found");
        }
    }

    public void getAppbyPatientId() {
        System.out.println("Enter patient id: ");
        int patientId = sc.nextInt();
        sc.nextLine();
        List<Appointment> appointments = hdao.getAppointmentsForPatient(patientId);
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for patient with ID " + patientId);
        } 
        else {
            System.out.println("Appointments for patient with ID " + patientId + ":");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    public void getAppbyDoctorId() {
        System.out.println("Enter doctor id: ");
        int doctorId = sc.nextInt();
        sc.nextLine();
        List<Appointment> appointments = hdao.getAppointmentsForDoctor(doctorId);
        if (appointments.isEmpty()) {
            System.out.println("No appointments found for doctor with ID " + doctorId);
        } else {
            System.out.println("Appointments for doctor with ID " + doctorId + ":");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    public void createAppointment(){
            Appointment appointment = new Appointment();

            System.out.println("Enter appointment id: ");
            appointment.setAppointmentId(sc.nextInt());
            sc.nextLine(); 

            System.out.println("Enter patient id: ");
            appointment.setPatientId(sc.nextInt());
            sc.nextLine(); 
        
            System.out.println("Enter doctor id: ");
            appointment.setDoctorId(sc.nextInt());
            sc.nextLine(); 
        
            System.out.println("Enter appointment date (YYYY-MM-DD): ");
            appointment.setAppointmentDate(sc.nextLine());
        
            System.out.println("Enter appointment description: ");
            appointment.setDescription(sc.nextLine());
        
            hdao.scheduleAppointment(appointment);
    }

    public void updateAppointment(){
        System.out.println("Enter appointment ID: ");
        int appointmentId = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter new appointment date (YYYY-MM-DD): ");
        String newDate = sc.nextLine();
        
        hdao.updateAppointment(appointmentId,newDate);

    }

    public void cancel(){
        System.out.println("Enter appointment ID to cancel: ");
        int appointmentId = sc.nextInt();
        sc.nextLine();
        hdao.cancelAppointment(appointmentId);
    }
}
