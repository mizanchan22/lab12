package lab12.bytestream.data;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 
 * @author mizan
 * Exercise 5
 */
public class RainfallDataReader {
	public static void main(String[] args) {
        String fileName = "rainfall_data.bin";
        int numDays = 6;
        double totalRainfall = 0;

        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileName));

            for (int i = 0; i < numDays; i++) {
                int day = dataInputStream.readInt();
                double rainfall = dataInputStream.readDouble();

                totalRainfall += rainfall;
                System.out.println("Day " + day + ": " + rainfall + "mm");
            }

            dataInputStream.close();

            double averageRainfall = totalRainfall / numDays;
            System.out.println("Average Rainfall: " + averageRainfall + "mm");
        } catch (IOException e) {
            System.err.println("Error reading data file: " + e.getMessage());
        }
    }
}

