import iterator.HeightOrderIterator;
import iterator.InOrderIterator;
import iterator.PostOrderIterator;
import iterator.PreOrderIterator;
import tree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(50);
        System.out.println("Root:" + bst.getRoot());
        System.out.println("Size:" + bst.size());

        System.out.println("Delete 50:" + bst.delete(50));
        System.out.println("Root:" + bst.getRoot());

        bst.add(8);
        bst.add(3);
        bst.add(10);
        bst.add(1);
        bst.add(6);
        bst.add(14);
        bst.add(4);
        bst.add(7);
        bst.add(13);

        //Iterador pré ordem
        System.out.println("Pré ordem:");
        PreOrderIterator<Integer> preOrder = new PreOrderIterator<>(bst);
        while (preOrder.hasNext()) {
            System.out.println(preOrder.getNext());
        }
        bst.preorder();
        System.out.println();

        //Iterador em ordem
        System.out.println("Em ordem");
        InOrderIterator<Integer> inOrder = new InOrderIterator<>(bst);
        while (inOrder.hasNext()) {
            System.out.println(inOrder.getNext());
        }
        bst.inorder();
        System.out.println();

        //Iterador pós ordem
        System.out.println("Pós ordem");
        PostOrderIterator<Integer> postOrder = new PostOrderIterator<>(bst);
        while (postOrder.hasNext()) {
            System.out.println(postOrder.getNext());
        }
        bst.postorder();
        System.out.println();

        //Iterador por ordem de altura
        System.out.println("Ordem de altura");
        HeightOrderIterator<Integer> HeightOrder = new HeightOrderIterator<>(bst);
        while (HeightOrder.hasNext()) {
            System.out.println(HeightOrder.getNext());
        }
        System.out.println();

        System.out.println("Search 90: " + bst.search(90));
        System.out.println("Contains 80: " + bst.contains(80));

        System.out.println("Delete 50:" + bst.delete(50));
        System.out.println("Root:" + bst.getRoot());

        System.out.println("Size:" + bst.size());
    }
}