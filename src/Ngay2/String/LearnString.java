package Ngay2.String;

import java.util.*;

public class LearnString {
    private static Map<Integer, Runnable> exercises = new HashMap<>();
    private static Map<Integer, String> exerciseNames = new HashMap<>();

    public static void bai1(Scanner sc) {
        System.out.println("\nBai1: Su dung replace");
        System.out.println("Nhap chuoi: ");
        String str = sc.nextLine();

        if(str.contains("a")) {
            String step1 = str.replace("a", "@");
            System.out.println("Da doi a thanh @: " + step1);
        } else {
            System.out.println("Khong co a");
        }

        String step2 = str.replace(" ", "_");
        System.out.println("Da doi khoang trang: " + step2);

        String text = "Ten toi la hieu sinh nam 2003";
        String step4 = text.replaceAll("\\d+", "#");
        System.out.println("Thay so bang #: " + step4);

    }

    public static void bai2(Scanner sc) {
        System.out.println("\nBai2: Su dung toLowerCase, toUpperCase");
        System.out.println("Nhap chuoi thu nhat: ");
        String str1 = sc.nextLine();
        System.out.println("Nhap chuoi thu hai: ");
        String str2 = sc.nextLine();

        String clean1 = str1.trim().toLowerCase();
        System.out.println("Chuoi thu nhat sau khi toLowerCase: " + clean1);
        String clean2 = str2.trim().toLowerCase();
        System.out.println("Chuoi thu hai sau khi toLowerCase: " + clean2);
        String clean3 = str1.trim().toUpperCase();
        System.out.println("Chuoi thu nhat sau khi toUpperCase: " + clean3);
        String clean4 = str2.trim().toUpperCase();
        System.out.println("Chuoi thu hai sau khi toUpperCase: " + clean4);

        if (clean1.equals(clean2) || clean3.equals(clean4)) {
            System.out.println("Hai chuoi giong nhau");
        } else {
            System.out.println("Hai chuoi khac nhau");
        }
    }

    public static void bai3(Scanner sc) {
        System.out.println("\nBai3: Su dung trim");
        System.out.println("Nhap danh sach ten: ");
        String str = sc.nextLine();

        String[] names = str.split(",");

        System.out.println("Danh sach sau khi tach: ");
        for(String ten: names) {
            String clean = ten.trim();
            System.out.println(clean);
        }
    }

    public static void bai4(Scanner sc) {
        System.out.println("\nBai4: Su dung charAt: ");
        System.out.println("Nhap chuoi: ");
        String str = sc.nextLine();

        int chu = 0, so = 0, kitudacbiet = 0, khoangtrang = 0;

        for( int i = 0; i < str.length(); i++ ) {
            char ch = str.charAt(i);

            if(Character.isLetter(ch)) {
                chu++;
            }
            else if(Character.isDigit(ch)) {
                so++;
            }
            else if(Character.isWhitespace(ch)) {
                khoangtrang++;
            }else {
                kitudacbiet++;
            }
        }
        System.out.println("So chu cai: " + chu);
        System.out.println("So chu so: " + so);
        System.out.println("So khoang trang: " + khoangtrang);
        System.out.println("So ky tu dac biet: " + kitudacbiet);
    }

    public static void bai5(Scanner sc) {
        System.out.println("\nBai5: Su dung indexOf: ");
        System.out.println("Nhap doan van: ");
        String text = sc.nextLine();

        System.out.println("Tu khoa can tim kiem: ");
        String keyword = sc.nextLine();

        String newText = text.toLowerCase();
        String newKey = keyword.toLowerCase();

        int k = newText.indexOf(newKey);

        if (k == -1) {
            System.out.println("Khong tim thay tu khoa");
            return;
        }

        System.out.println("Vi tri xuat hien cua tu khoa:");
        while (k != -1) {
            System.out.println(" - tai vi tri: " + k);
            k = newText.indexOf(newKey, k + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        exercises.put(1, () -> bai1(sc));
        exerciseNames.put(1, "Su dung replace");

        exercises.put(2, () ->bai2(sc));
        exerciseNames.put(2, "Su dung toLowerCase, toUpperCase");

        exercises.put(3, () ->bai3(sc));
        exerciseNames.put(3, "Su dung trim");

        exercises.put(4, () ->bai4(sc));
        exerciseNames.put(4, "Su dung charAt");

        exercises.put(5, () ->bai5(sc));
        exerciseNames.put(5, "Su dung indexOf");

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            for (int key : exercises.keySet()) {
                System.out.println(key + " - " + exerciseNames.get(key));
            }
            System.out.println("0 - Thoat");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) {
                System.out.println("Thoat chuong trinh.");
            } else if (exercises.containsKey(choice)) {
                exercises.get(choice).run();
            } else {
                System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 0);

        sc.close();
    }
}
