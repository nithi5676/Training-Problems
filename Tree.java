package tree;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    Node root;
    static final int COUNT = 10;

    static void print2DUtil(Node root, int space) {
        // Base case
        if (root == null)
            return;
        // Increase distance between levels
        space += COUNT;
        // Process right child first
        print2DUtil(root.right, space);
        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.value + "\n");
        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(Node root) {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }

    Tree() {
        root = null;
    }

    Boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) {
                return false;
            }
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            if (newNode.value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    Boolean contains(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            System.out.println("Tree is Empty");
            return false;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) {
                return false;
            }
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            if (newNode.value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    void bfs() {
        Node currentNode = root;
        Queue<Node> myQueue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        myQueue.add(currentNode);
        while (myQueue.size() > 0) {
            currentNode = myQueue.remove();
            result.add(currentNode.value);
            if ((currentNode.left != null)) {
                myQueue.add(currentNode.left);
            }
            if ((currentNode.right != null)) {
                myQueue.add(currentNode.right);
            }
        }
        for (int a : result) {
            System.out.print(a);
        }
    }

    ArrayList<Integer> dfsPreorder() {
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                result.add(currentNode.value);
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return result;
    }

    ArrayList<Integer> dfsPostorder() {
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                result.add(currentNode.value);
            }
        }
        new Traverse(root);
        return result;
    }

    ArrayList<Integer> inPreorder() {
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                result.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return result;
    }
}

class Node {
    Node left;
    int value;
    Node right;

    Node(int value) {
        this.value = value;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no Elements");
        int size = sc.nextInt();
        System.out.println("Enter Elements");
        Tree b = new Tree();
        for (int i = 0; i < size; i++) {
            b.insert(sc.nextInt());
        }
        b.bfs();
        System.out.println();
        ArrayList<Integer> c = b.dfsPreorder();
        for (int k : c) {
            System.out.print(k);
        }
        System.out.println();
        ArrayList<Integer> v = b.dfsPostorder();
        for (int k : v) {
            System.out.print(k);
        }
        System.out.println();
        ArrayList<Integer> m = b.inPreorder();
        for (int k : m) {
            System.out.print(k);
        }
        sc.close();
    }
}
