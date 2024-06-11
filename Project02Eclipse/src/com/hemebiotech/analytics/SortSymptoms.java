package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.List;

public class SortSymptoms {
    private List<String> listToSort;

    public SortSymptoms(List<String> listToSort) {
        this.listToSort = listToSort;
    }

    // Order the list

    public List<String> SortSymptomsFromList() {
        try {
            Collections.sort(listToSort);
            return (listToSort);
        } catch (Exception e) {
            // In case of an exception, display an error message and return null
            System.err.println("Une erreur s'est produite lors du tri des symptômes : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}