package p1504;

import java.util.*;
import java.io.*;

public class Main {
	static final int INF = 987654321;
	static int N, E, v1, v2, route1, route2;
	static List[] graph;
	static int[] fromStart, fromV1, fromV2;

	static class Node implements Comparable<Node> {
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		fromStart = new int[N + 1];
		fromV1 = new int[N + 1];
		fromV2 = new int[N + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[from].add(new Node(to, weight));
			graph[to].add(new Node(from, weight));
		}

		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		dijkstra(fromStart, 1);
		dijkstra(fromV1, v1);
		dijkstra(fromV2, v2);

		if (fromStart[v1] == INF || fromV1[v2] == INF || fromV2[N] == INF) {
			route1 = INF;
		} else {
			route1 = fromStart[v1] + fromV1[v2] + fromV2[N];
		}

		if (fromStart[v2] == INF || fromV2[v1] == INF || fromV1[N] == INF) {
			route2 = INF;
		} else {
			route2 = fromStart[v2] + fromV2[v1] + fromV1[N];
		}

		int ans = route1 == INF && route2 == INF ? -1 : Math.min(route1, route2);

		bw.write(ans + "\n");
		bw.flush();
		br.close();
		bw.close();
	}

	static void dijkstra(int[] distance, int start) {
		Arrays.fill(distance, INF);

		PriorityQueue<Node> pq = new PriorityQueue<>();

		distance[start] = 0;
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (distance[cur.to] < cur.weight) {
				continue;
			}

			for (int i = 0; i < graph[cur.to].size(); i++) {
				Node next = (Node) graph[cur.to].get(i);

				if (distance[next.to] > cur.weight + next.weight) {
					distance[next.to] = cur.weight + next.weight;
					pq.add(new Node(next.to, distance[next.to]));
				}
			}
		}
	}
}
