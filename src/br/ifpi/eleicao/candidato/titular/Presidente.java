package br.ifpi.eleicao.candidato.titular;

import br.ifpi.eleicao.candidato.vice.VicePresidente;
import br.ifpi.eleicao.partido.Partido;
import br.ifpi.eleicao.shared.interfaces.candidato.IViceAssociado;
import br.ifpi.eleicao.shared.models.candidato.CandidatoTitular;
import br.ifpi.eleicao.shared.models.candidato.ViceCandidato;
import br.ifpi.eleicao.shared.utils.candidato.Candidato;
import br.ifpi.eleicao.shared.utils.candidato.TipoCandidato;

public class Presidente extends CandidatoTitular implements IViceAssociado {
  private VicePresidente vicePresidenteAssociado;

  public Presidente(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
    this.numero = validarNumero(numero);
  }

  @Override
  protected String validarNumero(String numero) {
    return Candidato.validarNumero(TipoCandidato.PRESIDENTE, numero);
  }

  public void associarViceCandidato(ViceCandidato vicePresidente) {
    if (vicePresidente instanceof VicePresidente) {
      VicePresidente candidatoVice = (VicePresidente) vicePresidente;
      if (this.vicePresidenteAssociado != candidatoVice) {
        this.vicePresidenteAssociado = candidatoVice;
        this.vicePresidenteAssociado.associarCandidatoTitular(this);
      }
    } else {
      throw new IllegalArgumentException("Candidato inválido para associarViceCandidato: deve ser do tipo VicePresidente");
    }
  }

  public void desassociarViceCandidato() {
    if (this.vicePresidenteAssociado.getCandidatoTitularAssociado() != this) {
      this.vicePresidenteAssociado.desassociarViceCandidato();
    }
    this.vicePresidenteAssociado = null;
  }

  @Override
  public String toString() {
    return super.toString().concat(String.format("""
      Vice-Presidente: %s
      """,
      this.vicePresidenteAssociado.getNome()
      ));
  }

  // Gets
  public VicePresidente getViceCandidatoAssociado() {
    return this.vicePresidenteAssociado;
  }
}
