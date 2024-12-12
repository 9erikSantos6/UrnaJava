// Ainda não implementado
package br.ifpi.urna.eleitor;

import java.time.LocalDate;

public class Eleitor {
  private String nome;
  private LocalDate dataNascimento;
  private String nomePai;
  private String nomeMae;
  private Titulo titulo = null;

  public Eleitor(String nome, LocalDate dataNascimento, String nomePai, String nomeMae) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.nomePai = nomePai;
    this.nomeMae = nomeMae;
  }

  public void criarTitulo() {
    if (this.titulo == null) {
        this.titulo = new Titulo(this);
    }
  }

  // GETs e SETs:
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getNomePai() {
    return nomePai;
  }

  public void setNomePai(String nomePai) {
    this.nomePai = nomePai;
  }

  public String getNomeMae() {
    return nomeMae;
  }

  public void setNomeMae(String nomeMae) {
    this.nomeMae = nomeMae;
  }

  public Titulo getTitulo() {
    return titulo;
  }

  public void setTitulo(Titulo titulo) {
    this.titulo = titulo;
  }
}
