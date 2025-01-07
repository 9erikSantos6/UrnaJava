// Ainda não implementado
package br.ifpi.urna.eleitor;

import java.time.LocalDate;

public class Eleitor {
  private String nome;
  private LocalDate dataNascimento;
  private String nomePai;
  private String nomeMae;
  private Titulo titulo = null;

  public Eleitor(String nome, String dataNascimento, String nomePai, String nomeMae) {
    try {
      this.nome = nome;
      this.dataNascimento = LocalDate.parse(dataNascimento);
      this.nomePai = nomePai;
      this.nomeMae = nomeMae;
    } catch (Exception error) {
      System.out.println(error.getMessage());
    }
  }

  public void criarTitulo(String zona, String secao) {
    if (this.titulo == null) {
      this.titulo = new Titulo(zona, secao, this);
    }
  }

  public void renovarTitulo(String zona,  String secao) {
    if (this.titulo != null) {
      this.titulo.renovarZonaSecao(zona, secao);
    }
  }

  public String toString() {
    return String.format("""
      \nNome: %s
      Data de Nascimento: %s 
      Nome do Pai: %s 
      Nome da mãe: %s
      """, 
      this.nome, 
      this.dataNascimento, 
      this.nomePai, 
      this.nomeMae);
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
}
