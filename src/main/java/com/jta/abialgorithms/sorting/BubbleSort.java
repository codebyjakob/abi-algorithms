package com.jta.abialgorithms.sorting;

import com.jta.abialgorithms.datastructures.linear.List;

/**
 * An implementation of the bubble sort algorithm.
 */
public final class BubbleSort implements SortingAlgorithm {
  @Override
  public <T extends Comparable<T>> List<T> sort(final List<T> list) {
    boolean swapped = true;
    while (swapped) {
      swapped = false;
      list.toFirst();
      while (list.hasAccess()) {
        T currentElement = list.getContent();
        list.next();
        T nextElement = list.getContent();
        if (nextElement != null && currentElement.compareTo(nextElement) > 0) {
          list.toFirst();
          while (list.hasAccess() && list.getContent() != currentElement) {
            list.next();
          }
          list.setContent(nextElement);
          list.next();
          list.setContent(currentElement);
          swapped = true;
        }
      }
    }
    return list;
  }
}
