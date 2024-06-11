package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Class for writing symptom data to a file.
 * This class implements the ISymptomWriter interface,
 * providing functionality to write symptoms and their counts to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    /**
     * Writes the symptoms and their corresponding counts to a file.
     * The output file is "Project02Eclipse/result.out".
     * 
     * @param mapToWrite A Map where the key is the symptom and the value is the
     *                   number of occurrences.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> mapToWrite) {
        try (FileWriter writer = new FileWriter("Project02Eclipse/result.out")) {
            Set<String> symptoms = mapToWrite.keySet();
            // Iterate over each symptom in the set.
            for (String symptom : symptoms) {
                try {
                    // Write the symptom and its count to the file in the format "symptom : count".
                    writer.write(symptom + " : " + mapToWrite.get(symptom) + "\n");
                } catch (IOException e) {
                    // Print the stack trace if an I/O error occurs during writing.
                    e.printStackTrace();
                }
            }
            // Print the stack trace if an I/O error occurs while opening the FileWriter.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}