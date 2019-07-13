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
    if (graph == null || graph.isEmpty()) return true;
    Map<GraphNode, Integer> group = new HashMap<>();
    Queue<GraphNode> queue = new LinkedList<>();
    for (GraphNode n : graph) {
      Integer g = group.get(n);
      if (g == null) {
        group.put(n, 1);
        queue.offer(n);
        while (!queue.isEmpty()) {
          GraphNode node = queue.poll();
          Integer nodeGroup = group.get(node);
          for (GraphNode nei : node.neighbors) {
            Integer neiGroup = group.get(nei);
            if (neiGroup == null) {
              group.put(nei, -nodeGroup);
              queue.offer(nei);
            } else if (neiGroup == nodeGroup) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
}

/*
Time = O(E + V)
Space = O(V)
*/
