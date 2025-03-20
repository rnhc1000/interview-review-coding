package br.dev.ferreiras.challenges.techteems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CsvReader {

    private static final Logger logger = Logger.getLogger(CsvReader.class.getName());
    public static List<String[]> readCsv(String filePath) {
        List<String[]> moveSequences = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = "";
            String regex= ",";
            while ((line = br.readLine()) != null) {
                moveSequences.add(line.split(regex));
            }
        } catch (IOException e) {
           logger.log(Level.INFO, "Error reading file: {0}" + e.getMessage());
        }


        return moveSequences;
    }
}

