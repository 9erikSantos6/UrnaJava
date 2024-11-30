package br.ifpi.urna.candidato;

import br.ifpi.urna.partido.Partido;

public abstract class ViceCandidato extends Candidato {
  private CandidatoTitular candidatoTitularAssociado;

  ViceCandidato(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
  }

  public void associarCandidatoTitular(CandidatoTitular candidatoTitular) {
    if (candidatoTitular instanceof Prefeito || candidatoTitular instanceof Presidente || candidatoTitular instanceof Governador ) { 
      this.candidatoTitularAssociado = candidatoTitular;

      if (candidatoTitular instanceof Prefeito) {
        Prefeito prefeito = (Prefeito) candidatoTitular;
        prefeito.associarViceCandidato(this);
      }
      
      if (candidatoTitular instanceof Presidente) {
        Presidente presidente = (Presidente) candidatoTitular;
        presidente.associarViceCandidato(this);
      }

      if (candidatoTitular instanceof Governador) {
        Presidente presidente = (Presidente) candidatoTitular;
        presidente.associarViceCandidato(this);
      }
    }
  }

  public void desassociarViceCandidato() {
    this.candidatoTitularAssociado = null;
  }

  // Gets e Sets
  public CandidatoTitular getCandidatoTitularAssociado() {
    return candidatoTitularAssociado;
  }
}
