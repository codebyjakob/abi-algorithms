package com.jta.abialgorithms.search;

import com.jta.abialgorithms.datastructures.linear.List;

/**
 * An implementation of the linear search algorithm.
 */
public final class LinearSearch implements SearchAlgorithm {
  @Override
  public <T extends Comparable<T>> int search(
      final List<T> list, final T element) {
    int index = 0;
    list.toFirst();
    while (list.hasAccess()) {
      T currentElement = list.getContent();
      if (currentElement.equals(element)) {
        return index;
      }
      index++;
      list.next();
    }
    return -1;
  }
}
