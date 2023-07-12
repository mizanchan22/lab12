package lab12.bytestream.buffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author mizan
 * Exercise 7
 */
public class RainfallDataReader {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("rainfall_data.txt"))) {
            // Read the number of stations and districts
            int numStations = Integer.parseInt(reader.readLine());
            int numDistricts = Integer.parseInt(reader.readLine());

            System.out.println("Number of Stations: " + numStations);
            System.out.println("Number of Districts: " + numDistricts);

            System.out.println("\nStation Data:");

            // Read station data
            for (int i = 0; i < numStations; i++) {
                int stationId = Integer.parseInt(reader.readLine());
                String stationName = reader.readLine();
                String districtName = reader.readLine();

                System.out.println("\nStation ID: " + stationId);
                System.out.println("Station Name: " + stationName);
                System.out.println("District Name: " + districtName);

                System.out.println("Rainfall Data:");
                // Read and display rainfall data
                for (int j = 0; j < 6; j++) {
                    double rainfall = Double.parseDouble(reader.readLine());
                    System.out.println("Day " + (j + 1) + ": " + rainfall);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

