package Graph.Easy;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        kosaraju(graph, v);
    }
    public static void getBridge(ArrayList<Edge> graph[], int V)
    {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time =0;
        boolean vis[] = new boolean[V];

        for (int i=0; i<V; i++){
            if (!vis[i]){
                dfs(graph, i, -1, vis, dt, low, time);
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[], int curr, int par, boolean vis[],
                           int dt[], int low[], int time)
    {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (e.dest == par)
                continue;
            if (vis[e.dest]){
                low[curr] = Math.min(low[curr], dt[e.dest]);
            } else {
                dfs(graph, e.dest, curr, vis, dt, low, time);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (dt[curr] < low[e.dest]){
                    System.out.println("BRIDGE :" + curr + "---" + e.dest);
                }
            }
        }
    }
    public static void kosaraju(ArrayList<Edge> graph[], int V)
    {
        // step1
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i=0; i<V; i++){
            if (!vis[i]){
                topSort(graph, i, s, vis);
            }
        }
        // step2
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i=0; i<V; i++){
            transpose[i] = new ArrayList<>();
        }
        for (int i=0; i<V; i++){
            vis[i] = false;
            for (int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        // stepe3
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]){
                System.out.print("SCC :");
                dfs(graph, vis, curr);
                System.out.println();
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[], boolean vis[], int curr)
    {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                dfs(graph, vis, e.dest);
            }
        }
    }
    public static void topSort(ArrayList<Edge> graph[], int curr, Stack<Integer> s, boolean vis[])
    {
        vis[curr] = true;
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                topSort(graph, e.dest, s, vis);
            }
        }
        s.push(curr);
    }
    public static void createGraph(ArrayList<Edge> graph[])
    {
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }
    static class Edge {
        int src;
        int dest;
        Edge (int s, int d)
        {
            this.src = s;
            this.dest = d;
        }
    }

}
