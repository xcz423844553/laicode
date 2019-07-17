/*
Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

Assumptions

the composition is not null and is not guaranteed to be sorted
K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words

Return

a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)

Examples

Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]
*/

public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    Map<String, Integer> count = new HashMap<>();
    for (String s : combo) {
      if (count.containsKey(s)) {
        count.put(s, count.get(s) + 1);
      } else {
        count.put(s, 1);
      }
    }
    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(1, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        if (e1.getValue() == e2.getValue()) return 0;
        return e1.getValue() > e2.getValue() ? 1 : -1;
      }
    });
    int i = 0;
    for (Map.Entry<String, Integer> e : count.entrySet()) {
      if (i < k) {
        pq.offer(e);
      } else if (e.getValue() > pq.peek().getValue()) {
        pq.poll();
        pq.offer(e);
      }
      i++;
    }
    String[] result = new String[pq.size()];
    for (int j = pq.size() - 1; j >= 0; j--) {
      result[j] = pq.poll().getKey();
    }
    return result;
  }
}
