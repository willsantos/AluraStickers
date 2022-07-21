import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Interfaces.IExtratorConteudo;
import Model.Conteudo;

public class ExtratorDeConteudoDaNasa implements IExtratorConteudo {

  @Override
  public List<Conteudo> extraiConteudos(String json) {
    var parser = new JsonParser();
    List<Map<String,String>> listaDeAtributos = parser.parse(json);
    List<Conteudo> conteudos = new ArrayList<>();

    //popula a lista
    for (Map<String, String> atributos : listaDeAtributos) {
      String titulo = atributos.get("title");
      String urlImage = atributos.get("url");

      Conteudo conteudo = new Conteudo(titulo, urlImage);
      conteudos.add(conteudo);
    }
    return conteudos;
  }
  
}
