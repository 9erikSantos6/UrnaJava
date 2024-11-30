package br.ifpi.urna.candidato;

import br.ifpi.urna.partido.Partido;

public abstract class Candidato {
  private String nome;
  private String numero;
  private Partido partido;

  Candidato(String nome, String numero, Partido partido) {
    this.nome = nome;
    this.numero = this.validarNumero(numero);
    this.partido = partido;
  }

  protected abstract String validarNumero(String numero);

  // Gets e Sets:
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public Partido getPartido() {
    return partido;
  }

  public void setPartido(Partido partido) {
    this.partido = partido;
  }
}
