package com.jta.abialgorithms.sorting;

import com.jta.abialgorithms.datastructures.linear.List;

/**
 * An implementation of the selection sort algorithm.
 */
public final class SelectionSort implements SortingAlgorithm {
  @Override
  public <T extends Comparable<T>> List<T> sort(final List<T> list) {
    List<T> sortedList = new List<>();
    list.toFirst();
    while (list.hasAccess()) {
      T smallestElement = getSmallestElement(list);
      sortedList.append(smallestElement);
      removeElement(list, smallestElement);
      list.toFirst();
    }
    return sortedList;
  }

  private <T extends Comparable<T>> T getSmallestElement(final List<T> list) {
    T smallestElement = list.getContent();
    list.toFirst();
    while (list.hasAccess()) {
      if (list.getContent().compareTo(smallestElement) < 0) {
        smallestElement = list.getContent();
      }
      list.next();
    }
    return smallestElement;
  }

  private <T extends Comparable<T>> void removeElement(
      final List<T> list, final T element) {
    list.toFirst();
    while (list.hasAccess()) {
      if (list.getContent().equals(element)) {
        list.remove();
        return;
      }
      list.next();
    }
  }
}
