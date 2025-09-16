package Ngay2.StringBuffer;

public class Bai1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Pham Quang Long");

        sb.reverse();

        for (int i = 0; i < sb.length(); i++) {
            if( sb.charAt(i) == 'o' ) {
                sb.setCharAt(i, '@');
            }
        }

        System.out.println(sb);
    }
}
