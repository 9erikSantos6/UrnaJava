package br.ifpi.urna.candidato;

import br.ifpi.urna.partido.Partido;

public class VicePresidente extends ViceCandidato {
  VicePresidente(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
  }

  protected String validarNumero(String numero) {
    if (numero != null && numero.matches("\\d{2}")) {
      return numero;
    } else {
      throw new IllegalArgumentException("Número inválido para VicePresidente: deve ter exatamente dois dígitos.");
    }
  }
}
