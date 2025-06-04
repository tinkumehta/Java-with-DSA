package Graph.Medium.GFG;

import java.util.ArrayList;
import java.util.List;

public class gfg {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                {0, 1}, {0, 2}, {0, 3}, {1, 2}, {3, 4}
        };
        if (isCycle(V, edges)){
            System.out.println("is Cycle");
        } else {
            System.out.println("No containe cycle");
        }
    }
    static boolean isCycle(int V, int edge[][])
    {
        List<Integer> adj[]= construcated(V, edge);
        for (int edges[] : edge){
            adj[edges[0]].add(edges[1]);
            adj[edges[1]].add(edges[0]);
        }
        boolean vis[] = new boolean[V];
        for (int u=0; u<V; u++){
            if (!vis[u]){
                if (isCycleUtile(u, adj, vis, -1))
                    return true;
            }
        }
        return false;
    }
    static boolean isCycleUtile(int v, List<Integer>adj[] , boolean vis[], int parent)
    {
        vis[v]= true;
        for (int  i : adj[v]){
            if (!vis[i]){
               if ( isCycleUtile(i, adj, vis, v))
                return true;
            }
            if (i != parent)
                return true;
        }
        return false;
    }
    static List<Integer>[] construcated(int V, int edge[][])
    {
        List<Integer> adj [] = new ArrayList [V];
        for (int i=0; i<V; i++){
            adj[i] = new ArrayList<>();
        }
        return adj;
    }
}
