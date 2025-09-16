package Ngay2;

import java.util.*;

public class StudentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, String> studentMap = new HashMap<>();
        Map<Integer, List<String>> studentSubjects = new HashMap<>();
        Set<String> allSubjects = new HashSet<>();

        System.out.println("Nhap so luong sinh vien");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i =1; i <= n; i++) {
            System.out.println("Nhap ma sinh vien thu: " + i + ": ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Nhap ten sinh vien thuw: " + i + ": ");
            String name = sc.nextLine();

            System.out.println("Nhap danh sach mon hoc: ");
            String subjects = sc.nextLine();
            String[]  subjectsArray = subjects.split("\\s+");
            List<String> subjectList = new ArrayList<>();
            for (String s: subjectsArray) {
                String subject = s.trim();
                subjectList.add(subject);
                allSubjects.add(subject);
            }

            studentMap.put(id, name);
            studentSubjects.put(id, subjectList);
            
        }

        StringBuffer sb = new StringBuffer();
        for(String name: studentMap.values()) {
            sb.append(name).append(", ");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length()-2);
        }
        System.out.println("\n Danh sach sv: " + sb);

        System.out.println("\n Danh sach cac mon hoc: " + allSubjects);
        System.out.println("Nhap ma sv de xem mon hoc: ");
        int searchId = sc.nextInt();
        if(studentSubjects.containsKey(searchId)) {
            System.out.println("Mon hoc cua " + studentMap.get(searchId) + " gom co: " + studentSubjects.get(searchId));
        } else{
            System.out.println("Khong tim thay sinh vien nay");
        }

        //thong ke
        Map<String, Integer> topSubject =new HashMap<>();
        for (List<String> subjects : studentSubjects.values()) {
            for(String subject : subjects) {
                topSubject.put(subject, topSubject.getOrDefault(subject, 0) + 1);
            }
        }

        int maxCount = Collections.max(topSubject.values());
        System.out.print("\nMon hoc dc sv hoc nhieu nhat: ");
        for(Map.Entry<String, Integer> entry : topSubject.entrySet()) {
            if(entry.getValue() == maxCount) {
                System.out.print(entry.getKey() + " ");
            }
        }
        sc.close();
    }
}
