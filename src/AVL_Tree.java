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
    private boolean delete(Node x){
        //Caso 1, nó é folha
        
        return false;
    }

    
}

