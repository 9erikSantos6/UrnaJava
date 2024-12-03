package br.ifpi.urna.shared.models.candidato;

import br.ifpi.urna.partido.Partido;

public abstract class CandidatoTitular extends Candidato {
  protected int votos;

  protected CandidatoTitular(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
  }

  public void adicionarVoto() {
    this.votos++;
  }

  public void zerarVotos() {
    this.votos = 0;
  }

  public int getVotos() {
    return votos;
  }
}
