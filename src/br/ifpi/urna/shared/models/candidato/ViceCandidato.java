package br.ifpi.urna.shared.models.candidato;

import br.ifpi.urna.partido.Partido;

public abstract class ViceCandidato extends Candidato {
  protected String numero;

  protected ViceCandidato(String nome, Partido partido) {
    super(nome, partido);
  }

  public abstract void associarCandidatoTitular(CandidatoTitular candidatoTitular);

  public abstract void desassociarViceCandidato();
  
  public abstract CandidatoTitular getCandidatoTitularAssociado();

  protected void setNumero(String numero) {
    this.numero = numero;
  }

  public String getNumero() {
    return numero;
  }
}
