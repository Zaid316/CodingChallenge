package entity;

public class Doctor {
    public int doctorId;
    public String firstName;
    public String lastName;
    public String specialization;
    public String contactNumber;
    


public Doctor() {

}

public Doctor(int doctorId, String firstName, String lastName, String specialization, String contactNumber) {
    this.doctorId = doctorId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.specialization = specialization;
    this.contactNumber = contactNumber;
}

public int getDoctorId() {
    return doctorId;
}

public void setDoctorId(int doctorId) {
    this.doctorId = doctorId;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getSpecialization() {
    return specialization;
}

public void setSpecialization(String specialization) {
    this.specialization = specialization;
}

public String getContactNumber() {
    return contactNumber;
}

public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
}

@Override
public String toString() {
    return  "doctorId=" + doctorId +
            "firstName=" + firstName + 
            "lastName= " + lastName + 
            "specialization=" + specialization +
            "contactNumber=" + contactNumber;
}
}


