package br.ifpi.eleicao.shared.utils.eleitor;

import java.util.UUID;

public class Eleitor {
  public static String gerarID() {
    return UUID.randomUUID().toString();
  }
}
