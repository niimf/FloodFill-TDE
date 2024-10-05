import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner decidir = new Scanner(System.in);
        int loop = 1;
        System.out.println("Olá, bem vindo ao FloodFill de Lipe, Nic e Gab");
        while (loop == 1) {
            System.out.println("Se deseja fazer FloodFill com pilha, digite 1. Se deseja fazê-lo com fila, digite 2.");
            try {
                int num = decidir.nextInt();
                if (num == 1) {
                    FloodFillPilha.iniciar();
                    break;
                } else if (num == 2) {
                    FloodFillFila.iniciar();
                    break;
                } else {
                    System.out.println("Digite apenas 1 ou 2, por favor!");
                    System.out.println("");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite apenas números.");
                decidir.next();
                System.out.println("");
            }
        }
    }
}
