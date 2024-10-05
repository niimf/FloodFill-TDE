import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;

public class FloodFillFila {
    static BufferedImage image;
    static Color corMudar;
    static Color novaCor;

    static Fila<int[]> fila = new Fila<>(); // usando Fila baseada em ListaDuplamente

    static void iniciar() throws IOException {
        // Carregar a imagem de entrada
        image = ImageIO.read(new File("C:/Users/nfatu/TDE01/FloodFill-ComImagem/src/imagens/entrada.png"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[0mDigite as coordenadas x e y (separadas por espaço):");
        int pontoInicialY = scanner.nextInt();
        int pontoInicialX = scanner.nextInt();

        floodFill(pontoInicialX, pontoInicialY);

        // Salvar a imagem resultante
        ImageIO.write(image, "png", new File("C:/Users/nfatu/TDE01/FloodFill-ComImagem/src/imagens/saida_fila.png"));
        System.out.println("Imagem resultante salva como saida_fila.png");
    }

    static void floodFill(int x, int y) {
        int[] pontoInicial = {x, y};
        fila.enqueue(pontoInicial);

        Scanner cm = new Scanner(System.in);
        System.out.println("\u001B[0mDigite a cor que deseja mudar - cor existente na img (RGB separados por espaço, ex: 255 255 255): ");
        int r = cm.nextInt();
        int g = cm.nextInt();
        int b = cm.nextInt();
        corMudar = new Color(r, g, b);

        Scanner nc = new Scanner(System.in);
        System.out.println("\u001B[0mDigite a nova cor desejada - nova cor (RGB separados por espaço, ex: 255 0 0): ");
        r = nc.nextInt();
        g = nc.nextInt();
        b = nc.nextInt();
        novaCor = new Color(r, g, b);

        while (!fila.isEmpty()) {
            int[] ponto = fila.dequeue();
            x = ponto[0];
            y = ponto[1];

            if (x < 0 || x >= image.getWidth() || y < 0 || y >= image.getHeight()) {
                continue;
            }

            Color currentColor = new Color(image.getRGB(x, y));
            if (!currentColor.equals(corMudar)) {
                continue;
            }

            image.setRGB(x, y, novaCor.getRGB());

            fila.enqueue(new int[]{x, y - 1});  // esquerda
            fila.enqueue(new int[]{x, y + 1});  // direita
            fila.enqueue(new int[]{x - 1, y});  // cima
            fila.enqueue(new int[]{x + 1, y});  // baixo
        }
    }
}
