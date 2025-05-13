package Graph.Easy;

import java.util.ArrayList;

public class Question2 {

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph [] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }

    public static boolean isCycle(ArrayList<Edge> graph[])
    {
        boolean vis[] = new boolean[graph.length];
        for (int i=0; i< graph.length; i++){
            if (vis[i] == false) {
                boolean cycle = isCyclicUtils(graph, i, vis, new boolean[vis.length]);
                if (cycle) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCyclicUtils(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[])
    {
        vis[curr] = true;
        stack[curr] = true;
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (stack[e.dest]){
                // cycle exists
                return true;
            } else if (!vis[e.dest] && isCyclicUtils(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public static boolean isCyclic(ArrayList<Edge> graph[], boolean vis[])
    {
        for (int i=0; i< graph.length; i++){
            if (isCycleUtils(graph, vis, i, -1)){
                return true;
            }
        }
        return false;
    }
    public static boolean isCycleUtils(ArrayList<Edge> graph[], boolean vis[], int curr, int par)
    {
        vis[curr] = true;
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (vis[e.dest] && e.dest != par){
                boolean isCycle = isCycleUtils(graph, vis, e.dest, curr);
                if (isCycle) return true;
            } else if (e.dest == par) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }
    public static void createGraph(ArrayList<Edge> graph[])
    {
        for (int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }
       graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

}
