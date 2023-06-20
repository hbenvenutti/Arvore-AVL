import tree.PrintTree;
import tree.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree(5);

        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        PrintTree.print(tree.getRoot());
    }
}
