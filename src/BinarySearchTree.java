public class BinarySearchTree {

    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    Node root;

    public BinarySearchTree(){
        root = null;
    }

    private Node insert(Node current, int data){
        if(current == null){
            return new Node(data);
        }
        if(data < current.data){
            current.left = insert(current.left, data);
        } else if (data > current.data) {
            current.right = insert(current.right, data);
        }
        return current;
    }
    public void insert(int data){
        root = insert(root, data);
    }

    private Node remove(Node current, int data){
        if(current == null)
            return null;
        if(data < current.data){
            current.left = remove(current.left, data);
        } else if (data > current.data) {
            current.right = remove(current.right, data);
        }
        else {
            //case 1: no children
            if(current.left == null && current.right == null){
                return null;
            };
            //case 2:  1 child
            if(current.left == null){
                return current.right;
            }
            if(current.right == null){
                return current.left;
            }
            //case3: two children
            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = remove(current.right, smallestValue);
        }
        return current;
    }

    public void remove(int data){
        root = remove(root, data);
    }
    private int findSmallestValue(Node root){
        return root.left == null ? root.data : findSmallestValue(root.left);
    }
    private void inOrder(Node node){
        if(node !=null){
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
    public void inOrder(){
        inOrder(root);
    }
}