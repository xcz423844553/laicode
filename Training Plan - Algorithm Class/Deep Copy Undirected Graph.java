/*
Make a deep copy of an undirected graph, there could be cycles in the original graph.

Assumptions

The given graph is not null
*/

/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/

//Solution 1
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    List<GraphNode> newGraph = new ArrayList<>();
    Queue<GraphNode> q = new LinkedList<>();
    Map<GraphNode, GraphNode> map = new HashMap<>();
    for (GraphNode n : graph) {
      if (!map.containsKey(n)) q.offer(n);
      while (!q.isEmpty()) {
        GraphNode node = q.poll();
        GraphNode newNode = map.get(node);
        if (newNode == null) {
          newNode = new GraphNode(node.key);
          map.put(node, newNode);
        }
        newGraph.add(newNode);
        for (GraphNode nei : node.neighbors) {
          GraphNode newNei = map.get(nei);
          if (newNei == null) {
            newNei = new GraphNode(nei.key);
            map.put(nei, newNei);
            q.offer(nei);
          }
          newNode.neighbors.add(newNei);
        }
      }
    }
    return newGraph;
  }
}

//Solution 2
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    List<GraphNode> newGraph = new ArrayList<>();
    Map<GraphNode, GraphNode> map = new HashMap<>();
    if (graph == null) return newGraph;
    for (GraphNode n : graph) {
      newGraph.add(cloneNode(n, map));
    }
    return newGraph;
  }
  private GraphNode cloneNode(GraphNode n, Map<GraphNode, GraphNode> map) {
    if (!map.containsKey(n)) {
      map.put(n, new GraphNode(n.key));
      for (GraphNode nei : n.neighbors) {
        if (!map.containsKey(nei)) {
          cloneNode(nei, map);
        }
        map.get(n).neighbors.add(map.get(nei));
      }
    }
    return map.get(n);
  }
}
