package br.ifpi.urna.candidato.titular;

import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.candidato.vice.ViceGovernador;
import br.ifpi.urna.shared.interfaces.candidato.IViceAssociado;
import br.ifpi.urna.shared.models.candidato.CandidatoTitular;
import br.ifpi.urna.shared.models.candidato.ViceCandidato;
import br.ifpi.urna.shared.utils.candidato.Candidato;
import br.ifpi.urna.shared.utils.candidato.TipoCandidatoValidacao;

public class Governador extends CandidatoTitular implements IViceAssociado{
  private ViceGovernador viceGovernadorAssociado;

  public Governador(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
    this.numero = this.validarNumero(numero);
  }

  @Override
  protected String validarNumero(String numero) {
    return Candidato.validarNumero(TipoCandidatoValidacao.GOVERNADOR, numero);
  }

  public void associarViceCandidato(ViceCandidato viceGovernador) {
    if (viceGovernador instanceof ViceGovernador) {
      ViceGovernador candidatoVice = (ViceGovernador) viceGovernador;
      if (this.viceGovernadorAssociado != candidatoVice) {
          this.viceGovernadorAssociado = candidatoVice;
          this.viceGovernadorAssociado.associarCandidatoTitular(this);
      }
    }
  }

  public void desassociarViceCandidato() {
    if (this.viceGovernadorAssociado.getCandidatoTitularAssociado() != this) {
      this.viceGovernadorAssociado.desassociarViceCandidato();
    }
    this.viceGovernadorAssociado = null;
  }

  // Gets
  public ViceCandidato getViceCandidatoAssociado() {
    return viceGovernadorAssociado;
  }
}
