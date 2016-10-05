package TechInterview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(int value) {
        Node node = new Node(value);
        
        if (root == null)
            root = node;
        else {
            Node parent = null;
            Node curr = root;
            while (curr != null) {
                parent = curr;
                curr = value < curr.value ? curr.left : curr.right;
            }
            if (value < parent.value)
                parent.left = node;
            else
                parent.right = node;
        }
    }
    
    public boolean remove(int value) {
        Node parent = null;
        Node curr = root;
        boolean isLeft = false;
        
        while (value != curr.value) {
            parent = curr;
            if (value < curr.value) {
                curr = curr.left;
                isLeft = true;
            }
            else {
                curr = curr.right;
                isLeft = false;
            }
            if (curr == null) 
                return false;
        }
        
        if (curr.left == null && curr.right == null) {
            if (curr == root)
                root = null;
            else if (isLeft)
                parent.left = null;
            else
                parent.right = null;
        }
        else if (curr.left == null) {
            if (curr == root)
                root = curr.right;
            else if (isLeft) 
                parent.left = curr.right;
            else
                parent.right = curr.right;  
        }
        else if (curr.right == null) {
            if (curr == root)
                root = curr.left;
            else if (isLeft)
                parent.left = curr.left;
            else
                parent.right = curr.left;
        }
        else {
            Node replacement = getReplacement(curr);
            if (curr == root)
                root = replacement;
            else if (isLeft)
                parent.left = replacement;
            else
                parent.right = replacement;
            replacement.left = curr.left;
        }
        return true;
    }
    
    private Node getReplacement(Node curr) {
        Node parent = null;
        Node focus = curr;
        Node child = curr.right;
        
        while(child != null) {
            parent = focus;
            focus = child;
            child = child.left;
        }
        if (focus != curr.right) {
            parent.left = focus.right;
            focus.right = curr.right;
        }
        return focus;
    }
    
    public boolean contains(int value) {
        Node curr = root;
        
        while (curr != null) {
            if (value < curr.value)
                curr = curr.left;
            else if (value > curr.value)
                curr = curr.right;
            else
                return true;
        }
        return false;
    }
    
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }
    
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }
    
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }
    
    public void postOrder() {
        postOrder(root);
        System.out.println();
    }
    
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }
    
    public void breadthFirst() {
        Queue<Node> queue = new LinkedList<>() ;
        if (root == null)
            return;
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.print(node.value + " ");
            if (node.left != null) 
                queue.add(node.left);
            if (node.right != null) 
                queue.add(node.right);
        }
        System.out.println();
    }

    public class Node {

        private Node left, right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(50);
        bst.add(25);
        bst.add(15);
        bst.add(30);
        bst.add(75);
        bst.add(85);
        
        System.out.print("In-order: ");
        bst.inOrder();
        System.out.print("Pre-order: ");
        bst.preOrder();
        System.out.print("Post-order: ");
        bst.postOrder();
        System.out.print("Breadth first: ");
        bst.breadthFirst();
        
        System.out.println("Contains: " + bst.contains(0));
        System.out.println("Removed: " + bst.remove(85));
        System.out.print("In-order: ");
        bst.inOrder();
    }
}