package Graph.Easy;

import java.util.ArrayList;

public class TarjanAlgorithm {

    public static void main(String[] args) {

    }
    public static void getArticulation(ArrayList<Edge> graph[], int V)
    {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time =0;
        boolean vis[] = new boolean[V];
        boolean isArticulation [] = new boolean[V];
        for (int i=0; i<V; i++){
            if (!vis[i]){
                dfs(graph, i, -1, vis, dt, low, time, isArticulation);
            }
        }
        for (int i=0; i<V; i++){
            if (isArticulation[i]){
                System.out.println(i);
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[], int curr, int par, boolean vis [] ,
                           int dt[], int low[], int time, boolean isArticulation[])
    {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int child =0;

        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (e.dest == par)
                continue;
            if (vis[e.dest]){
                low[curr] = Math.min(low[curr], dt[e.dest]);
            } else  {
                dfs(graph, e.dest, curr, vis, dt, low, time, isArticulation);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (dt[curr] <= low[e.dest] && par != -1) {
                    isArticulation[curr] = true;
                }
                child++;
            }
        }
        if (par == -1 && child > 1) {
            isArticulation[curr] = true;
        }
    }

    static class Edge{
        int src;
        int dest;
        Edge (int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

}
