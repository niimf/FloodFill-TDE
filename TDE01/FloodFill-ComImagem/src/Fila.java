public class Fila<T> {
    private ListaDuplamente<T> lista;

    public Fila() {
        lista = new ListaDuplamente<>();
    }

    public void enqueue(T data) {
        lista.add(data);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        return lista.remove(0);
    }

    public boolean isEmpty() {
        return lista.size() == 0;
    }

    public int size() {
        return lista.size();
    }

    public void clear() {
        lista.clear();
    }
}
