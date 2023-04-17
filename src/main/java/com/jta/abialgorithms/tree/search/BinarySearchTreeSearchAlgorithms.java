package com.jta.abialgorithms.tree.search;

import com.jta.abialgorithms.datastructures.tree.BinarySearchTree;
import com.jta.abialgorithms.datastructures.tree.ComparableContent;

/**
 * A collection of algorithms for searching binary search trees.
 */
public final class BinarySearchTreeSearchAlgorithms {
  private BinarySearchTreeSearchAlgorithms() {
  }

  /**
   * Finds the smallest element in a given binary search tree.
   *
   * @param tree the tree to search
   * @param <T>  the type of the elements in the tree
   * @return the smallest element in the tree or null if the tree is empty
   */
  public static <T extends ComparableContent<T>> T getSmallestElement(
      final BinarySearchTree<T> tree) {
    if (tree.isEmpty()) {
      return null;
    }
    if (tree.getLeftTree().isEmpty()) {
      return tree.getContent();
    }
    return getSmallestElement(tree.getLeftTree());
  }

  /**
   * Finds the largest element in a given binary search tree.
   *
   * @param tree the tree to search
   * @param <T>  the type of the elements in the tree
   * @return the largest element in the tree or null if the tree is empty
   */
  public static <T extends ComparableContent<T>> T getLargestElement(
      final BinarySearchTree<T> tree) {
    if (tree.isEmpty()) {
      return null;
    }
    if (tree.getRightTree().isEmpty()) {
      return tree.getContent();
    }
    return getLargestElement(tree.getRightTree());
  }
}
