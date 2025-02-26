package br.ifpi.urna.shared.models.candidato;

import br.ifpi.urna.partido.Partido;

public abstract class Candidato {
  protected String nome;
  protected Partido partido;

  Candidato(String nome, Partido partido) {
    this.nome = nome;
    this.partido = partido;
  }

  // Gets e Sets:
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Partido getPartido() {
    return partido;
  }

  public void setPartido(Partido partido) {
    this.partido = partido;
  }
}
