package refugeescode.at.the_diagnose_room.controller;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import refugeescode.at.the_diagnose_room.model.Illness;
import refugeescode.at.the_diagnose_room.model.Patient;
import refugeescode.at.the_diagnose_room.model.Symptom;
import refugeescode.at.the_diagnose_room.parser.DrHouseParser;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;


@Controller
public class DrHouse {
    private DrHouseParser drHouseParser;
    private Illness illnessName;

    public DrHouse(DrHouseParser drHouseParser) {
        this.drHouseParser = drHouseParser;
    }

    public Patient diagnose(Patient patient) {
        List<Symptom> symptoms = patient.getSymptoms();
        String ilness = drHouseParser.getDiagnoses().entrySet()
                .stream()
                .filter(e -> e.getValue().containsAll(symptoms) && e.getValue().size() == symptoms.size())
                .map(e -> e.getKey())
                .findFirst()
                .orElse("lupus");
        illnessName.setIllnessName(ilness);
        patient.setIllness(illnessName);
        return patient;

    }


}
