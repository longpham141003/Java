package Ngay2.List;

import java.util.List;
import java.util.ArrayList;

public class Bai2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);

        list.add(2, 10);

        list.remove(Integer.valueOf(4));

        System.out.println("Kết quả sau khi thêm/xóa: " + list);

        System.out.println("Duyệt:");
        for(Integer num : list){
            System.out.println(num);
        }

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
