package iterator;

import tree.Node;
import tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HeightOrderIterator<T extends Comparable<T>> implements NodeIterator {
    private Node<T> root;
    private List<Node<T>> nodes = new ArrayList<>();
    private int currentPosition = 0;

    public HeightOrderIterator(Tree<T> tree) {
        this.root = tree.getRoot();
    }

    private void lazyLoad() {
        if (nodes.isEmpty()) {
            heightOrder();
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

    public void heightOrder() {
        if (root == null) {
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.poll();
            nodes.add(currentNode);

            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
