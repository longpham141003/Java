package Ngay2.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> studentMap = new HashMap<>();

        System.out.print("nhap so luong hoc sinh: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("nhap ma hoc sinh thu n " + i + ": ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("nhap ten hoc sinh thu n " + i + ": ");
            String name = sc.nextLine();

            studentMap.put(id, name);
        }

        System.out.println("\nDanh sach hoc sinh:");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("ma: " + entry.getKey() + ", ten: " + entry.getValue());
        }

        sc.close();
    }
}
