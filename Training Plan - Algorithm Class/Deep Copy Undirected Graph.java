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
