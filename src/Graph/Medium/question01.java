package Graph.Medium;
import  java.util.*;

public class question01 {
    public static void main(String[] args) {
        int V =5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       for (int i=0; i<V; i++){
           adj.add(new ArrayList<>());
       }
        int[][] edges= { { 1, 2 },{ 1, 0 },{ 2, 0 },{ 2, 3 },{ 2, 4 } };
       for (int edge[] : edges){
           addEdge(adj, edge[0], edge[1]);
       }
       ArrayList<Integer> res = DFS(adj);
       for (int i=0; i<res.size(); i++){
           System.out.print(res.get(i) + " ");
       }
    }
    public static void addEdge(ArrayList<ArrayList<Integer> > adj, int s, int t)
    {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }
    public static ArrayList<Integer> DFS(ArrayList<ArrayList<Integer> > adj)
    {
        boolean vis[] = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        dfsRec(adj, vis, 0, res);
        return res;
    }
    private static void dfsRec(ArrayList<ArrayList<Integer> > adj, boolean vis[],
                                int s,  ArrayList<Integer> res)
    {
        vis[s] = true;
        res.add(s);
        for (int i : adj.get(s)){
            if (!vis[i]){
                dfsRec(adj, vis, i, res);
            }
        }
    }
    static ArrayList<Integer> bfsDisconntecd(ArrayList<ArrayList<Integer>> adj)
    {
        int V = adj.size();
        boolean vis [] = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0; i<V; i++){
            if (!vis[i]){
                bfs(adj, i, vis, res);
            }
        }
        return res;
    }

    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int s,
                                  boolean vis[], ArrayList<Integer> res)
    {
        Queue<Integer> q = new LinkedList<>();
        vis[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            for (int x : adj.get(curr)){
                if (!vis[x]){
                    vis[x] = true;
                    q.add(x);
                }
            }
        }
        return res;
    }
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj)
    {
        int V = adj.size();
        int s=0;
        boolean vis[] = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        vis[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            for (int x : adj.get(curr)){
                if (!vis[x]){
                    vis[x] = true;
                    q.add(x);
                }
            }
        }
        return res;
    }
}
