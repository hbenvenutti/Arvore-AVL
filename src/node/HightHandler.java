package node;

import model.Node;

public class HightHandler {
  public static short getHight(Node node) {
    if (node == null) return -1;
    
    return node.hight;
  }

  // ------------------------------------------------------------------------ //

  public static void update(Node node) {
    short leftHeight = getHight(node.left);
    short rightHeight = getHight(node.right);

    node.hight = (short) (getHigherHight(leftHeight, rightHeight) + 1);
  }

  // ------------------------------------------------------------------------ //

  public static short getHigherHight(short leftHight, short rightHight) {
    return (short) (leftHight > rightHight ? leftHight : rightHight);
  }

  // ------------------------------------------------------------------------ //

  public static short getFactor(Node node) {
    return (short) (node.left.hight - node.right.hight);
  }

}
