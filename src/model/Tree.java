package model;

import node.HightHandler;
import node.RotateTree;

public class Tree {
  private Node root;

  // *** --- constructors ----------------------------------------------- *** //
  
  public Tree() {
    this.root = null;
  }

  // ------------------------------------------------------------------------ //

  public Tree(int value) {
    this.root = new Node(value);
  }

  // *** --- getters ---------------------------------------------------- *** //
  
  public Node getRoot() {
    return this.root;
  }

  // *** --- methods ---------------------------------------------------- *** //
  
  public Node insert(int value) {
    return insert(this.root, value);
  }

  // ------------------------------------------------------------------------ //

  private Node insert(Node root, int value) {
    if (root == null) {
      return new Node(value);
    }

    if (value == root.getValue()) {
      System.out.println("Valor já existe na árvore");
    }

    if (value > root.getValue()) {
      root.right = insert(root.right, value);
    }

    if (value < root.getValue()) {
      root.left = insert(root.left, value);
    }
    
    HightHandler.update(root);

    root = rebalance(root);

    return root;

  }

  // *** --- private methods -------------------------------------------- *** //

  private Node rebalance(Node root) {
    short rootBalanceFactor = HightHandler.getFactor(root);
    short leftBalanceFactor = HightHandler.getFactor(root.left);
    short rightBalanceFactor = HightHandler.getFactor(root.right);

    if (rootBalanceFactor < -1 && rightBalanceFactor <= 0 ) {
      return RotateTree.toLeft(root); 
    }

    if (rootBalanceFactor > 1 && leftBalanceFactor >= 0) {
      return RotateTree.toRight(root);
    }

    if (rootBalanceFactor < -1 && rightBalanceFactor > 0) {
      return RotateTree.rightLeft(root);
    }

    if (rootBalanceFactor > 1 && leftBalanceFactor < 0) {
      return RotateTree.leftRight(root);
    }

    return root;
  }
}
