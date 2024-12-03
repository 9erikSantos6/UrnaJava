package br.ifpi.urna.shared.models.candidato;

import br.ifpi.urna.partido.Partido;

public abstract class ViceCandidato extends Candidato {
  protected ViceCandidato(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
  }

  public abstract void associarCandidatoTitular(CandidatoTitular candidatoTitular);

  public abstract void desassociarViceCandidato();

  public abstract CandidatoTitular getCandidatoTitularAssociado();
}
