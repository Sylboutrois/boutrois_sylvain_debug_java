package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String args[]) {

        // Création d'un constructeur reader pour la récupération des symptoms
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

        // Création d'un constructeur pour la création des symptoms
        ISymptomWriter writer = new WriteSymptomDataToFile();

        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
        List<String> symptomsList = counter.getSymptoms();
        Map<String, Integer> symptomsMap = counter.countSymptoms(symptomsList);
        Map<String, Integer> symptomsSorted = counter.sortSymptoms(symptomsMap);
        counter.writeSymptoms(symptomsSorted);
    }
}
