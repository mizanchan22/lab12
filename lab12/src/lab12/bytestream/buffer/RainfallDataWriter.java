package lab12.bytestream.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author mizan
 * Exercise 7
 */
public class RainfallDataWriter {
    public static void main(String[] args) {
        // Station data
        int[] stationIds = {2421003, 2322006, 2321006, 2222002};
        String[] stationNames = {"Simpang Ampat", "Melaka Pindah", "Ladang Lendu", "Durian Tunggal"};
        String[] districtNames = {"Alor Gajah", "Alor Gajah", "Alor Gajah", "Alor Gajah"};
        double[][] rainfallData = {
                {5.0, 0.0, 37.0, 3.0, 0.0, 1.0},
                {0.0, 0.0, 31.0, 3.0, 0.0, 0.5},
                {0.0, 0.0, 6.0, 1.0, 0.0, 0.0},
                {0.0, 1.5, 11.5, 7.0, 0.0, 0.0}

        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rainfall_data.txt"))) {
            // Write the number of stations and districts
            writer.write(String.valueOf(stationIds.length));
            writer.newLine();
            writer.write(String.valueOf(districtNames.length));
            writer.newLine();

            // Write station data
            for (int i = 0; i < stationIds.length; i++) {
                writer.write(String.valueOf(stationIds[i]));
                writer.newLine();
                writer.write(stationNames[i]);
                writer.newLine();
                writer.write(districtNames[i]);
                writer.newLine();

                // Write rainfall data
                for (int j = 0; j < rainfallData[i].length; j++) {
                    writer.write(String.valueOf(rainfallData[i][j]));
                    writer.newLine();
                }
            }

            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

