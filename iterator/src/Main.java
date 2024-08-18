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

        //Clonar arvore
        BinarySearchTree<Integer> clonedBst = (BinarySearchTree<Integer>) bst.clone();

        //Add 20 na Árvore Original e Delete 10 na Clone
        bst.add(20);
        clonedBst.delete(10);

        //Iterador pré ordem ORIGINAL
        System.out.println("Pré ordem original:");
        PreOrderIterator<Integer> preOrder = new PreOrderIterator<>(bst);
        while (preOrder.hasNext()) {
            System.out.println(preOrder.getNext());
        }
        System.out.println();

        //ORIGINAL
        System.out.println("Árvore Original Pré ordem");
        bst.preorder();
        System.out.println();


        //CLONE
        System.out.println("Árvore Clone Pré ordem:");
        clonedBst.preorder();
        System.out.println();

        //Adicionar 100 Original Remover 1 Clone
        bst.add(100);
        clonedBst.delete(1);

        //Iterador em ordem ORIGINAL
        System.out.println("Em ordem original");
        InOrderIterator<Integer> inOrder = new InOrderIterator<>(bst);
        while (inOrder.hasNext()) {
            System.out.println(inOrder.getNext());
        }

        //ORIGINAL
        System.out.println("Árvore Original Em ordem");
        bst.inorder();
        System.out.println();

        //CLONE
        System.out.println("Árvore Clone Em ordem:");
        clonedBst.inorder();
        System.out.println();

        //Adicionar 2 Original Remover 6 Clone
        bst.add(2);
        clonedBst.delete(6);

        //Iterador pós ordem ORIGINAL
        System.out.println("Pós ordem original");
        PostOrderIterator<Integer> postOrder = new PostOrderIterator<>(bst);
        while (postOrder.hasNext()) {
            System.out.println(postOrder.getNext());
        }

        //ORIGINAL
        System.out.println("Árvore Original Pós ordem");
        bst.postorder();
        System.out.println();

        //CLONE
        System.out.println("Árvore Clone Pós ordem");
        clonedBst.postorder();
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