package br.ifpi.eleicao.candidato.titular;

import br.ifpi.eleicao.candidato.vice.VicePrefeito;
import br.ifpi.eleicao.partido.Partido;
import br.ifpi.eleicao.shared.interfaces.candidato.IViceAssociado;
import br.ifpi.eleicao.shared.models.candidato.CandidatoTitular;
import br.ifpi.eleicao.shared.models.candidato.ViceCandidato;
import br.ifpi.eleicao.shared.utils.candidato.Candidato;
import br.ifpi.eleicao.shared.utils.candidato.TipoCandidato;

public class Prefeito extends CandidatoTitular implements IViceAssociado {
  private VicePrefeito vicePrefeitoAssociado;

  public Prefeito(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
    this.numero = this.validarNumero(numero);
  }

  @Override
  protected String validarNumero(String numero) {
    return Candidato.validarNumero(TipoCandidato.PREFEITO, numero);
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

  @Override
  public String toString() {
    return super.toString().concat(String.format("""
      Vice-Prefeito: %s
      """,
      this.vicePrefeitoAssociado.getNome()
      ));
  }

  // Gets
  public ViceCandidato getViceCandidatoAssociado() {
    return vicePrefeitoAssociado;
  }
}
