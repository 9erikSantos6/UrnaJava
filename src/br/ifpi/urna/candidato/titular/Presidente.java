package br.ifpi.urna.candidato.titular;

import br.ifpi.urna.candidato.vice.VicePresidente;
import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.shared.interfaces.candidato.IViceAssociado;
import br.ifpi.urna.shared.models.candidato.CandidatoTitular;
import br.ifpi.urna.shared.models.candidato.ViceCandidato;
import br.ifpi.urna.shared.utils.candidato.Candidato;
import br.ifpi.urna.shared.utils.candidato.TipoCandidatoValidacao;

public class Presidente extends CandidatoTitular implements IViceAssociado {
  private VicePresidente vicePresidenteAssociado;

  public Presidente(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
    this.numero = validarNumero(numero);
  }

  @Override
  protected String validarNumero(String numero) {
    return Candidato.validarNumero(TipoCandidatoValidacao.PRESIDENTE, numero);
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

  // Gets
  public VicePresidente getViceCandidatoAssociado() {
    return this.vicePresidenteAssociado;
  }
}
