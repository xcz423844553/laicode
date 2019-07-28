/*
Given an array of integers (without any duplicates), shuffle the array such that all permutations are equally likely to be generated.

Assumptions

The given array is not null
*/

public class Solution {
  public void shuffle(int[] array) {
    Random r = new Random();
    for (int i = 0; i < array.length; i++) {
      int index = r.nextInt(array.length - i) + i;
      swap(array, i, index);
    }
  }
  private void swap(int[] array, int i1, int i2) {
    int temp = array[i1];
    array[i1] = array[i2];
    array[i2] = temp;
  }
}
