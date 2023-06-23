package tree;

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
  
  public void insert(int value) {
    this.root = insert(this.root, value);
    return;
  }

  // ------------------------------------------------------------------------ //

  private Node insert(Node root, int value) {
    if (root == null) {
      return new Node(value);
    }

    if (value == root.value) {
      System.out.println("Valor já existe na árvore");
    }

    if (value > root.value) {
      root.right = insert(root.right, value);
    }

    if (value < root.value) {
      root.left = insert(root.left, value);
    }
    
    HightHandler.update(root);

    root = rebalance(root);

    return root;
  }

  // ------------------------------------------------------------------------ //

  public Node search(int value) {
    return search(this.root, value);
  }

  // ------------------------------------------------------------------------ //

  private Node search(Node root, int value) {
    if (root == null) {
      System.out.println("Valor não existe na árvore");
      return null;
    }

    if (value == root.value) {
      return root;
    }

    if (value > root.value) {
      return search(root.right, value);
    }

    return search(root.left, value);
  }

  // ------------------------------------------------------------------------ //

  public Node remove(int value) {
    return remove(this.root, value);
  }

  // ------------------------------------------------------------------------ //

  private Node remove(Node root, int value) {
    if (root == null) {
      System.out.println("Valor não existe na árvore");
      return null;
    }

    if (value == root.value) {
      if (root.left == null && root.right == null) {
        root = null;
        return null;
      }

      if (root.left != null && root.right != null) {
        Node aux = root.left;

        while (aux.right != null) {
          aux = aux.right;
        }

        root.value = aux.value;
        aux.value = value;

        root.left = remove(root.left, value);

        return root;
      }

      Node aux = root.left != null ? root.left : root.right;

      root = null;

      return aux;
    }

    if (value < root.value) {
      root.left = remove(root.left, value);
    }

    if (value > root.value) {
      root.right = remove(root.right, value);
    }

    HightHandler.update(root);

    return rebalance(root);
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
