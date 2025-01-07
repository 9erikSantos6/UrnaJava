package br.ifpi.urna.db.eleitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.ifpi.urna.eleitor.Titulo;
import br.ifpi.urna.shared.utils.titulo.TipoLocalizacaoValidacao;

public class TituloDAO {
  private static final Set<Titulo> TITULOS = new HashSet<>();

  public static void criarTitulo(Titulo titulo) {
    for (Titulo t : TITULOS) {
      if (t.getInscricao().equals(titulo.getInscricao())) {
        throw new IllegalArgumentException("Erro ao adicionar título! O título já existe!");
      }
    }
    TITULOS.add(titulo);
  }

  public static List<Titulo> listarTitulos() {
    List<Titulo> titulosEncontrados = new ArrayList<>();
    for (Titulo t : TITULOS) {
      titulosEncontrados.add(t);
    }
    return titulosEncontrados;
  }


  public static void atualizarTitulo(String inscricao, String zona, String secao) {
    try {
      br.ifpi.urna.shared.utils.titulo.Titulo.validarIscricao(inscricao);
      br.ifpi.urna.shared.utils.titulo.Titulo.validarLocalizacao(TipoLocalizacaoValidacao.ZONA, zona);
      br.ifpi.urna.shared.utils.titulo.Titulo.validarLocalizacao(TipoLocalizacaoValidacao.SECAO, secao);
      
      for (Titulo t : TITULOS) {
        if (t.getInscricao().equals(inscricao)) {
          
        }
      } 

    } catch (IllegalArgumentException e) {
      throw e;
    }
  }
}
