package Graph.Easy;

import java.util.ArrayList;
import java.util.Stack;

public class Question2 {

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph [] = new ArrayList[V];
        createGraph(graph);
       // System.out.println(isCycle(graph));
        topoSort(graph);
    }
    public static void topoSort(ArrayList<Edge> graph[])
    {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i=0; i< graph.length; i++){
            if (!vis[i]){
                topoSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
    public static void topoSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s)
    {
        vis[curr] = true;
        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                topoSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
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


        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
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
