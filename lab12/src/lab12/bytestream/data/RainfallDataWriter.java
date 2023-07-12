package lab12.bytestream.data;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author mizan
 * Exercise 5
 */
public class RainfallDataWriter {
	public static void main(String[] args) {
        String fileName = "rainfall_data.bin";
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName));
            
            // Day 1
            dataOutputStream.writeInt(1);
            dataOutputStream.writeDouble(5.0);

            // Day 2
            dataOutputStream.writeInt(2);
            dataOutputStream.writeDouble(0.0);

            // Day 3
            dataOutputStream.writeInt(3);
            dataOutputStream.writeDouble(37.0);

            // Day 4
            dataOutputStream.writeInt(4);
            dataOutputStream.writeDouble(3.0);

            // Day 5
            dataOutputStream.writeInt(5);
            dataOutputStream.writeDouble(0.0);

            // Day 6
            dataOutputStream.writeInt(6);
            dataOutputStream.writeDouble(1.0);

            dataOutputStream.close();
            System.out.println("Data creation has ended. File created: " + fileName);
        } catch (IOException e) {
            System.err.println("Error creating data file: " + e.getMessage());
        }
    }
}


