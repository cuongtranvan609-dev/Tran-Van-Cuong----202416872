package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException {

        String filename = "test.txt";

        // Đọc file
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        long startTime = System.currentTimeMillis();

        // Dùng StringBuffer để giảm tạo object
        StringBuffer outputStringBuffer = new StringBuffer();

        for (byte b : inputBytes) {
            // append không tạo String mới → giảm garbage
            outputStringBuffer.append((char) b);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Time (StringBuffer): " + (endTime - startTime));
    }
}