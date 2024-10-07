public class Pilha<T> {

    private int top;  
    private T[] data; 

    public Pilha(int size) {
        top = -1; 
        data = (T[]) new Object[size]; 
    }

    public void push(T value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            data[++top] = value; 
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return data[top--]; 
        }
    }

    public void clear() {
        top = -1; 
    }

    public boolean isFull() {
        return top == data.length - 1; 
    }

    public boolean isEmpty() {
        return top == -1; 
    }
}
