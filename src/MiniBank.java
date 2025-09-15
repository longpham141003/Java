import java.util.Scanner;

public class MiniBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 1000;
        String[] history = new String[100];
        int historyCount = 0;

        boolean running = true;
        do {
            System.out.println("1.xem so du");
            System.out.println("2.gui tien");
            System.out.println("3.rut tien");
            System.out.println("4.lich su giao dich");
            System.out.println("5.thoat");
            System.out.println("Chon chuc nang:");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("So du: " + balance);
                    break;
                case 2:
                    System.out.println("nhap so tien gui: ");
                    double deposit = sc.nextDouble();
                    sc.nextLine();
                    if( deposit>0 ) {
                        balance += deposit;
                        history[historyCount++] = "da gui: " + deposit;
                        System.out.println("Ban da gui tien thanh cong!");
                    } else {
                        System.out.println("so tien khong hop le");
                    }
                    break;
                case 3:
                    System.out.println("nhap so tien rut: ");
                    double withdraw = sc.nextDouble();
                    sc.nextLine();
                    if( withdraw > 0 && withdraw <= balance ) {
                        balance -= withdraw;
                        history[historyCount++] = "rut " + withdraw;
                        System.out.println("Rut thanh cong!");
                    } else {
                        System.out.println("so tien khong hop le or vuot qua so du hien co");
                    }
                    break;
                case 4:
                    System.out.println("Lich su giao dich");
                    for(int i=0; i<historyCount; i++) {
                        System.out.println(history[i]);
                    }
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh...");
                    running = false;
                    break;
                default:
                    System.out.println("lua chon khong hop le");
            }
        } while (running);
        sc.close();
    }
}
