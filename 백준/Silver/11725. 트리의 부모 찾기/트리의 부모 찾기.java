import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<List<Integer>> graph = new ArrayList<>();
    for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
    for(int i=0; i<n-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    int[] visited = new int[n+1];
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.offer(1);
    visited[1] = 1;
    while(!q.isEmpty()) {
      int now = q.poll();
      for(int next: graph.get(now)) {
        if(visited[next]>0) continue;
        visited[next] = now;
        q.offer(next);
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i=2; i<=n; i++) {
      sb.append(visited[i]).append('\n');
    }
    System.out.println(sb);
  }
}
