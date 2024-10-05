public class Pilha<T> {

    private int top;  // Índice do topo da pilha
    private T[] data; // Array que armazena os elementos da pilha

    // Construtor que define o tamanho da pilha
    public Pilha(int size) {
        top = -1; // A pilha começa vazia, então o topo é -1
        data = (T[]) new Object[size]; // Criamos um array de tamanho definido
    }

    // Método para adicionar um elemento na pilha
    public void push(T value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            data[++top] = value; // Incrementa o topo e armazena o valor
        }
    }

    // Método para remover o elemento do topo da pilha
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return data[top--]; // Retorna o elemento e decrementa o topo
        }
    }

    // Método para limpar a pilha
    public void clear() {
        top = -1; // Definimos o topo como -1, o que "reseta" a pilha
    }

    // Verifica se a pilha está cheia
    public boolean isFull() {
        return top == data.length - 1; // A pilha está cheia quando o topo é o último índice
    }

    // Verifica se a pilha está vazia
    public boolean isEmpty() {
        return top == -1; // A pilha está vazia quando o topo é -1
    }
}
