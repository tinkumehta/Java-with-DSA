package Graph.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Question1 {

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
       // bfs(graph, V);
      int src =0, tar =5;
      boolean vis[] = new boolean[V];
      vis[src] = true;
      printAllPaths(graph, src, tar, ""+src, vis);
    }
    // All paths
    static void printAllPaths(ArrayList<Edge> graph[], int src, int tar, String path, boolean vis[])
    {
        if (src == tar) {
            System.out.println(path);
            return;
        }
        for (int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if (!vis[e.dest]){
                vis[e.dest] = true;
                printAllPaths(graph, e.dest, tar, path+"->"+e.dest, vis);
                vis[e.dest] = false;
            }
        }
    }
    static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[])
    {
        if (vis[curr]){
            return;
        }
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            dfs(graph, e.dest, vis);
        }
    }
    static void bfs(ArrayList<Edge> graph[], int V)
    {
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]){
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    static void createGraph(ArrayList<Edge> graph[])
    {
        for (int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));
    }

    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s, int d, int w)
        {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

}
