package com.jta.abialgorithms.tree.measurement;


import com.jta.abialgorithms.datastructures.tree.BinarySearchTree;
import com.jta.abialgorithms.datastructures.tree.BinaryTree;

/**
 * A collection of algorithms for measuring binary trees.
 */
public final class BinaryTreeMeasurementAlgorithms {
  private BinaryTreeMeasurementAlgorithms() {
  }

  /**
   * Gets the number of nodes in a given binary tree.
   *
   * @param tree the tree to measure
   * @return the number of nodes in the tree
   */
  public static int getNumberOfNodes(final BinaryTree<?> tree) {
    if (tree.isEmpty()) {
      return 0;
    }
    return 1 + getNumberOfNodes(tree.getLeftTree())
        + getNumberOfNodes(tree.getRightTree());
  }

  /**
   * Gets the number of nodes in a given binary search tree.
   *
   * @param tree the tree to measure
   * @return the number of nodes in the tree
   */
  public static int getNumberOfNodes(final BinarySearchTree<?> tree) {
    if (tree.isEmpty()) {
      return 0;
    }
    return 1 + getNumberOfNodes(tree.getLeftTree())
        + getNumberOfNodes(tree.getRightTree());
  }

  /**
   * Gets the number of leaves in a given binary tree.
   *
   * @param tree the tree to measure
   * @return the number of leaves in the tree
   */
  public static int getNumberOfLeaves(final BinaryTree<?> tree) {
    if (tree.isEmpty()) {
      return 0;
    }
    if (tree.getLeftTree().isEmpty() && tree.getRightTree().isEmpty()) {
      return 1;
    }
    return getNumberOfLeaves(tree.getLeftTree())
        + getNumberOfLeaves(tree.getRightTree());
  }

  /**
   * Gets the number of leaves in a given binary search tree.
   *
   * @param tree the tree to measure
   * @return the number of leaves in the tree
   */
  public static int getNumberOfLeaves(final BinarySearchTree<?> tree) {
    if (tree.isEmpty()) {
      return 0;
    }
    if (tree.getLeftTree().isEmpty() && tree.getRightTree().isEmpty()) {
      return 1;
    }
    return getNumberOfLeaves(tree.getLeftTree())
        + getNumberOfLeaves(tree.getRightTree());
  }

  /**
   * Gets the height of a given binary tree.
   *
   * @param tree the tree to measure
   * @return the height of the tree
   */
  public static int getHeightOfTree(final BinaryTree<?> tree) {
    if (tree.isEmpty()) {
      return 0;
    }
    return 1 + Math.max(getHeightOfTree(tree.getLeftTree()),
        getHeightOfTree(tree.getRightTree()));
  }

  /**
   * Gets the height of a given binary search tree.
   *
   * @param tree the tree to measure
   * @return the height of the tree
   */
  public static int getHeightOfTree(final BinarySearchTree<?> tree) {
    if (tree.isEmpty()) {
      return 0;
    }
    return 1 + Math.max(getHeightOfTree(tree.getLeftTree()),
        getHeightOfTree(tree.getRightTree()));
  }

  /**
   * Gets the number of nodes at a given level in a given binary tree.
   *
   * @param tree  the tree to measure
   * @param level the level to measure
   * @return the number of nodes at the given level
   */
  public static int getNumberOfNodesAtLevel(
      final BinaryTree<?> tree, final int level) {
    if (tree.isEmpty()) {
      return 0;
    }
    if (level == 0) {
      return 1;
    }
    return getNumberOfNodesAtLevel(tree.getLeftTree(), level - 1)
        + getNumberOfNodesAtLevel(tree.getRightTree(), level - 1);
  }

  /**
   * Gets the number of nodes at a given level in a given binary search tree.
   *
   * @param tree  the tree to measure
   * @param level the level to measure
   * @return the number of nodes at the given level
   */
  public static int getNumberOfNodesAtLevel(
      final BinarySearchTree<?> tree, final int level) {
    if (tree.isEmpty()) {
      return 0;
    }
    if (level == 0) {
      return 1;
    }
    return getNumberOfNodesAtLevel(tree.getLeftTree(), level - 1)
        + getNumberOfNodesAtLevel(tree.getRightTree(), level - 1);
  }

  /**
   * Gets the number of leaves at a given level in a given binary tree.
   *
   * @param tree  the tree to measure
   * @param level the level to measure
   * @return the number of leaves at the given level
   */
  public static int getNumberOfLeavesAtLevel(
      final BinaryTree<?> tree, final int level) {
    if (tree.isEmpty()) {
      return 0;
    }
    if (level == 0) {
      if (tree.getLeftTree().isEmpty() && tree.getRightTree().isEmpty()) {
        return 1;
      }
      return 0;
    }
    return getNumberOfLeavesAtLevel(tree.getLeftTree(), level - 1)
        + getNumberOfLeavesAtLevel(tree.getRightTree(), level - 1);
  }

  /**
   * Gets the number of leaves at a given level in a given binary search tree.
   *
   * @param tree  the tree to measure
   * @param level the level to measure
   * @return the number of leaves at the given level
   */
  public static int getNumberOfLeavesAtLevel(
      final BinarySearchTree<?> tree, final int level) {
    if (tree.isEmpty()) {
      return 0;
    }
    if (level == 0) {
      if (tree.getLeftTree().isEmpty() && tree.getRightTree().isEmpty()) {
        return 1;
      }
      return 0;
    }
    return getNumberOfLeavesAtLevel(tree.getLeftTree(), level - 1)
        + getNumberOfLeavesAtLevel(tree.getRightTree(), level - 1);
  }
}
