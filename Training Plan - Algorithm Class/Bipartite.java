/*
Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two groups such that no nodes have direct edges to other nodes in the same group.

Examples

1  --   2
    /   
3  --   4

is bipartite (1, 3 in group 1 and 2, 4 in group 2).

1  --   2
    /   |
3  --   4

is not bipartite.

Assumptions

The graph is represented by a list of nodes, and the list of nodes is not null.
*/

/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    if (graph == null || graph.size() == 0) return true;
    Map<GraphNode, Integer> group = new HashMap<>();
    for (GraphNode g : graph) {
      if (!group.containsKey(g)) {
        group.put(g, 1);
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(g);
        while (!queue.isEmpty()) {
          GraphNode n = queue.poll();
          Integer groupNum = group.get(n);
          for (GraphNode nei : n.neighbors) {
            if (group.containsKey(nei)) {
              if (group.get(nei) == groupNum) return false;
            } else {
              group.put(nei, -groupNum);
              queue.offer(nei);
            }
          }
        }
      }
    }
    return true;
  }
}
