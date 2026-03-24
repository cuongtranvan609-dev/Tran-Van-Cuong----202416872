
import javax.swing.JOptionPane;

public class DoubleNumbers {
    public static void main(String[] args) {
        
        String strNum1 = JOptionPane.showInputDialog("Nhập số thứ nhất:");
        String strNum2 = JOptionPane.showInputDialog("Nhập số thứ hai:");

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        // Tính toán
        double tong = num1 + num2;
        double hieu = num1 - num2;
        double nhan = num1 * num2;

        String message = "Tổng: " + tong + "\n"
                       + "Hiệu: " + hieu + "\n"
                       + "Nhân: " + nhan + "\n";

        if (num2 != 0) {
            double chia = num1 / num2;
            message += "Chia: " + chia;
        } else {
            message += "Chia: Lỗi! Không thể chia cho 0.";
        }

        // Hiển thị kết quả bằng hộp thoại
        JOptionPane.showMessageDialog(null, message);
    }
}
