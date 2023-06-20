package tree;

public class Node {
  public Node top = null;
  public Node right = null;
  public Node left = null;
  public short hight = 0;
  public int value;

  // *** --- constructors ----------------------------------------------- *** //

  public Node(int value) {
    this.value = value;
  }

  // ------------------------------------------------------------------------ //

  public Node(int value, Node top) {
    this.value = value;
    this.top = top;
  }
}
