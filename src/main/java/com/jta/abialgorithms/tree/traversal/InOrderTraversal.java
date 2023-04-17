package com.jta.abialgorithms.tree.traversal;

import com.jta.abialgorithms.datastructures.linear.List;
import com.jta.abialgorithms.datastructures.tree.BinarySearchTree;
import com.jta.abialgorithms.datastructures.tree.BinaryTree;
import com.jta.abialgorithms.datastructures.tree.ComparableContent;

/**
 * An implementation of the in-order traversal algorithm.
 */
public final class InOrderTraversal implements BinaryTreeTraversalAlgorithm {
  @Override
  public <T> List<T> traverse(final BinaryTree<T> tree) {
    List<T> list = new List<>();
    if (tree.isEmpty()) {
      return list;
    }
    list.concat(traverse(tree.getLeftTree()));
    list.append(tree.getContent());
    list.concat(traverse(tree.getRightTree()));
    return list;
  }

  @Override
  public <T extends ComparableContent<T>> List<T> traverse(
      final BinarySearchTree<T> tree) {
    List<T> list = new List<>();
    if (tree.isEmpty()) {
      return list;
    }
    list.concat(traverse(tree.getLeftTree()));
    list.append(tree.getContent());
    list.concat(traverse(tree.getRightTree()));
    return list;
  }
}
