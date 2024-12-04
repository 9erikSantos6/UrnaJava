package br.ifpi.urna.candidato.titular;

import br.ifpi.urna.candidato.vice.VicePrefeito;
import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.shared.interfaces.candidato.IViceAssociado;
import br.ifpi.urna.shared.models.candidato.CandidatoTitular;
import br.ifpi.urna.shared.models.candidato.ViceCandidato;

public class Prefeito extends CandidatoTitular implements IViceAssociado {
  private VicePrefeito vicePrefeitoAssociado;

  public Prefeito(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
    this.numero = this.validarNumero(numero);
  }

  protected String validarNumero(String numero) {
    if (numero != null && numero.matches("\\d{2}")) {
      return numero;
    } else {
      throw new IllegalArgumentException("Número inválido para Prefeito: deve ter exatamente dois dígitos.");
    }
  }

  public void associarViceCandidato(ViceCandidato vicePrefeito) {
    if (vicePrefeito instanceof VicePrefeito) {
      VicePrefeito candidatoVice = (VicePrefeito) vicePrefeito;
      if (this.vicePrefeitoAssociado != candidatoVice) {
          this.vicePrefeitoAssociado = candidatoVice;
          this.vicePrefeitoAssociado.associarCandidatoTitular(this);
      }
    }
  }

  public void desassociarViceCandidato() {
    if (this.vicePrefeitoAssociado.getCandidatoTitularAssociado() != this) {
      this.vicePrefeitoAssociado.desassociarViceCandidato();
    }
    this.vicePrefeitoAssociado = null;
  }

  // Gets
  public ViceCandidato getViceCandidatoAssociado() {
    return vicePrefeitoAssociado;
  }
}
