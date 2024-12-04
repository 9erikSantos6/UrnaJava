package br.ifpi.urna.candidato.vice;

import br.ifpi.urna.candidato.titular.Governador;
import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.shared.models.candidato.CandidatoTitular;
import br.ifpi.urna.shared.models.candidato.ViceCandidato;

public class ViceGovernador extends ViceCandidato {
  private Governador governadorTitularAssociado;

  public ViceGovernador(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
    this.numero = validarNumero(numero);
  }

  @Override
  protected String validarNumero(String numero) {
    if (numero != null && numero.matches("\\d{2}")) {
      return numero;
    } else {
      throw new IllegalArgumentException("Número inválido para ViceGovernador: deve ter exatamente dois dígitos.");
    }
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
