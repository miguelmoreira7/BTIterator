package iterator;

import tree.Node;
import tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderIterator <T extends Comparable<T>> implements NodeIterator{
    private Node<T> root;
    private List<Node<T>> nodes = new ArrayList<>();
    private int currentPosition = 0;

    public PostOrderIterator(Tree<T> tree) {
        this.root = tree.getRoot();
    }

    private void lazyLoad() {
        if (nodes.isEmpty()) {
            postOrder();
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

    public void postOrder () {
        postOrder(root);
    }

    private void postOrder (Node<T> node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        nodes.add(node);
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
