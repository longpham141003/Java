package Ngay2.List;

import java.util.ArrayList;
import java.util.List;

public class Bai1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1); list.add(2); list.add(3); list.add(4);
        list.add(2,10);
        list.remove(2);
        list.remove(Integer.valueOf(4));
        System.out.println(list);
    }
}
