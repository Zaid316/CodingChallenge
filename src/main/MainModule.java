package main;
import services.*;
import java.util.*;
import exception.*;

public class MainModule {
    public static void main(String[] args) throws PatientIdNotFoundException {
        appointmentServices aps = new appointmentServices();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Menu:");
            System.out.println("1. Get Appointment by ID");
            System.out.println("2. Get Appointment by PatientID");
            System.out.println("3. Get Appointment by DoctorId");
            System.out.println("4. Set an appointment for the patient");
            System.out.println("5. Update your appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. Exit"); 

            int ch = sc.nextInt();
            sc.nextLine();
        
        switch (ch) {
            case 1:
                aps.getappbyid();
            break;

            case 2:
                aps.getAppbyPatientId();
            break;

            case 3:
                aps.getAppbyDoctorId();
                break;

            case 4:
                aps.createAppointment();
                break;

            case 5:
                aps.updateAppointment();
                break;

            case 6:
                aps.cancel();
                break;

            case 7:
                sc.close();
                System.exit(0);
                break;

             default:
                System.out.println("Invalid choice");

        }

        
    }
}
}
