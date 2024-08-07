package tree;

import iterator.HeightOrderIterator;
import iterator.NodeIterator;

public interface Tree <T extends Comparable<T>>{
    Node<T> getRoot();
    NodeIterator<T> createPreorderIterator();
    NodeIterator<T> createInorderIterator();
    NodeIterator<T> createPostOrderIterator();
    HeightOrderIterator<T> createHeightOrderIterator();
}
