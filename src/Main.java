package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Árvore idealizada para trabalhar com inteiros
        Scanner s = new Scanner(System.in);
        AVL_Tree tree = new AVL_Tree();
        do{
            View.Begin();
            int op = s.nextInt();
            while (op < 0 || op > 4) {
                System.out.println("ERRO: INSIRA UMA ALTERNATIVA VALIDA");
                op = s.nextInt();
            }
            switch (op) {
                case 1:
                    System.out.println("Digite o valor do no a ser inserido");
                    Integer i = s.nextInt();
                    tree.insert(i);
                    break;
                case 2:
                    System.out.println("Digite o valor do no a ser deletado");
                    Integer d = s.nextInt();
                    //tree.delete(d);

                case 3:
                    System.out.println("Digite o valor a ser procurado");
                    Integer r = s.nextInt();
                    Node curr = tree.search(r);
                    if (curr != null) {
                        System.out.println("Nó existe na árvore");
                        System.out.println("Left:" + curr.getLeft().getKey());
                        System.out.println("Right:" + curr.getRight().getKey());
                        System.out.println("Height:" + curr.getHeight());
                    } 
                    else{
                        System.out.println("Nó não existe na árvore");
                    }
                    break;
                case 4:
                    System.out.println("\n");
                    TreePrinter p = new TreePrinter(tree);
                    p.imprimir(System.out);
                    System.out.println("\n");
                    break;
            
            }
        }while(true);
    }
}
