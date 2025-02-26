package br.ifpi.eleicao.shared.models.candidato;

import br.ifpi.eleicao.partido.Partido;

public abstract class Candidato {
  protected String nome;
  protected Partido partido;

  Candidato(String nome, Partido partido) {
    this.nome = nome;
    this.partido = partido;
  }

  @Override
  public String toString() {
    return String.format("""
      Nome: %s
      Partido: %s
      """,
      this.nome, 
      this.partido.getNome()
    );
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
