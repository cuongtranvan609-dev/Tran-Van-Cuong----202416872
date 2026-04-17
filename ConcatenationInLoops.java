package hust.soict.hedspi.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {

        // Tạo random để sinh dữ liệu
        Random r = new Random(123);

        // ===== TEST 1: Dùng String (+) =====
        long start = System.currentTimeMillis(); // bắt đầu đo thời gian

        String s = "";
        for (int i = 0; i < 65536; i++) {
            // Mỗi lần += sẽ tạo object String mới → tốn bộ nhớ
            s += r.nextInt(2);
        }

        // In thời gian chạy
        System.out.println("String time: " + (System.currentTimeMillis() - start));

        // ===== TEST 2: Dùng StringBuilder =====
        r = new Random(123); // reset lại random để công bằng
        start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            // append KHÔNG tạo object mới → nhanh hơn
            sb.append(r.nextInt(2));
        }

        s = sb.toString(); // chuyển sang String

        System.out.println("StringBuilder time: " + (System.currentTimeMillis() - start));
    }
}