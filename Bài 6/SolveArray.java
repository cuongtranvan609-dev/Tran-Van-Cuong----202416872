
import java.util.Scanner;
import java.util.Arrays;

public class SolveArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số phần tử
        System.out.print("Nhập số phần tử: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }

        // Sắp xếp
        Arrays.sort(arr);

        // In mảng sau khi sort
        System.out.println("Mảng sau sắp xếp: " + Arrays.toString(arr));

        // Tính tổng
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }

        // Tính trung bình
        double avg = (double) sum / n;

        // In kết quả
        System.out.println("Tổng = " + sum);
        System.out.println("Trung bình = " + avg);

        sc.close();
    }
}
