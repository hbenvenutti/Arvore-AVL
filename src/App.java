import java.util.Scanner;

import tree.PrintTree;
import tree.Tree;

public class App {
    public static Tree tree;
    public static boolean exit = false;
    private static Scanner scanner;

    public static void main(String[] args) {
        tree = new Tree();
        scanner = new Scanner(System.in);

        System.out.println("Arvore AVL");

        while(!exit) handleInput();

        scanner.close();
        return;
    }

    // ---------------------------------------------------------------------- //

    static void handleInput() {
        String menu = "1. Insert into tree\n2. Delete from tree\n3. Print tree\n4. Exit\n";
        
        System.out.print(menu);
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                System.out.print("Enter a value to insert in the tree: ");
                int value = Integer.parseInt(scanner.nextLine());
                
                tree.insert(value);
                break;
                
            case "2":
                System.out.print("Enter a value to remove from the tree: ");
                tree.remove(Integer.parseInt(scanner.nextLine()));
                break;
            
            case "3":
                PrintTree.print(tree);
                break;
            
            default:
                exit = true;
                break;
        }
        return;
    }
}
