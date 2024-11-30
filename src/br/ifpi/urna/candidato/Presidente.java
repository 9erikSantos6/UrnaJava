package br.ifpi.urna.candidato;

import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.shared.interfaces.candidato.ViceAssociado;

public class Presidente extends CandidatoTitular implements ViceAssociado {
  private ViceCandidato vicePresidenteAssociado;

  Presidente(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
  }

  protected String validarNumero(String numero) {
    if (numero != null && numero.matches("\\d{2}")) {
      return numero;
    } else {
      throw new IllegalArgumentException("Número inválido para Presidente: deve ter exatamente dois dígitos.");
    }
  }

  public void associarViceCandidato(ViceCandidato vicePresidente) {
    this.vicePresidenteAssociado = vicePresidente;
    vicePresidente.associarCandidatoTitular(this);
  }

  public void desassociarViceCandidato() {
    this.vicePresidenteAssociado = null;
  }

  // Gets
  public ViceCandidato getvicePresidenteAssociado() {
    return this.vicePresidenteAssociado;
  }
}
