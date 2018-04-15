package refugeescode.at.the_hospital_admission.patientsEndpoint;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import refugeescode.at.the_hospital_admission.model.Symptom;
import refugeescode.at.the_hospital_admission.model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController

public class PatientsEndpoint {
    private Patient patient;
    private Symptom symptom;

    public PatientsEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private RestTemplate restTemplate;
    @Value("${diagnosisUrl}")
    String diagnosisUrl;

    private List<Patient> patients = new ArrayList<>();

    @PostMapping("/patients")

    List<Patient> post(@RequestBody Patient patient) {
        patient.setPatientNumber(UUID.randomUUID().toString());
        restTemplate.postForEntity(diagnosisUrl, patient, String.class);
        return patients;
    }
}
