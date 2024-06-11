package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WriteSymptomDataToFile implements ISymptomWriter {

    @Override
    public void writeSymptoms(Map<String, Integer> mapToWrite) {
        try (FileWriter writer = new FileWriter("Project02Eclipse/result.out")) {
            Set<String> symptoms = mapToWrite.keySet();
            for (String symptom : symptoms) {
                try {
                    writer.write(symptom + " : " + mapToWrite.get(symptom) + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}