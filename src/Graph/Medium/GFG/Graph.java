package Graph.Medium.GFG;

import java.util.ArrayList;
import java.util.Arrays;

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

    public static void main(String[] args) {
        String[] arr3 = {"ab", "bc", "cd", "da"};
        System.out.println(isCricle(arr3) == 1 ? "Yes" : "No");
    }
}










