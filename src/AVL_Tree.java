package src;

public class AVL_Tree{
    
    private Node root;
    private int balance;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public AVL_Tree(){
        this.root = null;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }

    private void setBalance(Node n) {
		n.setHeight(altura(n.getRight()) - altura(n.getLeft()));
	}

    public int altura(Node curr) {
		if (curr.getLeft() == null && curr.getRight() == null) {
			return 0;
		
		} else if (curr.getLeft() == null) {
			return 1 + altura(curr.getRight());
		
		} else if (curr.getRight() == null) {
			return 1 + altura(curr.getLeft());
		
		} else {
			return 1 + Math.max(altura(curr.getLeft()), altura(curr.getRight()));
		}
	}
     
    public void insert(Integer key){
        this.setRoot(insert(key, this.getRoot()));
    }

    private Node insert(Integer key, Node x){
        if (x == null) {
            return new Node(key);
        } else {
            int cmp = key.compareTo(x.getKey());
            if(cmp < 0){
                Node leftSubTree = this.insert(key, x.getLeft());
                x.setLeft(leftSubTree);
            }else if(cmp > 0){
                Node rigthtSubTree = this.insert(key, x.getRight());
                x.setRight(rigthtSubTree);
            }else{
                return x;
            } 
        }
        return x;
    }

    public Node search(Integer key){
        return this.search(key, this.getRoot());
    }

    private Node search(Integer key, Node x){
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if(cmp < 0){
            return this.search(key, x.getLeft());
        }else if(cmp > 0){
            return this.search(key, x.getRight());
        }else{
            return x;
        }
    }
	
	public Key min(){
        if(isEmpty()){
            return null;
        }
        Node<Key,Value> auxNode = root;
        while(Objects.nonNull(auxNode.getLeftNode())){
            auxNode = auxNode.getLeftNode();
        }
        return auxNode.getKey();
    }

    public void delete(Integer key) {
		this.deleteAVL(this.getRoot(), key);
	}

	private void deleteAVL(Node n, Integer key) {
		if (n == null) {
			return;

		} else {
			if (n.getKey() > key) {
				deleteAVL(n.getLeft(), key);

			} else if (n.getKey() < key) {
				deleteAVL(n.getRight(), key);

			} else if (n.getKey() == key) {
				delete(n);
			}
		}
	}
    public void delete(Key key) {
        if(isEmpty()){
            return;
        }
        delete(key,this.root);
    }
    private void delete(Key key , Node<Key,Value> x) {

        Node<Key, Value> nodeToDelete = get(key, x);
        Node<Key, Value> antecessor = antecessor(nodeToDelete, x);
        int cmp = key.compareTo(antecessor.getKey());
        if (Objects.nonNull(nodeToDelete.getLeftNode()) && Objects.nonNull(nodeToDelete.getRightNode())) {
            TwoChildren(nodeToDelete);
        } else if (cmp < 0) {
            antecessor.setLeftNode(LeafOrOneChildren(nodeToDelete));
        } else if (cmp > 0) {
            antecessor.setRightNode(LeafOrOneChildren(nodeToDelete));
        } else { // Delete Root Case
            if(Objects.isNull(root.getRightNode()) || Objects.isNull(root.getLeftNode())){
                this.root = LeafOrOneChildren(this.root);
            }else if(Objects.nonNull(root.getRightNode()) && Objects.isNull(root.getRightNode().getRightNode())){
                this.root.setRightNode(null);
            }else{
                this.root.setRightNode(this.root.getRightNode().getRightNode());
            }
        }
    }
    private void TwoChildren(Node<Key,Value> node){
        Node<Key,Value> minValueNode = min(node.getRightNode());
        node.setKey(minValueNode.getKey());
        node.setValue(minValueNode.getValue());
        delete(minValueNode.getKey(),node.getRightNode());
    }
    private Node<Key,Value> LeafOrOneChildren(Node<Key,Value> node){
        if(Objects.isNull(node.getLeftNode())){
            return node.getRightNode();
        }
        if(Objects.isNull(node.getRightNode())){
            return node.getLeftNode();
        }
        return null;
    }
    private Node<Key,Value> antecessor(Node<Key,Value> aux ,Node<Key,Value> x) {
        int cmp = aux.getKey().compareTo(x.getKey());
        while(cmp != 0) {
            if (Objects.equals(aux, x.getRightNode()) || Objects.equals(aux, x.getLeftNode())) {
                break;
            }
            if (cmp < 0) {
                x = x.getLeftNode();
            }else{
                x = x.getRightNode();
            }
        }
        return x;
    }
}

    
}

