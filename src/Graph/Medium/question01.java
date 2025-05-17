package Graph.Medium;
import  java.util.*;

public class question01 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(4)));
        adj.add(new ArrayList<>(Arrays.asList(3, 5)));
        adj.add(new ArrayList<>(Arrays.asList(4)));

        ArrayList<Integer> ans = bfsDisconntecd(adj);
        for (int i : ans){
            System.out.print(i + " ");
        }
        System.out.println();
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
