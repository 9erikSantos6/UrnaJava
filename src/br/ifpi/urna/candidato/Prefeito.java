package br.ifpi.urna.candidato;

import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.shared.interfaces.candidato.ViceAssociado;

public class Prefeito extends CandidatoTitular implements ViceAssociado {
  private ViceCandidato viceCandidatoAssociado;

  Prefeito(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
  }

  protected String validarNumero(String numero) {
    if (numero != null && numero.matches("\\d{2}")) {
      return numero;
    } else {
      throw new IllegalArgumentException("Número inválido para Prefeito: deve ter exatamente dois dígitos.");
    }
  }

  public void associarViceCandidato(ViceCandidato viceCandidato) {
    this.viceCandidatoAssociado = viceCandidato;
    viceCandidato.associarCandidatoTitular(this);
  }

  public void desassociarViceCandidato() {
    this.viceCandidatoAssociado = null;
  }

  // Gets
  public ViceCandidato getViceCandidatoAssociado() {
    return viceCandidatoAssociado;
  }
}
