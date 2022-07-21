import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import Interfaces.IExtratorConteudo;
import Model.Conteudo;

public class App {
    public static void main(String[] args) throws Exception {

        var http = new ClientHttp();
        
        // ESCOLHE QUAL URL VAI SER USADA


        //IMDB
            String urlIMDB = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
            IExtratorConteudo extrator = new ExtratorDeConteudoDoIMDB();
            String json = http.buscaDados(urlIMDB);

        //NASA    
            // String urlNasa = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
            // IExtratorConteudo extrator = new ExtratorDeConteudoDaNasa();      
            // String json = http.buscaDados(urlNasa);

        var geradora = new GeradoraDeFigurinhas();

      
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        for (int i=0;i <3;i++) {

            Conteudo conteudo = conteudos.get(i);
            
            InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
            String nomeArquivo = conteudo.getTitulo();

            
            geradora.cria(inputStream, nomeArquivo);

        }

    }
}
