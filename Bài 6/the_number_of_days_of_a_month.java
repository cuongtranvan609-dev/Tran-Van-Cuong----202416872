package Lession5;

import java.util.Scanner;

public class the_number_of_days_of_a_month {

    public static int getMonthNumber(String input) {
        input = input.toLowerCase().replace(".", "");

        switch (input) {
            case "1": case "jan": case "january": return 1;
            case "2": case "feb": case "february": return 2;
            case "3": case "mar": case "march": return 3;
            case "4": case "apr": case "april": return 4;
            case "5": case "may": return 5;
            case "6": case "jun": case "june": return 6;
            case "7": case "jul": case "july": return 7;
            case "8": case "aug": case "august": return 8;
            case "9": case "sep": case "sept": case "september": return 9;
            case "10": case "oct": case "october": return 10;
            case "11": case "nov": case "november": return 11;
            case "12": case "dec": case "december": return 12;
            default: return -1;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month, year;

        // Nhập tháng
        while (true) {
            System.out.print("Enter month: ");
            String input = sc.nextLine();
            month = getMonthNumber(input);

            if (month != -1) break;
            System.out.println("Invalid month. Try again.");
        }

        // Nhập năm
        while (true) {
            System.out.print("Enter year: ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year >= 0) break;
            } else {
                sc.next(); // bỏ input sai
            }
            System.out.println("Invalid year. Try again.");
        }

        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

        if (month == 2 && isLeapYear(year)) {
            System.out.println("Days: 29");
        } else {
            System.out.println("Days: " + days[month - 1]);
        }

        sc.close();
    }
}