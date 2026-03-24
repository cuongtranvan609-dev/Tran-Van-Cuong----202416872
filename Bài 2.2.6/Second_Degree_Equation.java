
import javax.swing.JOptionPane;

public class LinearEquation2 {
    public static void main(String[] args) {
       
        String strA = JOptionPane.showInputDialog("Nhập hệ số a:");
        String strB = JOptionPane.showInputDialog("Nhập hệ số b:");
        String strC = JOptionPane.showInputDialog("Nhập hệ số c:");

        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        double c = Double.parseDouble(strC);

        String message;

        if (a == 0) {
            double x0=-c/b ;
            message = "Phương trình bậc nhất có giá trị" + " x =" + x0  ;
        } else {
            double delta = b * b - 4 * a * c;

            if (delta < 0) {
                message = "Phương trình vô nghiệm.";
            } else if (delta == 0) {
                double x = -b / (2 * a);
                message = "Phương trình có nghiệm kép: x = " + x;
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                message = "Phương trình có 2 nghiệm phân biệt:\n"
                		+ "x1 = " + x1 + "\n"
                        + "x2 = " + x2;
            }
        }

        JOptionPane.showMessageDialog(null, message);
    }
}
