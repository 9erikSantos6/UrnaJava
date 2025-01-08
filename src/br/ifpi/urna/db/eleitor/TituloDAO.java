package br.ifpi.urna.db.eleitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import br.ifpi.urna.eleitor.Titulo;
import br.ifpi.urna.shared.utils.titulo.TipoLocalizacaoValidacao;

public class TituloDAO {
  private static final Set<Titulo> TITULOS = Collections.synchronizedSet(new HashSet<>());

  public static void criarTitulo(Titulo titulo) {
    if (!(TITULOS.add(titulo))) {
      throw new IllegalArgumentException("Erro ao adicionar título! O título já existe!");
    }
  }

  public static List<Titulo> listarTitulos() {
    synchronized (TITULOS) {
      return new ArrayList<>(TITULOS);
    }
  }

  public static void atualizarTitulo(String inscricao, String zona, String secao) {
    br.ifpi.urna.shared.utils.titulo.Titulo.validarIscricao(inscricao);
    br.ifpi.urna.shared.utils.titulo.Titulo.validarLocalizacao(TipoLocalizacaoValidacao.ZONA, zona);
    br.ifpi.urna.shared.utils.titulo.Titulo.validarLocalizacao(TipoLocalizacaoValidacao.SECAO, secao);

    synchronized (TITULOS) {
      for (Titulo titulo : TITULOS) {
        if (titulo.getInscricao().equals(inscricao)) {
          titulo.renovarZonaSecao(zona, secao);
          return;
        }
      }
    }

    throw new IllegalArgumentException("Título não encontrado para atualização.");
  }

  public static void deletarTitulo(String inscricao) {
    br.ifpi.urna.shared.utils.titulo.Titulo.validarIscricao(inscricao);
    synchronized (TITULOS) {
      Iterator<Titulo> tituloIterator = TITULOS.iterator();
      while (tituloIterator.hasNext()) {
        Titulo titulo = tituloIterator.next();
        if (titulo.getInscricao().equals(inscricao)) {
          tituloIterator.remove();
          return;
        }
      }
    }

    throw new IllegalArgumentException("Título não encontrado para exclusão.");
  }
}
