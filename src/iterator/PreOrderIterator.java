package iterator;

import tree.Node;
import tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderIterator<T extends Comparable<T>> implements NodeIterator {
    private Node<T> root;
    private List<Node<T>> nodes = new ArrayList<>();
    private int currentPosition = 0;

    public PreOrderIterator(Tree<T> tree) {
        this.root = tree.getRoot();
    }

    private void lazyLoad() {
        if (nodes.isEmpty()) {
            preOrder();
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

    public void preOrder () {
        preOrder(root);
    }

    private void preOrder (Node<T> node) {
        if (node == null) {
            return;
        }
        nodes.add(node);
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
