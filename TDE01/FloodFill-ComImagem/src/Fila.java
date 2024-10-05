public class Fila<T> {
    private ListaDuplamente<T> lista;

    public Fila() {
        lista = new ListaDuplamente<>();
    }

    // Adiciona um elemento no final da fila
    public void enqueue(T data) {
        lista.add(data);
    }

    // Remove e retorna o primeiro elemento da fila
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        return lista.remove(0);
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return lista.size() == 0;
    }

    // Retorna o tamanho da fila
    public int size() {
        return lista.size();
    }

    // Limpa a fila
    public void clear() {
        lista.clear();
    }
}
