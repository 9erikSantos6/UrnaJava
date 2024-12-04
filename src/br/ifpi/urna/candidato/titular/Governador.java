package br.ifpi.urna.candidato.titular;

import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.shared.interfaces.candidato.IViceAssociado;
import br.ifpi.urna.shared.models.candidato.CandidatoTitular;
import br.ifpi.urna.shared.models.candidato.ViceCandidato;

// Ainda não implementado completamente

public class Governador extends CandidatoTitular implements IViceAssociado{
  private ViceCandidato viceGovernadorAssociado;

  public Governador(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
  }

  protected String validarNumero(String numero) {
    if (numero != null && numero.matches("\\d{2}")) {
      return numero;
    } else {
      throw new IllegalArgumentException("Número inválido para Governador: deve ter exatamente dois dígitos.");
    }
  }

  public void associarViceCandidato(ViceCandidato vicePresidente) {
    this.viceGovernadorAssociado = vicePresidente;
    vicePresidente.associarCandidatoTitular(this);
  }

  public void desassociarViceCandidato() {
    this.viceGovernadorAssociado = null;
  }

  // Gets
  public ViceCandidato getvicePresidenteAssociado() {
    return this.viceGovernadorAssociado;
  }
}
