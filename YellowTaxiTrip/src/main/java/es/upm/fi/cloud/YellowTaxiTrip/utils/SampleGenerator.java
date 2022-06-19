package es.upm.fi.cloud.YellowTaxiTrip.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * @author wenqi
 */
public class SampleGenerator {

    public static void main(String[] args) throws Exception {
        Path filePath = Path.of("src/main/resources/yellow_tripdata_2022-03_sample.csv");


        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/yellow_tripdata_2022-03.csv"))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (count % 500 == 0) {
                    Files.writeString(filePath, line + "\n", StandardOpenOption.APPEND);
                }
                count++;
            }
        }
    }
}