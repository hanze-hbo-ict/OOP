package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import com.opencsv.exceptions.CsvValidationException;

public class CsvReader {

    /**
     * Read records from a csv resources file
     *
     * @param filename The file to read from
     * @return Returs records read
     */
    public static List<List<String>> read(String filename) {
        return read(filename, false);
    }

    /**
     * Read records from a csv resources file
     *
     * @param filename   The file to read from
     * @param skipHeader If the header row should be omitted
     * @return Returs records read
     */
    public static List<List<String>> read(String filename, boolean skipHeader) {
        List<List<String>> records = new ArrayList<>();

        try {
            ClassLoader classLoader = CsvReader.class.getClassLoader();
            BufferedInputStream bi =
                    (BufferedInputStream) classLoader.getResource(filename).getContent();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(bi))) {

                CSVReader reader;

                if (skipHeader) {
                    reader = new CSVReaderBuilder(br).withSkipLines(1).build();
                } else {
                    reader = new CSVReader(br);
                }

                String[] record;
                while ((record = reader.readNext()) != null) {
                    records.add(Arrays.asList(record));
                }
                reader.close();
            }
        } catch (IOException e) {
            System.out.printf("File '%s' not found (%s)\n", filename, e);
        } catch (CsvValidationException e) {
            System.out.printf("File '%s' has errors (%s)\n", filename, e);
        }

        return records;
    }
}
