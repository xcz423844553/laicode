/*
Given an array of non-negative integers, each of them representing the height of a board perpendicular to the horizontal line, the distance between any two adjacent boards is 1. Consider selecting two boards such that together with the horizontal line they form a container. Find the volume of the largest such container.

Assumptions

The given array is not null and has size of at least 2

Examples

{ 2, 1, 3, 1, 2, 1 }, the largest container is formed by the two boards of height 2, the volume of the container is 2 * 4 = 8.
*/

public class Solution {
  public int largest(int[] array) {
    int result = 0;
    int first = 0;
    int second = array.length - 1;
    while ( first < second) {
        int water = 0;
        if (array[first] < array[second]){
            water = (second - first) * array[first];
            first++;
        } else {
            water = (second - first) * array[second];
            second--;
        }
        if (result < water) { result = water; }
    }
    return result;
  }
}
