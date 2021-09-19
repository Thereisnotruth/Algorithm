package P2587;

import java.util.*;

public class Main {
    static List<Integer> list;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        int avg = 0;

        for (int i = 0; i < 5; i++) {
            int tmp = sc.nextInt();
            list.add(tmp);
            avg += tmp;
        }
        Collections.sort(list);

        System.out.println(avg / 5);
        System.out.println(list.get(2));
        
    }
}
