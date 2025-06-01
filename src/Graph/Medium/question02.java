package Graph.Medium;

public class question02 {

    public static void main(String[] args) {
     question02 graph = new question02(3, 3);
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
        if (graph.cycle(graph) == 1) {
            System.out.println("Contains a cycle");
        } else {
            System.out.println("Not Contains cycle");
        }
    }
    int cycle(question02 graph)
    {
        int parent[] = new int[graph.V];
        for (int i=0; i<graph.V; i++){
            int x = find(parent, graph.edge[i].src);
            int y = find(parent, graph.edge[i].dest);
            if (x == y)
                return 1;
            graph.union(parent, x, y);
        }
        return 0;
    }
    void union(int parent[], int x, int y)
    {
        parent[x] = y;
    }
    int find(int parent[], int i)
    {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }
    question02(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; i++){
            edge[i] = new Edge();
        }
    }

    int V, E;
    Edge edge[];
    class Edge {
        int src, dest;
    }
}
