package iterator;

import tree.Node;
import tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class InOrderIterator<T extends Comparable<T>> implements NodeIterator{
    private Node<T> root;
    private List<Node<T>> nodes = new ArrayList<>();
    private int currentPosition = 0;

    public InOrderIterator(Tree<T> tree) {
        this.root = tree.getRoot();
    }

    private void lazyLoad() {
        if (nodes.isEmpty()) {
            inOrder();
        }
    }

    @Override
    public boolean hasNext() {
        lazyLoad();
        return currentPosition < nodes.size();
    }

    @Override
    public Node<T> getNext() {
        if (!hasNext()) {
            return null;
        }
        Node<T> currentNode = nodes.get(currentPosition);
        currentPosition++;
        return currentNode;
    }

    public void inOrder () {
        inOrder(root);
    }

    private void inOrder (Node<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        nodes.add(node);
        inOrder(node.getRight());
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
