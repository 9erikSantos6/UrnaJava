package br.ifpi.eleicao.db.eleitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.ifpi.eleicao.eleitor.Eleitor;

import java.util.Iterator;

public class EleitorDAO {
  private static final Set<Eleitor> ELEITORES = Collections.synchronizedSet(new HashSet<>());

  public static void armazenarEleitor(Eleitor eleitor) {
    if (!(ELEITORES.add(eleitor))) {
      throw new IllegalArgumentException("Erro ao adicionar eleitor! O eleitor já existe!");
    }
  }

  public static void armazenarListaEleitores(List<Eleitor> eleitores) {
    synchronized (ELEITORES) {
      for (Eleitor eleitor : eleitores) {
        if (!(ELEITORES.add(eleitor))) {
          throw new IllegalArgumentException("Erro ao adicionar eleitor! O eleitor já existe!");
        }
      }
    }
  }

  public static List<Eleitor> listarEleitores() {
    synchronized (ELEITORES) {
      return new ArrayList<>(ELEITORES);
    }
  }

  public static Eleitor procurarPorID(String id) {
    synchronized (ELEITORES) {
      Iterator<Eleitor> eleitorIterator = ELEITORES.iterator();
      while (eleitorIterator.hasNext()) {
        Eleitor titulo = eleitorIterator.next();
        if (titulo.getId().equals(id)) {
          return titulo;
        }
      }
    }
    throw new IllegalArgumentException("Eleitor não encontrado!");
  }

  public static void deletarTitulo(String id) {
    synchronized (ELEITORES) {
      Iterator<Eleitor> eleitorIterator = ELEITORES.iterator();
      while (eleitorIterator.hasNext()) {
        Eleitor titulo = eleitorIterator.next();
        if (titulo.getId().equals(id)) {
          eleitorIterator.remove();
          return;
        }
      }
    }

    throw new IllegalArgumentException("Eleitor não encontrado para exclusão.");
  }
}
