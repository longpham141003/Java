package Ngay2.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bai3 {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Chuoi"); fruits.add("Tao"); fruits.add("Xoai");
        Collections.sort(fruits);
        System.out.println("Sau khi sap xep: " + fruits);

        List<Integer> nums = new ArrayList<>();
        nums.add(10); nums.add(20); nums.add(30); nums.add(40); nums.add(50);
        List<Integer> subList = nums.subList(1,3);
        System.out.println("Sublist index 1→3: " + subList);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1); list1.add(2); list1.add(3); list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3); list2.add(4); list2.add(5); list2.add(6);
        list1.retainAll(list2);
        System.out.println("ptu chung giua list1 va list2: " + list1);
    }
}
