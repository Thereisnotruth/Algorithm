package p2110;

import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int[] house;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        // 거리를 이분 탐색, C개의 공유기를 놓을 수 있는 경우 중 최대가 되는 거리를 찾는다.

        int start = 1; // 최소 거리: 1

        int end = house[N - 1] - house[0] + 1; // 최대 거리: 처음 집과 끝 집 사이의 거리

        while (start < end) {
            int middle = (start + end) / 2;

            if (numOfInstall(middle) < C) {
                // 최소 middle 만큼의 간격을 두었을 때 설치할 수 있는 공유기의 수가 C보다 작으면 간격을 줄인다.
                end = middle;
            } else {
                // 최소 middle 만큼의 간격을 두었을 때 설치할 수 있는 공유기의 수가 C보다 크거나 같으면 간격을 넓힌다.
                start = middle + 1;
            }
        }

        bw.write(String.valueOf(end - 1));
        bw.flush();
        br.close();
        bw.close();
    }

    static int numOfInstall(int distance) {
        int count = 1;
        int prevHouse = house[0];

        for (int i = 1; i < N; i++) {
            if (house[i] - prevHouse >= distance) {
                count++;
                prevHouse = house[i];
            }
        }

        return count;
    }
}
