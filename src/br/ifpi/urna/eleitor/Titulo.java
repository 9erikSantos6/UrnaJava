// Ainda não implementado

package br.ifpi.urna.eleitor;

import java.time.LocalDate;
import java.util.Objects;

import br.ifpi.urna.shared.utils.titulo.TipoLocalizacaoValidacao;

public class Titulo {
  private String inscricao;
  private String zona;
  private String secao;
  private LocalDate dataEmissao;
  private Eleitor eleitor;

  Titulo(String zona, String secao, Eleitor eleitor) {
    this.inscricao = this.gerarNumeroInscricao();
    this.zona = this.validarLocalizacao(TipoLocalizacaoValidacao.ZONA, zona);
    this.secao = this.validarLocalizacao(TipoLocalizacaoValidacao.SECAO, secao);
    this.dataEmissao = LocalDate.now();
    this.eleitor = eleitor;
  }

  private String validarLocalizacao(TipoLocalizacaoValidacao tipoLocalizacao, String numero) {
    return br.ifpi.urna.shared.utils.titulo.Titulo.validarLocalizacao(tipoLocalizacao, numero);
  }

  private String gerarNumeroInscricao() {
    return br.ifpi.urna.shared.utils.titulo.Titulo.gerarNumeroInscricao();
  }

  public void renovarZonaSecao(String zona, String secao) {
    this.zona = this.validarLocalizacao(TipoLocalizacaoValidacao.ZONA, zona);
    this.secao = this.validarLocalizacao(TipoLocalizacaoValidacao.SECAO, secao);
  }

  public String toString() {
    return String.format("""
      \nInscrição: %s
      Zona: %s
      Seção: %s
      Data de emissão: %s
      """, 
      this.inscricao,
      this.zona,
      this.secao,
      this.dataEmissao.toString()
    );
  }

  // Utilizado em HashSets
  @Override 
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Titulo)) return false;
    Titulo outroTitulo = (Titulo) obj;
    return this.inscricao.equals(outroTitulo.getInscricao());
  }

  @Override 
  public int hashCode() {
    return Objects.hash(this.inscricao, this.eleitor.getNome());
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
