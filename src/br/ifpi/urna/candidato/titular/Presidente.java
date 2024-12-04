package br.ifpi.urna.candidato.titular;

import br.ifpi.urna.candidato.vice.VicePresidente;
import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.shared.interfaces.candidato.IViceAssociado;
import br.ifpi.urna.shared.models.candidato.CandidatoTitular;
import br.ifpi.urna.shared.models.candidato.ViceCandidato;

public class Presidente extends CandidatoTitular implements IViceAssociado {
  private VicePresidente vicePresidenteAssociado;

  public Presidente(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
    this.numero = validarNumero(numero);
  }

  protected String validarNumero(String numero) {
    if (numero != null && numero.matches("\\d{2}")) {
      return numero;
    } else {
      throw new IllegalArgumentException("Número inválido para Presidente: deve ter exatamente dois dígitos.");
    }
  }

  public void associarViceCandidato(ViceCandidato vicePresidente) {
    if (vicePresidente instanceof VicePresidente) {
      VicePresidente viceAssociado = (VicePresidente) vicePresidente;
      if (this.vicePresidenteAssociado != viceAssociado) {
        this.vicePresidenteAssociado = viceAssociado;
        vicePresidente.associarCandidatoTitular(this);
      }
    } else {
      throw new IllegalArgumentException("Candidato inválido para associarViceCandidato: deve ser do tipo VicePresidente");
    }
  }

  public void desassociarViceCandidato() {
    this.vicePresidenteAssociado.desassociarViceCandidato();
    this.vicePresidenteAssociado = null;
  }

  // Gets
  public VicePresidente getViceCandidatoAssociado() {
    return this.vicePresidenteAssociado;
  }
}
