package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String args[]) {

        // Create a reader instance to read symptoms from a file.
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

        // Create a writer instance to write the sorted symptoms to a file.
        ISymptomWriter writer = new WriteSymptomDataToFile();

        // Create an AnalyticsCounter instance to handle the operations of reading,
        // counting, sorting, and writing symptoms.
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // Retrieve the list of symptoms from the file using the reader.
        List<String> symptomsList = counter.getSymptoms();

        // Count the occurrences of each symptom in the list.
        Map<String, Integer> symptomsMap = counter.countSymptoms(symptomsList);

        // Sort the symptoms map by key (symptom names) to get an ordered map.
        Map<String, Integer> symptomsSorted = counter.sortSymptoms(symptomsMap);

        // Write the sorted symptoms and their counts to a file using the writer.
        counter.writeSymptoms(symptomsSorted);
    }
}
