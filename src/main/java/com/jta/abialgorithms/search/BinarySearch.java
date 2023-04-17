package com.jta.abialgorithms.search;

import com.jta.abialgorithms.datastructures.linear.List;

/**
 * An implementation of the binary search algorithm.
 */
public final class BinarySearch implements SearchAlgorithm {
  @Override
  public <T extends Comparable<T>> int search(
      final List<T> list, final T element) {
    if (!isSorted(list)) {
      throw new IllegalArgumentException("List must be sorted");
    }
    int length = getLength(list);
    int left = 0;
    int right = length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      list.toFirst();
      for (int i = 0; i < middle; i++) {
        list.next();
      }
      T currentElement = list.getContent();
      if (currentElement.equals(element)) {
        return middle;
      } else if (currentElement.compareTo(element) < 0) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    return -1;
  }

  private <T extends Comparable<T>> boolean isSorted(final List<T> list) {
    list.toFirst();
    T previousElement = list.getContent();
    list.next();
    while (list.hasAccess()) {
      T currentElement = list.getContent();
      if (currentElement.compareTo(previousElement) < 0) {
        return false;
      }
      previousElement = currentElement;
      list.next();
    }
    return true;
  }

  private <T extends Comparable<T>> int getLength(final List<T> list) {
    int length = 0;
    list.toFirst();
    while (list.hasAccess()) {
      length++;
      list.next();
    }
    return length;
  }
}
