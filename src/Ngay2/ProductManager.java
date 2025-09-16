package Ngay2;

import java.util.*;

public class ProductManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, String> productName = new HashMap<>();
        Map<Integer, Double> productPrice = new HashMap<>();
        Map<Integer, List<String>> productCategories = new HashMap<>();
        Set<String> allCategories = new HashSet<>();

        System.out.println("Nhap so luong san pham: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= n; i++) {
            System.out.println("Nhap ma san pham thu " + i + ": ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Nhap ten san pham thu: " + i + ": ");
            String name = sc.nextLine();

            System.out.println("Nhap gia san pham: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.println("Nhap danh sach loai(,): ");
            String categories = sc.nextLine();
            String[] categoriesArray = categories.split(",");
            List<String> categoriesList = new ArrayList<>();
            for(String category : categoriesArray) {
                String c = category.trim();
                categoriesList.add(c);
                allCategories.add(c);
            }

            productName.put(id, name);
            productPrice.put(id, price);
            productCategories.put(id, categoriesList);
        }

        System.out.println("\nDanh sach sp: ");
        for( int id: productName.keySet()) {
            System.out.println("Ma: " + id + ", Ten: " + productName.get(id) + ", gias: " + productPrice.get(id) + ", loai: " + productCategories.get(id));
        }

        StringBuffer sb = new StringBuffer();
        for(String name: productName.values()) {
            sb.append(name).append(", ");
        }
        if(sb.length() > 0) sb.setLength(sb.length() - 2);
        System.out.println("\nTen san pham: " +sb);

        Map<String, Integer> topCategory = new HashMap<>();
        for(List<String> categories : productCategories.values()) {
            for(String c: categories) {
                topCategory.put(c, topCategory.getOrDefault(c, 0) + 1);
            }
        }

        int maxCount = Collections.max(topCategory.values());
        System.out.print("\nLoai sp nhieu sp nhat: ");
        for(Map.Entry<String, Integer> entry : topCategory.entrySet()) {
            if(entry.getValue() == maxCount) {
                System.out.print(entry.getKey() + " ");
            }
        }

        sc.close();
    }
}











