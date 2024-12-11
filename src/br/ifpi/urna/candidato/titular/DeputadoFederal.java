package br.ifpi.urna.candidato.titular;

import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.shared.models.candidato.CandidatoTitular;

public class DeputadoFederal extends CandidatoTitular {
  public DeputadoFederal(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
  }

  @Override
  protected String validarNumero(String numero) {
    if (numero != null && numero.matches("\\d{4}")) {
      return numero;
    } else {
      throw new IllegalArgumentException("Número inválido para Senador: deve ter exatamente cinco dígitos.");
    }
  }
}
