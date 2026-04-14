package LAB01_2403;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class testdemo {
	public static void main(String[] args) {
		String strNum1, strNum2;
		String strNotification = "You've just entered: ";
		
		strNum1 = JOptionPane.showInputDialog(null,
				"Please input the first double number: ", "Input the first number",
				JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum1 + " and ";
		if (strNum1 == null) System.exit(0);
		
		strNum2 = JOptionPane.showInputDialog(null,
				"Please input the second double number: ", "Input the second number",
				JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum2;
		if (strNum2 == null) System.exit(0);
		
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		
		double sum = num1 + num2;
		double difference = num1 - num2;
		double product = num1 * num2;
		
		String result = "\nSum = " + sum 
				+ "\nDifference = " + difference 
				+ "\nProduct = " + String.format("%.4f", product);
		
		if (num2 == 0) {
			result += "\nCan't divide by zero";
		}
		else {
			double quotient = num1/num2;
			result += "\nQuotient = " + String.format("%.4f", quotient);;
		}
		
		JOptionPane.showMessageDialog(null, strNotification + result ,
				"Show calculation", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}