package exception;

public class PatientIdNotFoundException extends Exception {
    public PatientIdNotFoundException(String message) {
        System.out.println("Patientid not found");
    }
}
    