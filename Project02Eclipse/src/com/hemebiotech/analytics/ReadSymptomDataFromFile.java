package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for reading symptom data from a file.
 * This class implements the ISymptomReader interface,
 * providing functionality to read symptoms from a specified file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Reads the symptoms from the file specified by the filepath.
	 * 
	 * @return A List of strings, where each string is a symptom read from the file.
	 */
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		// Check if the filepath is not null to avoid a NullPointerException.
		if (filepath != null) {
			try {
				// Open the file for reading using a BufferedReader for efficient reading.
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
				// Read each line of the file until the end (null).
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Return the list of symptoms read from the file.
		return result;
	}

}