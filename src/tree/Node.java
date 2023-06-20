package tree;

public class Node {
  public Node top = null;
  public Node right = null;
  public Node left = null;
  public short hight = 0;

  private int value;

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

  // *** --- getters ---------------------------------------------------- *** //

  public int getValue() {
    return value;
  }

  // *** --- static methods --------------------------------------------- *** //

  public static void doubleLeftRotation() {}

  // ------------------------------------------------------------------------ //

  public static void doubleRightRotation() {}

  // ------------------------------------------------------------------------ //
  


  // ------------------------------------------------------------------------ //



  // ------------------------------------------------------------------------ //



  // ------------------------------------------------------------------------ //


}
