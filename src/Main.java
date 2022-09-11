package src;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Árvore idealizada para trabalhar com inteiros
        Scanner s = new Scanner(System.in);
        AVL_Tree tree = new AVL_Tree();
        TreePrinter p = new TreePrinter(tree);
        System.out.println("Bem vindo ao projeto AVL");
        try{
        int op;
        do{
            View.Begin();
            op = s.nextInt();
            while (op < 0 || op > 4) {
                System.out.println("ERRO: INSIRA UMA ALTERNATIVA VALIDA");
                op = s.nextInt();
            }
            switch (op) {
                case 1:
                    System.out.println(" ");
                    System.out.println("Tree AVL");
                    p.imprimir(System.out);
                    System.out.println("\n");
                    System.out.println("Digite o valor do no a ser inserido");
                    Integer i = s.nextInt();
                    tree.insert(i);
                    System.out.println(" ");
                    System.out.println("Tree AVL");
                    p.imprimir(System.out);
                    System.out.println("\n");
                    break;

                case 2:
                    System.out.println(" ");
                    System.out.println("Tree AVL");
                    p.imprimir(System.out);
                    System.out.println("\n");
                    System.out.println("Digite o valor do no a ser deletado");
                    Integer d = s.nextInt();
                    tree.deleteNode(d);
                    System.out.println(" ");
                    System.out.println("Tree AVL");
                    p.imprimir(System.out);
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.println("Digite o valor a ser procurado");
                    Integer r = s.nextInt();
                    Node curr = tree.search(r);
                    if (curr != null) {
                        System.out.println("\n");
                        System.out.println("Nó existe na árvore");
                        if (curr.getLeft() != null) {
                           System.out.println("Left:" + curr.getLeft().getKey()); 
                        }
                        if (curr.getRight() != null) {
                            System.out.println("Right:" + curr.getRight().getKey());
                        }
                        System.out.println("Height:" + curr.getHeight());
                    } 
                    else{
                        System.out.println("Nó não existe na árvore");
                    }
                    System.out.println("\n");
                    break;

                case 4:
                    View.walk();
                    TreeWalker walker = new TreeWalker(tree);
                    int op2 = s.nextInt();
                    switch (op2) {
                        case 1: System.out.println(walker.preorder()); 
                            break;
                        case 2: System.out.println(walker.inOrder()); 
                            break;
                        case 3: System.out.println(walker.postorder());
                            break;
                        case 4: System.out.println(walker.breadthFirst());
                            break;
                    }
                    break;                  
            }
        }while(op != 0);
        s.close();
        }catch (InputMismatchException e) {
        System.out.println("Você inseriu um valor invalido");
        }
        finally{
            System.out.println("Finalizando programa");
        }
    }
}
