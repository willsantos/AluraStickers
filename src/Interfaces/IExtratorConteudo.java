package Interfaces;

import java.util.List;

import Model.Conteudo;

public interface IExtratorConteudo {
  List <Conteudo> extraiConteudos(String json);
}
