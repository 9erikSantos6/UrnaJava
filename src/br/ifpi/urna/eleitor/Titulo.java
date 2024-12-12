// Ainda não implementado

package br.ifpi.urna.eleitor;

import java.time.LocalDate;

public class Titulo {
  private String inscricao;
  private LocalDate dataEmissao;
  private String zona;
  private String secao;
  private Eleitor eleitor;

  public Titulo(Eleitor eleitor) {
    this.eleitor = eleitor;
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
