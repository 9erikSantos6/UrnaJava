package br.ifpi.eleicao.shared.utils.candidato;

public class Candidato {
  public static String validarNumero(TipoCandidatoValidacao tipoCandidato, String numero) {
      if (numero != null && numero.matches(String.format("\\d{%d}", tipoCandidato.getQuantidadeDigitos()))) {
          return numero;
      } else {
          throw new IllegalArgumentException(String.format(
            "Número inválido para %s: deve ter exatamente %d dígitos.", 
            tipoCandidato.getNome(), 
            tipoCandidato.getQuantidadeDigitos()
          ));
      }
  }
}
