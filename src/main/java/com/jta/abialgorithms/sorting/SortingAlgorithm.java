package com.jta.abialgorithms.sorting;

import com.jta.abialgorithms.datastructures.linear.List;

/**
 * An interface for sorting algorithms on a {@link List}.
 */
public interface SortingAlgorithm {
  /**
   * Sorts a given list.
   *
   * @param list the list to sort
   * @param <T>  the type of the elements in the list
   * @return a new list containing the sorted elements
   */
  <T extends Comparable<T>> List<T> sort(List<T> list);
}
