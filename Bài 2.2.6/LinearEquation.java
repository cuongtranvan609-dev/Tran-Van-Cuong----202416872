

import javax.swing.JOptionPane;

public class LinearEquation {
    public static void main(String[] args) {
        // Nhập dữ liệu từ hộp thoại
    	
        String strA = JOptionPane.showInputDialog("Hãy nhập a:");
        String strB = JOptionPane.showInputDialog("Hãy nhập b:");

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);

        String message;

        if (a == 0) {
            if (b == 0) {
                message = "Phương trình có vô số nghiệm.";
            } else {
                message = "Phương trình vô nghiệm.";
            }
        } else {
            double x = -b / a;
            message = "Phương trình có nghiệm duy nhất là: x = " + x;
        }

      
        JOptionPane.showMessageDialog(null, message);
    }
}
