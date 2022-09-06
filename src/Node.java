package src;

public class Node {

    private Integer key;
    private Node left;
    private Node right;
    private int height;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node(Integer key){
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
   
}