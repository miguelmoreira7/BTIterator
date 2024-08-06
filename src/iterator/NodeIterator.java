package iterator;

import tree.Node;

public interface NodeIterator<T> {
    boolean hasNext();
    Node getNext();
    void reset();
}
