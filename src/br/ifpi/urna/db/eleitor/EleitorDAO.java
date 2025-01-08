package br.ifpi.urna.db.eleitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import br.ifpi.urna.eleitor.Eleitor;

public class EleitorDAO {
  private static final Set<Eleitor> ELEITORS = Collections.synchronizedSet(new HashSet<>());

  public static void criarEleitor(Eleitor eleitor) {
    if (!(ELEITORS.add(eleitor))) {
      throw new IllegalArgumentException("Erro ao adicionar eleitor! O eleitor já existe!");
    }
  }

  public static List<Eleitor> listarEleitores() {
    synchronized (ELEITORS) {
      return new ArrayList<>(ELEITORS);
    }
  }

  public static void deletarTitulo(String id) {
    synchronized (ELEITORS) {
      Iterator<Eleitor> eleitorIterator = ELEITORS.iterator();
      while (eleitorIterator.hasNext()) {
        Eleitor titulo = eleitorIterator.next();
        if (titulo.getId().equals(id)) {
          eleitorIterator.remove();
          return;
        }
      }
    }

    throw new IllegalArgumentException("eleitor não encontrado para exclusão.");
  }
}
