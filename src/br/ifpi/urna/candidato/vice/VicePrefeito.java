package br.ifpi.urna.candidato.vice;

import br.ifpi.urna.candidato.titular.Prefeito;
import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.shared.models.candidato.CandidatoTitular;
import br.ifpi.urna.shared.models.candidato.ViceCandidato;

public class VicePrefeito extends ViceCandidato {
  private Prefeito prefeitoTitularAssociado;

  public VicePrefeito(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
    this.numero = validarNumero(numero);
  }

  @Override
  protected String validarNumero(String numero) {
    if (numero != null && numero.matches("\\d{2}")) {
      return numero;
    } else {
      throw new IllegalArgumentException("Número inválido para VicePrefeito: deve ter exatamente dois dígitos.");
    }
  }

  @Override
  public void associarCandidatoTitular(CandidatoTitular presidenteTitular) {
    if (presidenteTitular instanceof Prefeito) {
      Prefeito prefeito = (Prefeito) presidenteTitular;
      if (this.prefeitoTitularAssociado != prefeito) {
        this.prefeitoTitularAssociado = prefeito;
        this.prefeitoTitularAssociado.associarViceCandidato(this);
        this.setNumero(prefeito.getNumero());
      }
    } else {
      throw new IllegalArgumentException("Candidato inválido para associarCandidatoTitular: deve ser do tipo Prefeito");
    }
  }

  @Override
  public void desassociarViceCandidato() {
    this.prefeitoTitularAssociado.desassociarViceCandidato();
    this.prefeitoTitularAssociado = null;
  }

  @Override
  public Prefeito getCandidatoTitularAssociado() {
    return this.prefeitoTitularAssociado;
  }
}
