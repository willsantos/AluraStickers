import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
    // Leitura da imagem
    //InputStream inputStream = new FileInputStream(file)
    //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_3.jpg").openStream();
    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    // Cria nova imagem em memória com transparência e com tamanho novo
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;

    //Copiar a imagem original para a nova imagem(em memoria )
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);


    //configurar a fonte 
    graphics.setFont(new java.awt.Font("Comic Sans", java.awt.Font.BOLD, 60));
    //configurar a cor da fonte
    graphics.setColor(java.awt.Color.YELLOW);
    //escrever uma frase na imagem
    graphics.drawString("Top Movies", largura/4, novaAltura - 100);

    String sanitized = nomeArquivo.replaceAll("[^a-zA-Z0-9]", ""); 
    //escrever a nova imagem em disco
    ImageIO.write(novaImagem, "png", new File("figurinhas/"+sanitized + ".png"));
  }

  
}
