package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {

        // Đường dẫn file (nên dùng file lớn để thấy rõ hiệu quả)
        String filename = "test.txt";

        // Đọc toàn bộ file thành mảng byte
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        long startTime = System.currentTimeMillis(); // bắt đầu đo

        String outputString = "";

        for (byte b : inputBytes) {
            // Mỗi lần += tạo String mới → sinh ra rất nhiều object (garbage)
            outputString += (char) b;
        }

        long endTime = System.currentTimeMillis(); // kết thúc đo

        // In thời gian xử lý
        System.out.println("Time (String +): " + (endTime - startTime));
    }
}