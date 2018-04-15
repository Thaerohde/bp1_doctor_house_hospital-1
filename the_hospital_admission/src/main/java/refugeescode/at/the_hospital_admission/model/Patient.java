package refugeescode.at.the_hospital_admission.model;

import java.util.List;

public class Patient {
    private String patientName;
    private String patientNumber;

    private List<Symptom> symptoms;

    public Patient(String patientName, String patientNumber) {
        this.patientName = patientName;
        this.patientNumber = patientNumber;
    }

    public Patient() {

    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public List<Symptom> getSymptom(){
        return symptoms;

    }

//    @Override
//    public String toString() {
//        return "Patient{" +
//                "patientName='" + patientName + '\'' +
//                ", patientNumber='" + patientNumber + '\'' +
//                '}';
//    }
}
