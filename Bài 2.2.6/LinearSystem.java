package LAB01_2403;

import javax.swing.JOptionPane;

public class LinearEquation1 {
    public static void main(String[] args) {
        // Nhập dữ liệu từ hộp thoại
        String strA11 = JOptionPane.showInputDialog("Nhập a11:");
        String strA12 = JOptionPane.showInputDialog("Nhập a12:");
        String strB1  = JOptionPane.showInputDialog("Nhập b1:");

        String strA21 = JOptionPane.showInputDialog("Nhập a21:");
        String strA22 = JOptionPane.showInputDialog("Nhập a22:");
        String strB2  = JOptionPane.showInputDialog("Nhập b2:");

        double a11 = Double.parseDouble(strA11);
        double a12 = Double.parseDouble(strA12);
        double b1  = Double.parseDouble(strB1);

        double a21 = Double.parseDouble(strA21);
        double a22 = Double.parseDouble(strA22);
        double b2  = Double.parseDouble(strB2);

        // Tính các định thức
        double D  = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        String message;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                message = "Hệ phương trình có vô số nghiệm.";
            } else {
                message = "Hệ phương trình vô nghiệm.";
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            message = "Hệ phương trình có nghiệm duy nhất:\n"
                    + "x1 = " + x1 + "\n"
                    + "x2 = " + x2;
        }

     
        JOptionPane.showMessageDialog(null, message);
    }
}