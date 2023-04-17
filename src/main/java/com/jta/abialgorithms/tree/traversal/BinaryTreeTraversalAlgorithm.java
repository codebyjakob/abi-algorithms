package com.jta.abialgorithms.tree.traversal;

import com.jta.abialgorithms.datastructures.linear.List;
import com.jta.abialgorithms.datastructures.tree.BinarySearchTree;
import com.jta.abialgorithms.datastructures.tree.BinaryTree;
import com.jta.abialgorithms.datastructures.tree.ComparableContent;

/**
 * An interface for algorithms that traverse a binary tree.
 */
public interface BinaryTreeTraversalAlgorithm {
  /**
   * Traverses a given binary tree and returns a list of its elements.
   *
   * @param tree the tree to traverse
   * @param <T>  the type of the elements in the tree
   * @return a list of the elements in the tree
   */
  <T> List<T> traverse(BinaryTree<T> tree);

  /**
   * Traverses a given binary search tree and returns a list of its elements.
   *
   * @param tree the tree to traverse
   * @param <T>  the type of the elements in the tree
   * @return a list of the elements in the tree
   */
  <T extends ComparableContent<T>> List<T> traverse(BinarySearchTree<T> tree);
}
