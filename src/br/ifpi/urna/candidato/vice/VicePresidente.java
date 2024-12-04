package br.ifpi.urna.candidato.vice;

import br.ifpi.urna.candidato.titular.Presidente;
import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.shared.models.candidato.CandidatoTitular;
import br.ifpi.urna.shared.models.candidato.ViceCandidato;

public class VicePresidente extends ViceCandidato {
  private Presidente presidenteTitularAssociado;

  public VicePresidente(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
    this.numero = validarNumero(numero);
  }

  @Override
  protected String validarNumero(String numero) {
    if (numero != null && numero.matches("\\d{2}")) {
      return numero;
    } else {
      throw new IllegalArgumentException("Número inválido para VicePresidente: deve ter exatamente dois dígitos.");
    }
  }

  @Override
  public void associarCandidatoTitular(CandidatoTitular vicePresidenteTitular) {
    if (vicePresidenteTitular instanceof Presidente) {
      Presidente presidente = (Presidente) vicePresidenteTitular;
      if (this.presidenteTitularAssociado != presidente) {
        this.presidenteTitularAssociado = presidente;
        this.setNumero(presidente.getNumero());
        presidente.associarViceCandidato(this);
      }
    } else {
      throw new IllegalArgumentException("Candidato inválido para associarCandidatoTitular: deve ser do tipo Presidente");
    }
  }

  @Override
  public void desassociarViceCandidato() {
    this.presidenteTitularAssociado.desassociarViceCandidato();
    this.presidenteTitularAssociado = null;
  }

  @Override
  public Presidente getCandidatoTitularAssociado() {
    return this.presidenteTitularAssociado;
  }
}
