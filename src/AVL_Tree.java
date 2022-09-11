package src;

public class AVL_Tree{
    
    private Node root;
 
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public AVL_Tree(){
        this.root = null;
    }

    public void insert(Integer key){
      this.setRoot(insert(key, this.getRoot()));
    }
    private Node insert(Integer key, Node node){
        if (node == null) {
            return new Node(key);
        } else {
            int cmp = key.compareTo(node.getKey());
            if(cmp < 0){
                Node leftSubTree = this.insert(key, node.getLeft());
                node.setLeft(leftSubTree);
            }else if(cmp > 0){
                Node rigthtSubTree = this.insert(key, node.getRight());
                node.setRight(rigthtSubTree);
            }else{
                return node;
            } 
        }
        updateHeight(node);
        return rebalance(node);
    }

    public Node search(Integer key){
        return this.search(key, this.getRoot());
    }

    private Node search(Integer key, Node node){
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.getKey());
        if(cmp < 0){
            return this.search(key, node.getLeft());
        }else if(cmp > 0){
            return this.search(key, node.getRight());
        }else{
            return node;
        }
    }
	
    public void deleteNode(Integer key) {
        root = deleteNode(key, root);
      }
      
      Node deleteNode(Integer key, Node node) {
        if (node == null) {
          return null;
        }
        if (key < node.getKey()) {
          node.setLeft(deleteNode(key, node.getLeft()));
        } else if (key > node.getKey()) {
          node.setRight(deleteNode(key, node.getRight()));
        }
        // Node has only one child --> replace node by its single child / Obs : Works for leaf's(Both Null Children) also;
        else if (node.getLeft() == null) {
          node = node.getRight();
        } else if (node.getRight() == null) {
          node = node.getLeft();
        }
        // Node has two children
        else {
          deleteNodeWithTwoChildren(node);
        }
        if (node == null) {
          return null;
        }
        updateHeight(node);

        return rebalance(node);
      }

      private void deleteNodeWithTwoChildren(Node node) {
        Node inOrderSuccessor = findMax(node.getLeft());
      
        node.setKey(inOrderSuccessor.getKey()); 
      
        // Delete inorder successor recursively
        node.setLeft(deleteNode(inOrderSuccessor.getKey(), node.getLeft()));
      }
      private Node findMax(Node node){
        while(node.getRight() != null){
            node = node.getRight();
        }
        return node;
      }

      private int height(Node node) {
        return node != null ? node.getHeight() : -1;
      }
    
      private void updateHeight(Node node) {
        int leftChildHeight = height(node.getLeft());
        int rightChildHeight = height(node.getRight());
        node.setHeight(Math.max(leftChildHeight, rightChildHeight) + 1); 
      }
    
      private int balanceFactor(Node node) {
        return height(node.getRight()) - height(node.getLeft());
      }

      private Node rotateRight(Node node) {
        Node leftChild = node.getLeft();
      
        node.setLeft(leftChild.getRight());
        leftChild.setRight(node);
      
        updateHeight(node);
        updateHeight(leftChild);
      
        return leftChild;
      }

      private Node rotateLeft(Node node) {
        Node rightChild = node.getRight();
      
        node.setRight(rightChild.getLeft()); 
        rightChild.setLeft(node); 
      
        updateHeight(node);
        updateHeight(rightChild);
      
        return rightChild;
      }

      private Node rebalance(Node node) {
        int balanceFactor = balanceFactor(node);
      
        // Left-heavy?

        if (balanceFactor < -1) {
            System.out.println("Árvore desbalanceada para a esquerda");
          if (balanceFactor(node.getLeft()) <= 0) {    // Case 1
            // Rotate right
              System.out.println("Desbalanceamento Left-Left \n Executando rotação para direita");
            node = rotateRight(node);
          } else {
            // Rotate left-right
              System.out.println("Desbalanceamento Left-Right \n Executando uma rotação para esquerda e em seguida uma para direita" );
            node.setLeft(rotateLeft(node.getLeft())); 
            node = rotateRight(node);
          }
        }
      
        // Right-heavy?
        if (balanceFactor > 1) {
            System.out.println("Árvore desbalanceada para a direita");
          if (balanceFactor(node.getRight()) >= 0) {    // Case 3
            // Rotate left
            System.out.println("Desbalanceamento Right-Right  \n Executando rotação para esquerda");
            node = rotateLeft(node);
          } else {                                 // Case 4
            // Rotate right-left
            System.out.println("Desbalanceamento Right-Left  \n Execuntado uma rotação para direita e em seguida uma para esquerda");
            node.setRight(rotateRight(node.getRight())); 
            node = rotateLeft(node);
          }
        }
        return node;
    }

}

