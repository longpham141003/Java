package Ngay2.StringBuffer;

public class Bai3 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("abyu23g4yu324");
        int sum = 0;

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        System.out.println("Tổng các số: " + sum);
    }
}
