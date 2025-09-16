package Ngay2.StringBuffer;

public class Bai2 {
    public static void main( String[] args ) {
        StringBuffer sb = new StringBuffer("Hello");

        sb.append(" World");
        sb.insert(5, " Long");
        sb.delete(10, 16);

        System.out.println(sb);
    }
}
