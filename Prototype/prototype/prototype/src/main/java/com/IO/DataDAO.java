package com.IO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

public class DataDAO {
    private final static String RESOURCES_PATH = "src/main/resources/";
    private final static String FILE_NAME = "data_file.csv";
    private final static String SEPARATOR = ";";

    public List<Data> lectureData() throws FileNotFoundException {
        File file = new File(RESOURCES_PATH + FILE_NAME);
        FileReader fr = new FileReader(file);
        CSVReader csvReader = new CSVReader(fr);
        
        
		return null;
    }
}
