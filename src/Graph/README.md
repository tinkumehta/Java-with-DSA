# Graph
A graph is a mathematical structure used to model pairwise relations between objects. It consists of two primary components: vertices (also called nodes) and edges (also called links).
- A graph G can be defined as an ordered pair (V,E) where:

- V is a set of vertices.
- E is a set of edges, where each edge is a pair of vertices from V.

# Types of graph
- An undirected graph is a type of graph in which the edges have no direction.
- A directed graph, also known as a digraph, is a type of graph where the edges have a direction.
- A weighted graph is a type of graph in which each edge is assigned a weight (or cost).
- Number of Edges in complete graphs with n vertices is n(n - 1)/2.
- A bipartite graph is a type of graph where the vertex set can be divided into two disjoint sets such that no two vertices within the same set are adjacent.
- A cycle graph, also known as a circular graph, is a type of graph that forms a single cycle.
- A tree is a type of graph that is connected and acyclic.
- An Eulerian graph is a graph in which there exists a trail, called an Eulerian trail, that visits every edge exactly once.
- A Hamiltonian graph is a graph that contains a Hamiltonian circuit, which is a cycle that visits each vertex exactly once and returns to the starting vertex.

 ## Topological sorting 
 Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u-v, vertex u comes before v in the ordering.

Note: Topological Sorting for a graph is not possible if the graph is not a DAG.