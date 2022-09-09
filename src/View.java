package src;

public class View {

    public static void Begin(){
        System.out.println("Qual operação você deseja realizar?");
        System.out.println("1 - Inserir nó");
        System.out.println("2 - Deletar nó");
        System.out.println("3 - Procurar nó");
        System.out.println("4 - Imprimir árvore");
        System.out.println("0 - Sair");
    }

    public static void walk() {
        System.out.println("1 - PreOrdem");
        System.out.println("2 - InOrder");
        System.out.println("3 - PosOrder");
        System.out.println("4 - BreadthFirst");    
    }

    public static void printTree(AVL_Tree tree){
        //TreeWalker treeW = new TreeWalker(tree);
        //System.out.println(treeW.breadthFirst());
        Node n = tree.getRoot();
        System.out.println(n.getKey());
        while (n.getLeft() != null) {
            if (n.getLeft() != null) {
                System.out.println(n.getLeft().getKey());
            }
            if(n.getRight() != null){
                System.out.println(n.getRight().getKey());
            }
            n = n.getLeft();
        }
        
    }

}
