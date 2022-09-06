package src;

import java.util.ArrayList;
import java.util.List;

public class TreeWalker {
    
    private AVL_Tree tree;

    public TreeWalker(AVL_Tree tree){
        this.tree = tree;
    }

    public List<Integer> inOrder(){
        List<Integer> listInOrder = new ArrayList<>();
        this.inOrder(tree.getRoot(), listInOrder);
        return listInOrder;
    }

    private void inOrder(Node root, List<Integer> listInOrder){
        if (root == null) {
            return;
        }
        inOrder(root.getLeft(), listInOrder);
        listInOrder.add(root.getKey());
        inOrder(root.getRight(), listInOrder);
    }

    public List<Integer> preorder(){
        List<Integer> listPreorder = new ArrayList<>();
        this.preorder(tree.getRoot(), listPreorder);
        return listPreorder;
    }

    private void preorder(Node root, List<Integer> listPreorder){
        if (root == null) {
            return;
        }
        listPreorder.add(root.getKey());
        preorder(root.getLeft(), listPreorder);
        preorder(root.getRight(), listPreorder);
    }

    public List<Integer> postorder(){
        List<Integer> listPostorder = new ArrayList<>();
        this.postorder(tree.getRoot(), listPostorder);
        return listPostorder;
    }

    private void postorder(Node root, List<Integer> listPostorder){
        if (root == null) {
            return;
        }
        postorder(root.getLeft(), listPostorder);
        postorder(root.getRight(), listPostorder);
        listPostorder.add(root.getKey());
    }

    public List<Integer> breadthFirst(){
        List<Integer> listBreadthFirst = new ArrayList<>();
        Queue q = new Queue();
        q.enqueue(tree.getRoot());
        while (!q.isEmpty()) {
            Node n = q.dequeue();
            listBreadthFirst.add(n.getKey());
            if (n.getLeft() != null) { 
                q.enqueue(n.getLeft()); 
            }
            if (n.getRight() != null){
                q.enqueue(n.getRight());
            }
        }
        return listBreadthFirst; 
    }
}