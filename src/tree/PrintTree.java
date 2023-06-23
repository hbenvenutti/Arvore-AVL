package tree;

public class PrintTree {
  public static void print(Tree tree) {
    Node root = tree.getRoot();
    print(root, 0);
  }

  // ------------------------------------------------------------------------ //
  
  public static void print(Node root, int level) {
    int i;
    
    if (root != null) {
      print(root.right, level + 1);
      System.out.print("\n\n");

      for (i = 0; i < level; i++) {
        System.out.print("\t");
      }

      System.out.print(root.value);
      print(root.left, level + 1);
    }

    System.out.print("\n");
  }
}
