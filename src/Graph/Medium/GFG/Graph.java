package Graph.Medium.GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    int V;
    ArrayList<Integer> adj[];
    int in[];

    Graph(int V)
    {
        this.V = V;
        adj = new ArrayList[V];
        in = new int[V];
        for (int i=0; i<V; i++){
            adj[i] = new ArrayList<>();
        }
    }

    static void addEdge(Graph g, int v, int w)
    {
        g.adj[v].add(w);
        g.in[w]++;
    }
    static void dfsUtils(Graph g, int v, boolean vis[])
    {
        vis[v] = true;
        for (int i : g.adj[v]){
            if (!vis[i])
                dfsUtils(g, i, vis);
        }
    }
    static boolean isStrongConnectedComponets(Graph g)
    {
        boolean vis[] = new boolean[g.V];
        int n;
        for (n =0; n<g.V; n++)
            if (g.adj[n].size() > 0)
                break;
        if (n == g.V)
            return true;
        dfsUtils(g, n, vis);
        for (int i=0; i<g.V; i++)
            if (g.adj[i].size() > 0 && !vis[i])
                return false;

        Graph gr = new Graph(g.V);
        for (int v=0; v<g.V; v++){
            for (int i : g.adj[v]){
                gr.adj[i].add(v);
                gr.in[v]++;
            }
        }
        Arrays.fill(vis, false);
        dfsUtils(g, n, vis);

        for (int i=0; i<g.V; i++)
            if (g.adj[i].size() > 0 && !vis[i])
                return false;
        return true;
    }
    static boolean hasEulerianCycle(Graph g)
    {
        if (!isStrongConnectedComponets(g))
            return false;
        for (int i=0; i<g.V; i++){
            if (g.adj[i].size() != g.in[i])
                return false;
        }
        return true;
    }
    static int isCricle(String []arr)
    {
        Graph g = new Graph(26);
        for (String s : arr){
            if (!s.isEmpty()){
                addEdge(g, s.charAt(0) - 'a', s.charAt(s.length() -1) - 'a');
            }
        }
        return hasEulerianCycle(g) ? 1 : 0;
    }

    static final int N =6;
    static final int M =6;

    static boolean bpm(boolean bpGraph[][], int u, boolean [] isSeen, int mathcR[])
    {
        for (int v=0; v<N; v++){
            if (bpGraph[u][v] && !isSeen[v]){
                isSeen[v] = true;
                if (mathcR[v] < 0 || bpm(bpGraph, mathcR[v], isSeen, mathcR)){
                    mathcR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
    static int maxBpm(boolean bpGraph[][])
    {
        int matchR[] = new int[N];
        for (int u=0; u<N; u++){
            matchR[u] = -1;
        }
        int result =0;
        for (int u=0; u<M; u++){
            boolean seen[] = new boolean[N];
            for (int i=0; i<N; i++)
                seen[i] = false;
            if (bpm(bpGraph, u, seen, matchR))
                result++;
        }
        return result;
    }
    private static boolean isCycleUtil(List<Integer> adj[], int u, boolean vis[], boolean recStack[])
    {
        if (recStack[u])
            return true;
        if (vis[u])
            return false;
        vis[u] = true;
        recStack[u] = true;
        for (int v : adj[u]){
            if (isCycleUtil(adj, v, vis, recStack))
                return true;
        }
        // backtracking
        recStack[u] = false;
        return false;
    }
    private static List<Integer>[] constructe(int V, int edges[][])
    {
        List<Integer> adj[] = new List[V];
        for (int i=0; i<V; i++){
            adj[i] = new ArrayList<>();
        }
        for (int edge[] : edges){
            adj[edge[0]].add(edge[1] );
        }
        return adj;
    }
    private static boolean isCycle(int V, int edges[][])
    {
        List<Integer> adj[] = constructe(V, edges);
        boolean vis[] = new boolean[V];
        boolean rec[] = new boolean[V];
        for (int i=0; i<V; i++){
            if (!vis[i] && isCycleUtil(adj, i, vis, rec))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 2 },
                { 2, 0 },
                { 2, 3 }
        };
        int V = 4;
        System.out.println(isCycle(V, edges) ? "true" : "false");
    }
}










