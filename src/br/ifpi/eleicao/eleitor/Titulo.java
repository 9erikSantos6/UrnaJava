// Ainda não implementado

package br.ifpi.eleicao.eleitor;

import java.time.LocalDate;
import java.util.Objects;

import br.ifpi.eleicao.shared.utils.eleicao.TipoLocalizacao;

public class Titulo {
  private final String inscricao;
  private String zona;
  private String secao;
  private final LocalDate dataEmissao;
  private final Eleitor eleitor;

  Titulo(String zona, String secao, Eleitor eleitor) {
    this.inscricao = this.gerarNumeroInscricao();
    this.zona = this.validarLocalizacao(TipoLocalizacao.ZONA, zona);
    this.secao = this.validarLocalizacao(TipoLocalizacao.SECAO, secao);
    this.dataEmissao = LocalDate.now();
    this.eleitor = eleitor;
  }

  private String validarLocalizacao(TipoLocalizacao tipoLocalizacao, String numero) {
    return br.ifpi.eleicao.shared.utils.eleicao.CadastroEleicao.validarLocalizacao(tipoLocalizacao, numero);
  }

  private String gerarNumeroInscricao() {
    return br.ifpi.eleicao.shared.utils.eleicao.CadastroEleicao.gerarNumeroInscricaoTitulo();
  }

  public void renovarZonaSecao(String zona, String secao) {
    this.zona = this.validarLocalizacao(TipoLocalizacao.ZONA, zona);
    this.secao = this.validarLocalizacao(TipoLocalizacao.SECAO, secao);
  }

  @Override
  public String toString() {
    return String.format("""
      Inscrição: %s
      Zona: %s
      Seção: %s
      Data de emissão: %s
      Eleitor: %s
      """, 
      this.inscricao,
      this.zona,
      this.secao,
      this.dataEmissao.toString(),
      this.eleitor != null ? this.eleitor.getId() : "N/A"
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
    return Objects.hash(this.inscricao);
  }

  // GETs e SETs:
  public String getInscricao() {
    return inscricao;
  }

  public LocalDate getDataEmissao() {
    return dataEmissao;
  }

  public String getZona() {
    return zona;
  }

  public void setZona(String zona) {
    this.zona = this.validarLocalizacao(TipoLocalizacao.ZONA, zona);
  }

  public String getSecao() {
    return secao;
  }

  public void setSecao(String secao) {
    this.secao = this.validarLocalizacao(TipoLocalizacao.SECAO, secao);
  }

  public Eleitor getEleitor() {
      return eleitor;
  }
}
