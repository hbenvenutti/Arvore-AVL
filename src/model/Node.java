package model;

public class Node {
  Node top;
  Node right;
  Node left;

  int value;

  // *** --- constructors ----------------------------------------------- *** //

  public Node(int value) {
    this.value = value;
  }

  // ------------------------------------------------------------------------ //

  public Node(int value, Node top) {
    this.value = value;
    this.top = top;
  }

  // ------------------------------------------------------------------------ //

  public Node(int value, Node top, Node right) {
    this.value = value;
    this.top = top;
    this.right = right;
  }

  // ------------------------------------------------------------------------ //

  public Node(int value, Node top, Node right, Node left) {
    this.value = value;
    this.top = top;
    this.right = right;
    this.left = left;
  }
}
