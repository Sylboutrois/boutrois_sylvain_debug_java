package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	// Reader and writer for symptom data
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	// Counts occurrences of each symptom in a list
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsMap = new HashMap<>();

		try {
			for (String i : symptoms) {
				if (symptomsMap.containsKey(i)) {
					symptomsMap.put(i, symptomsMap.get(i) + 1);
				} else {
					symptomsMap.put(i, 1);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return symptomsMap;
	}

	// Delegates reading symptoms to the reader interface
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	// Sorts a symptom map by key (symptom name)
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	// Delegates writing symptoms to the writer interface
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}