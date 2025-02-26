package br.ifpi.eleicao.candidato.vice;

import br.ifpi.eleicao.candidato.titular.Prefeito;
import br.ifpi.eleicao.partido.Partido;
import br.ifpi.eleicao.shared.models.candidato.CandidatoTitular;
import br.ifpi.eleicao.shared.models.candidato.ViceCandidato;

public class VicePrefeito extends ViceCandidato {
  private Prefeito prefeitoTitularAssociado;

  public VicePrefeito(String nome, Partido partido) {
    super(nome, partido);
    this.numero = validarNumero(numero);
  }

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
