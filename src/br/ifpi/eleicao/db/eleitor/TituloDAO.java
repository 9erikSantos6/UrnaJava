package br.ifpi.eleicao.db.eleitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.ifpi.eleicao.eleitor.Titulo;
import br.ifpi.eleicao.shared.utils.titulo.TipoLocalizacaoValidacao;

import java.util.Iterator;

public class TituloDAO {
  private static final Set<Titulo> TITULOS = Collections.synchronizedSet(new HashSet<>());

  public static void armazenarTitulo(Titulo titulo) {
    if (!(TITULOS.add(titulo))) {
      throw new IllegalArgumentException("Erro ao adicionar título! O título já existe!");
    }
  }

  public static void armazenarListaTitulos(List<Titulo> titulos) {
    synchronized (TITULOS) {
      for (Titulo titulo : titulos) {
        if (!(TITULOS.add(titulo))) {
          throw new IllegalArgumentException("Erro ao adicionar eleitor! O eleitor já existe!");
        }
      }
    }
  }

  public static List<Titulo> listarTitulos() {
    synchronized (TITULOS) {
      return new ArrayList<>(TITULOS);
    }
  }

  public static Titulo procurarPorInscricao(String inscricao) {
    br.ifpi.eleicao.shared.utils.titulo.Titulo.validarIscricao(inscricao);

    synchronized (TITULOS) {
      Iterator<Titulo> tituloIterator = TITULOS.iterator();
      while (tituloIterator.hasNext()) {
        Titulo titulo = tituloIterator.next();
        if (titulo.getInscricao().equals(inscricao)) {
          return titulo;
        }
      }
    }
    throw new IllegalArgumentException("Titulo não encontrado!");
  }

  public static void atualizarTitulo(String inscricao, String zona, String secao) {
    br.ifpi.eleicao.shared.utils.titulo.Titulo.validarIscricao(inscricao);
    br.ifpi.eleicao.shared.utils.titulo.Titulo.validarLocalizacao(TipoLocalizacaoValidacao.ZONA, zona);
    br.ifpi.eleicao.shared.utils.titulo.Titulo.validarLocalizacao(TipoLocalizacaoValidacao.SECAO, secao);

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
    br.ifpi.eleicao.shared.utils.titulo.Titulo.validarIscricao(inscricao);
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
