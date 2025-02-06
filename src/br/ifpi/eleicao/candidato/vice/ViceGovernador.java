package br.ifpi.eleicao.candidato.vice;

import br.ifpi.eleicao.candidato.titular.Governador;
import br.ifpi.eleicao.partido.Partido;
import br.ifpi.eleicao.shared.models.candidato.CandidatoTitular;
import br.ifpi.eleicao.shared.models.candidato.ViceCandidato;

public class ViceGovernador extends ViceCandidato {
  private Governador governadorTitularAssociado;

  public ViceGovernador(String nome, Partido partido) {
    super(nome, partido);
  }

  @Override
  public void associarCandidatoTitular(CandidatoTitular governadorTitular) {
    if (governadorTitular instanceof Governador) {
      Governador governador = (Governador) governadorTitular;
      if (this.governadorTitularAssociado != governador) {
        this.governadorTitularAssociado = governador;
        this.governadorTitularAssociado.associarViceCandidato(this);
        this.setNumero(governador.getNumero());
      }
    } else {
      throw new IllegalArgumentException("Candidato inválido para associarCandidatoTitular: deve ser do tipo Governador");
    }
  }

  @Override
  public void desassociarViceCandidato() {
    if (this.governadorTitularAssociado.getViceCandidatoAssociado() == this) {
      this.governadorTitularAssociado.desassociarViceCandidato();
    }
    this.governadorTitularAssociado = null;
  }

  @Override
  public Governador getCandidatoTitularAssociado() {
    return this.governadorTitularAssociado;
  }
}
