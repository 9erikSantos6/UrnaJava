package br.ifpi.eleicao.shared.utils.titulo;

public enum TipoLocalizacaoValidacao {
  ZONA("ZONA", 3),
  SECAO("SECAO", 4);

  private final String tipoLocalizacao;
  private final int quantidadeDigitos;

  TipoLocalizacaoValidacao(String tipoLocalizacao, int quantidadeDigitos) {
    this.tipoLocalizacao = tipoLocalizacao;
    this.quantidadeDigitos = quantidadeDigitos;
  }

  public String getTipoLocalizacao() {
    return tipoLocalizacao;
  }

  public int getQuantidadeDigitos() {
    return quantidadeDigitos;
  }
}
