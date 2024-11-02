import edu.princeton.cs.algs4.StdOut;

public class BST<Key extends Comparable<key>, Value>{

    private class Node {
        public int key;
        public Value value;
        public Node left;
        public Node right;

        public Node(int key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    Node root;

    public BST(){
        root = null;
    }

    public void put(Key key, Value value){
        root = put(val, root);
    }

    private Node put(Key key,Value value, Node n){
        if(n == null){
            return new Node(key,value);
        }
        int cmp = key.compareTo(n.key);
        if(cmp < 0){
            n.left = put(key, value, n.left);
        }
        else if(cmp> 0){
            n.right = put(key, value, n.right);
        }
        else{
            n.value = value;
        }
        return n;
    }

    public void inorder(){
        inorder(root);
    }

    private void inorder(Node n){
        if(n == null){
            return;
        }
        inorder(n.left);
        StdOut.print(n.key + " ");
        inorder(n.right);
    }

    public boolean contains(Key k) {
        return get(k) != null;
    }

    public Value get(Key k) {
        Node x = root;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }

    public Queue<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        inorderKeys(root, queue);
        return queue;
    }

    public void del(Key k){

    }
    public static void main(String[] args){
        BST<String, Integer> tree = new BST();
        tree.put("D",10);
        tree.put("E",5);
        tree.put("A",20);
        tree.inorder();

        if(tree.contains("A")){
            int val =  tree.get("A");
            tree.del("A");
        }
    }
}
