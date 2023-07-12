package lab12.bytestream.raw;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 
 * @author mizan
 * Exercise 6
 */

public class RainfallDataReader {
    public static void main(String[] args) {
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream("rainfall_data.bin"))) {
            // Read the number of stations and districts
            int numStations = inputStream.readInt();
            int numDistricts = inputStream.readInt();

            System.out.println("Number of Stations: " + numStations);
            System.out.println("Number of Districts: " + numDistricts);

            System.out.println("\nStation Data:");

            // Read station data
            for (int district = 1; district <= numDistricts; district++) {
                for (int station = 1; station <= numStations; station++) {
                    // Read station ID, name, district name
                    int stationId = inputStream.readInt();
                    String stationName = inputStream.readUTF();
                    String districtName = inputStream.readUTF();

                    System.out.println("\nStation ID: " + stationId);
                    System.out.println("Station Name: " + stationName);
                    System.out.println("District Name: " + districtName);

                    System.out.println("Rainfall Data:");
                    double totalRainfall = 0;
                    // Read and display rainfall data
                    for (int day = 1; day <= 6; day++) {
                        double rainfall = inputStream.readDouble();
                        totalRainfall += rainfall;
                        System.out.println("Day " + day + ": " + rainfall);
                    }
                    double averageRainfall = totalRainfall / 6;
                    System.out.println("Average Rainfall: " + averageRainfall);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

