public class ListaDuplamente<T> {
    Node<T> top;
    Node<T> base;
    int size;

    public T get(int pos) {
        return getNode(pos).data;
    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);

        if (top == null) {
            top = base = newNode;
        } else {
            base.next = newNode;
            newNode.prev = base;
            base = newNode;
        }
        size++;
    }

    public void add(int pos, T data) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posição inválida!");
        }

        Node<T> newNode = new Node<T>(data);

        if (pos == 0) {
            if (top == null) {
                top = base = newNode;
            } else {
                newNode.next = top;
                top.prev = newNode;
                top = newNode;
            }
        } else if (pos == size) {
            add(data);
        } else {
            Node current = getNode(pos);
            Node previous = current.prev;

            newNode.next = current;
            newNode.prev = previous;
            previous.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    private Node<T> getNode(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida!");
        }

        Node<T> current;

        if (pos < size / 2) {
            current = top;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
        } else {
            current = base;
            for (int i = size - 1; i > pos; i--) {
                current = current.prev;
            }
        }

        return current;
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida!");
        }

        Node<T> current = getNode(pos);
        T data = current.data;

        if (current == top) {
            top = current.next;
            if (top != null) {
                top.prev = null;
            }
        } else if (current == base) {
            base = current.prev;
            base.next = null;
        } else {
            Node<T> previous = current.prev;
            Node<T> next = current.next;
            previous.next = next;
            next.prev = previous;
        }

        size--;
        return data;
    }

    public void clear() {
        top = null;
        base = null;
        size = 0;
    }

    public int size() {
        return size;
    }
}
