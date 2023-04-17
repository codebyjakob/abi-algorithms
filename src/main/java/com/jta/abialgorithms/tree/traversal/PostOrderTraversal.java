package com.jta.abialgorithms.tree.traversal;

import com.jta.abialgorithms.datastructures.linear.List;
import com.jta.abialgorithms.datastructures.tree.BinarySearchTree;
import com.jta.abialgorithms.datastructures.tree.BinaryTree;
import com.jta.abialgorithms.datastructures.tree.ComparableContent;

/**
 * An implementation of the post-order traversal algorithm.
 */
public final class PostOrderTraversal implements BinaryTreeTraversalAlgorithm {
  @Override
  public <T> List<T> traverse(final BinaryTree<T> tree) {
    List<T> list = new List<>();
    if (tree.isEmpty()) {
      return list;
    }
    list.concat(traverse(tree.getLeftTree()));
    list.concat(traverse(tree.getRightTree()));
    list.append(tree.getContent());
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
    list.concat(traverse(tree.getRightTree()));
    list.append(tree.getContent());
    return list;
  }
}
