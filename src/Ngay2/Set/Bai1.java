package Ngay2.Set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so luong hoc sinh: ");
        int n = sc.nextInt();
        sc.nextLine();

        Set<String> students = new HashSet<>();

        for (int i=1; i<=n; i++) {
            System.out.println("Nhap ten hoc sinh thu " + i+ ": ");
            String name = sc.nextLine();
            students.add(name);
        }

        System.out.println("\n Danh sach hoc sinh khong trung");
        for(String s : students) {
            System.out.println(s);
        }

        sc.close();
    }
}
