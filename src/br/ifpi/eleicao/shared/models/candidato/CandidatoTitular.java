package br.ifpi.eleicao.shared.models.candidato;

import br.ifpi.eleicao.partido.Partido;

public abstract class CandidatoTitular extends Candidato {
  protected String numero;
  protected int votos;

  protected CandidatoTitular(String nome, String numero, Partido partido) {
    super(nome, partido);
    this.numero = this.validarNumero(numero);

  }

  protected abstract String validarNumero(String numString);

  public void adicionarVoto() {
    this.votos++;
  }

  public void zerarVotos() {
    this.votos = 0;
  }

  // GETs e SETs

  public int getVotos() {
    return votos;
  }

  public String getNumero() {
      return numero;
  }

  public void setNumero(String numero) {
      this.numero = this.validarNumero(numero);
  }
}
