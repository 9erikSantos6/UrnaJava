package br.ifpi.eleicao.shared.utils.titulo;

import java.util.Random;

public class Titulo {
  private static final Random random = new Random();

  public static String validarLocalizacao(TipoLocalizacaoValidacao localizacao, String numero) {
    if (numero != null && numero.matches(String.format("\\d{%d}", localizacao.getQuantidadeDigitos()))) {
        return numero;
    } else {
        throw new IllegalArgumentException(String.format(
            "Número inválido para %s: deve ter exatamente %d dígitos.", 
            localizacao.getTipoLocalizacao(), 
            localizacao.getQuantidadeDigitos()
        ));
    }
  }

  public static String gerarNumeroInscricao() {
    long numero = Math.abs(random.nextLong() % 1000000000000L);
    String id = String.format("%012d", numero);
    return id;
  }

  public static String validarIscricao(String numero) {
    if (numero != null && numero.matches("\\d{12}")) {
        return numero;
    } else {
        throw new IllegalArgumentException(String.format("Número inválido para inscricao: deve ter exatamente 12 dígitos."));
    }
  }
}
