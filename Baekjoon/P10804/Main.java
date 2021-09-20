package P10804;

import java.util.*;

public class Main {
    static int A, B;
    static int[] arr;
    static List<Integer> list;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[21];
        list = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            A = sc.nextInt();
            B = sc.nextInt();

            for (int j = A; j <= B; j++) {
                list.add(arr[j]);
            }

            for (int j = A; j <= B; j++) {
                arr[j] = list.remove(list.size() - 1);
            }
        }

        for (int i = 1; i <= 20; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
