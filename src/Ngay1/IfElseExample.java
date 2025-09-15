package Ngay1;

import java.util.Scanner;

public class IfElseExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập 'exit' để thoát chương trình.");

        while (true) {
            System.out.print("\nNhập màu đèn (đỏ/vàng/xanh): ");
            String trafficLight = sc.nextLine().trim();

            if (trafficLight.equalsIgnoreCase("exit")) {
                System.out.println("Thoát chương trình. Bye!");
                break;
            }

            System.out.print("Có người đi bộ không? (true/false): ");
            boolean isPedestrian;
            try {
                isPedestrian = sc.nextBoolean();
            } catch (Exception e) {
                System.out.println("Vui lòng nhập true hoặc false!");
                sc.nextLine();
                continue;
            }
            sc.nextLine();

            if (trafficLight.equals("đỏ")) {
                System.out.println("Dừng lại");
            } else if (trafficLight.equals("vàng")) {
                System.out.println("Đi chậm");
            } else if (trafficLight.equals("xanh")) {
                System.out.println("Đi tiếp");
            } else {
                System.out.println("Màu đèn không hợp lệ");
            }

            // 2. Kiểm tra điều kiện an toàn
            if (trafficLight.equals("xanh") && !isPedestrian) {
                System.out.println("Đi tiếp an toàn");
            } else if (trafficLight.equals("đỏ") || isPedestrian) {
                System.out.println("Dừng lại");
            } else {
                System.out.println("Kiểm tra lại điều kiện");
            }
        }

        sc.close();
    }
}
