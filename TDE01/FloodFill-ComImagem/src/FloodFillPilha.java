import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;

public class FloodFillPilha {
    static BufferedImage image;
    static Color corMudar;
    static Color novaCor;

    static Pilha<int[]> pilha = new Pilha<>(10000);
    
    static void iniciar() throws IOException {
        
        image = ImageIO.read(new File("src/imagens/entrada.png"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[0mDigite as coordenadas x e y (separadas por espaço):");
        int pontoInicialY = scanner.nextInt();
        int pontoInicialX = scanner.nextInt();

        floodFill(pontoInicialX, pontoInicialY);

        ImageIO.write(image, "png", new File("src/imagens/saida_pilha.png"));
        System.out.println("Imagem resultante salva como saida_pilha.png");
    }

    static void floodFill(int x, int y) {
        int[] pontoInicial = {x, y};
        pilha.push(pontoInicial);

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

        while (!pilha.isEmpty()) {
            int[] ponto = pilha.pop();
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

            pilha.push(new int[]{x, y - 1});  
            pilha.push(new int[]{x, y + 1});  
            pilha.push(new int[]{x - 1, y});  
            pilha.push(new int[]{x + 1, y});  
        }
    }
}
