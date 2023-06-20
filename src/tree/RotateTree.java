package tree;

// * ---------------------------------------------------------------------- * //

public class RotateTree {

  public static Node toLeft(Node oldHead) {
    Node child = null;

    Node newHead = oldHead.right;

    if (newHead.left != null) {
      child = newHead.left;
      child.top = oldHead;
    }

    newHead.top = null;
    newHead.left = oldHead;

    oldHead.right = child;
    oldHead.top = newHead;

    // *** --- update hights -------------------------------------------- *** //

    HightHandler.update(oldHead);
    HightHandler.update(newHead);

    return newHead;
  }

  // ------------------------------------------------------------------------ //
  
  public static Node toRight(Node oldHead) {
    Node newHead = oldHead.left;
    Node child = null;

    if (newHead.right != null) {
      child = newHead.right;
      child.top = oldHead;
    }

    newHead.top = null;
    newHead.right = oldHead;

    oldHead.left = child;
    oldHead.top = newHead;

    // *** --- update hights -------------------------------------------- *** //

    HightHandler.update(oldHead);
    HightHandler.update(newHead);

    return newHead;
  }

  // ------------------------------------------------------------------------ //

  public static Node rightLeft(Node oldHead) {
    Node right = oldHead.right;

    oldHead.right = toRight(right);

    Node newHead = toLeft(oldHead);

    return newHead;
  }

  // ------------------------------------------------------------------------ //

  public static Node leftRight(Node oldHead) {
    Node left = oldHead.left;

    oldHead.left = toLeft(left);

    Node newHead = toRight(oldHead);

    return newHead;
  }
}
