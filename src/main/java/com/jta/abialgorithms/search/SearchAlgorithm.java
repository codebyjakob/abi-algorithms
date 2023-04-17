package com.jta.abialgorithms.search;

import com.jta.abialgorithms.datastructures.linear.List;

/**
 * An interface for search algorithms on a {@link List}.
 */
public interface SearchAlgorithm {
  /**
   * Searches for an element in a given list.
   *
   * @param list    the list to search in
   * @param element the element to search for
   * @param <T>     the type of the elements in the list
   * @return the index of the element if found, -1 otherwise
   */
  <T extends Comparable<T>> int search(List<T> list, T element);
}
