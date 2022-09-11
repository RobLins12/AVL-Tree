package src;
import java.io.PrintStream;

//Código adaptado de https://github.com/eugenp/tutorials

public class TreePrinter {

    private AVL_Tree tree;

    public TreePrinter(AVL_Tree tree) {
        this.tree = tree;
    }

    private String traversePreOrder(Node root) {

        if (root == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getKey());

        String pointerRight = "└──R: ";
        String pointerLeft = (root.getRight() != null) ? "├──L: " : "└──L: ";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }

    private void traverseNodes(StringBuilder sb, String padding, String pointer, Node node,
        boolean hasRightSibling) {

        if (node != null) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getKey());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──R: ";
            String pointerLeft = (node.getRight() != null) ? "├──L: " : "└──L: ";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);

        }

    }

    public void imprimir(PrintStream os) {
        os.print(traversePreOrder(tree.getRoot()));
    }

}
