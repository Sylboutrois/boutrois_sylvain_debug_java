package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;

public class CountSymptomFromList {
    private List<String> listSorted;

    public CountSymptomFromList(List<String> listSorted) {
        this.listSorted = listSorted;
    }

    public HashMap<String, Integer> countSymptoms() {
        HashMap<String, Integer> mapSortAndCount = new HashMap<>();

        // Use a loop for-each to browse through the list of symptoms
        for (String symptom : listSorted) {
            // Check if the symptom is already in the list
            if (mapSortAndCount.containsKey(symptom)) {
                // If yes, count +1
                mapSortAndCount.put(symptom, mapSortAndCount.get(symptom) + 1);
            } else {
                // if no initialise count at 1
                mapSortAndCount.put(symptom, 1);
            }
        }

        return mapSortAndCount;
    }
}
