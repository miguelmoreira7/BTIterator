package tree;

/**
 * Classe Node com o parametro generito T, que estende Comparable<T>. Isso significa que
 * o tipo T deve ser comparável a si mesmo, permitindo que os nós sejam organizados de acordo
 * com seus valores.
 * @author Alex Sandro
 *
 * @param <T>
 */
public class Node<T extends Comparable<T>> implements Prototype{
    T value;
    Node<T> left;
    Node<T> right;

    Node(T value) {
        this.value = value;
        right = null;
        left = null;
    }

    Node(Node<T> that) {
        this.value = that.value;
        if (that.left != null) {
            this.left = (Node<T>) that.left.clone();
        }
        if (that.right != null) {
            this.right = (Node<T>) that.right.clone();
        }
    }
    
    public String toString() {
    	return value.toString();
    }

    public Node<T> getLeft () {
        return left;
    }

    public Node<T> getRight () {
        return right;
    }

    public int compareTo(Node<T> otherNode) {
        if (otherNode == null) {
            throw new NullPointerException("O nó comparado não pode ser null");
        }
        //provide implementation here
        //See effective java for appropriate implementation conditions
    	return this.value.compareTo(otherNode.value);
    }

    public Prototype clone() {
        return new Node<>(this);
    }
}


