package br.ifpi.urna.eleitor;

import java.time.LocalDate;

public class Eleitor {
  private final String id;
  private final String nome;
  private final LocalDate dataNascimento;
  private final String nomePai;
  private final String nomeMae;
  private Titulo titulo;

  public Eleitor(String nome, String dataNascimento, String nomePai, String nomeMae) {
    this.id = gerarID();
    this.nome = nome;
    this.dataNascimento = LocalDate.parse(dataNascimento);
    this.nomePai = nomePai;
    this.nomeMae = nomeMae;
  }

  public Eleitor(String id, String nome, String dataNascimento, String nomePai, String nomeMae) {
    this.id = id;
    this.nome = nome;
    this.dataNascimento = this.parseDataNascimento(dataNascimento);
    this.nomePai = nomePai;
    this.nomeMae = nomeMae;
  }

  private String gerarID() {
    return br.ifpi.urna.shared.utils.eleitor.Eleitor.gerarID();
  }

  private LocalDate parseDataNascimento(String dataNascimento) {
    try {
      return LocalDate.parse(dataNascimento);
    } catch (Exception e) {
      throw new IllegalArgumentException("Data de nascimento inválida! Utilize o formato 'yyyy-MM-dd'.");
    }
  }

  public void criarTitulo(String zona, String secao) {
    if (this.titulo == null) {
      this.titulo = new Titulo(zona, secao, this);
    }
  }

  public void renovarTitulo(String zona, String secao) {
    if (this.titulo != null) {
      this.titulo.renovarZonaSecao(zona, secao);
    }
  }

  @Override
  public String toString() {
    return String.format("""
      ID: %s
      Nome: %s
      Data de Nascimento: %s 
      Nome do Pai: %s 
      Nome da Mãe: %s
      Título: %s
      """,
      this.id,
      this.nome, 
      this.dataNascimento, 
      this.nomePai, 
      this.nomeMae,
      this.titulo != null ? this.titulo.getInscricao() : "N/A"
    );
  }

  // GETs e SETs:
  public String getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public String getNomePai() {
    return nomePai;
  }

  public String getNomeMae() {
    return nomeMae;
  }

  public Titulo getTitulo() {
    return titulo;
  }
}
