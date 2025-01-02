// Ainda não implementado

package br.ifpi.urna.eleitor;

import java.time.LocalDate;

class Titulo {
  private String inscricao;
  private LocalDate dataEmissao;
  private String zona;
  private String secao;
  private Eleitor eleitor;

  protected Titulo(String zona, String secao) {
    this.zona = validarZona(zona);
    this.secao = validarSecao(secao);
    this.dataEmissao = LocalDate.now();
  }

  public static String validarZona(String zona) {
    if (zona != null && zona.matches("\\d{3}")) {
      return zona;
    } else {
      throw new IllegalArgumentException(String.format("Número inválido para zona: deve ter exatamente 3 dígitos."));
    }
  }

  public static String validarSecao(String secao) {
    if (secao != null && secao.matches("\\d{4}")) {
      return secao;
    } else {
      throw new IllegalArgumentException(String.format("Número inválido para secao: deve ter exatamente 4 dígitos."));
    }
  }

  // GETs e SETs:
  public String getInscricao() {
    return inscricao;
  }

  public void setInscricao(String inscricao) {
    this.inscricao = inscricao;
  }

  public LocalDate getDataEmissao() {
    return dataEmissao;
  }

  public void setDataEmissao(LocalDate dataEmissao) {
    this.dataEmissao = dataEmissao;
  }

  public String getZona() {
    return zona;
  }

  public void setZona(String zona) {
    this.zona = zona;
  }

  public String getSecao() {
    return secao;
  }

  public void setSecao(String secao) {
    this.secao = secao;
  }

  public Eleitor getEleitor() {
      return eleitor;
  }

  public void setEleitor(Eleitor eleitor) {
      this.eleitor = eleitor;
  }
}
