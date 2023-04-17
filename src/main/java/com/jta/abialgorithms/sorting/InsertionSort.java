package com.jta.abialgorithms.sorting;

import com.jta.abialgorithms.datastructures.linear.List;

/**
 * An implementation of the insertion sort algorithm.
 */
public final class InsertionSort implements SortingAlgorithm {
  @Override
  public <T extends Comparable<T>> List<T> sort(final List<T> list) {
    List<T> sortedList = new List<>();
    list.toFirst();
    while (list.hasAccess()) {
      T currentElement = list.getContent();
      sortedList.toFirst();
      while (sortedList.hasAccess()
          && sortedList.getContent().compareTo(currentElement) < 0) {
        sortedList.next();
      }
      if (sortedList.hasAccess()) {
        sortedList.insert(currentElement);
      } else {
        sortedList.append(currentElement);
      }
      list.next();
    }
    return sortedList;
  }
}
