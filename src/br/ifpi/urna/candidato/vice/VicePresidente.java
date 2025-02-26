package br.ifpi.urna.candidato.vice;

import br.ifpi.urna.candidato.titular.Presidente;
import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.shared.models.candidato.CandidatoTitular;
import br.ifpi.urna.shared.models.candidato.ViceCandidato;

public class VicePresidente extends ViceCandidato {
  private Presidente presidenteTitularAssociado;

  public VicePresidente(String nome, Partido partido) {
    super(nome, partido);
  }

  @Override
  public void associarCandidatoTitular(CandidatoTitular presidenteTitular) {
    if (presidenteTitular instanceof Presidente) {
      Presidente presidente = (Presidente) presidenteTitular;
      if (this.presidenteTitularAssociado != presidente) {
        this.presidenteTitularAssociado = presidente;
        this.presidenteTitularAssociado.associarViceCandidato(this);
        this.setNumero(presidente.getNumero());
      }
    } else {
      throw new IllegalArgumentException("Candidato inválido para associarCandidatoTitular: deve ser do tipo Presidente");
    }
  }

  @Override
  public void desassociarViceCandidato() {
    if (this.presidenteTitularAssociado.getViceCandidatoAssociado() == this) {
      this.presidenteTitularAssociado.desassociarViceCandidato();
    }
    this.presidenteTitularAssociado = null;
  }

  @Override
  public Presidente getCandidatoTitularAssociado() {
    return this.presidenteTitularAssociado;
  }
}
