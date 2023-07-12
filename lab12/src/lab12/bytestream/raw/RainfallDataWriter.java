package lab12.bytestream.raw;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author mizan
 * Exercise 6
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

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("rainfall_data.bin"))) {
            // Write the number of stations and districts
            outputStream.writeInt(stationIds.length);
            outputStream.writeInt(districtNames.length);

            // Write station data
            for (int i = 0; i < stationIds.length; i++) {
                outputStream.writeInt(stationIds[i]);
                outputStream.writeUTF(stationNames[i]);
                outputStream.writeUTF(districtNames[i]);

                // Write rainfall data
                for (int j = 0; j < rainfallData[i].length; j++) {
                    outputStream.writeDouble(rainfallData[i][j]);
                }
            }

            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

