package br.ifpi.urna.partido;

public class Partido {
    private String nome;
    private String sigla;
    private String numeroLegenda;
    private int TotalVotos;

    public Partido(String nome, String sigla, String numeroLegenda) {
        this.nome = nome;
        this.sigla = sigla.toUpperCase();
        this.numeroLegenda = this.validarLegenda(numeroLegenda);
    }

    private String validarLegenda(String numeroLegenda) {
      if (numeroLegenda != null && numeroLegenda.matches("\\d{2}")) {
        int intLegenda = Integer.parseInt(numeroLegenda);
        if (10 <= intLegenda && intLegenda <= 90) {
          return numeroLegenda;
        } else {
          throw new IllegalArgumentException("Número innválido para Partido.numeroLegenda: deve estar entre 10 a 90");
        }
      } else {
        throw new IllegalArgumentException("Número inválido para Partido.numeroLegenda: deve ter exatamente dois dígitos.");
      }
    }

    public void adicionarVoto() {
        this.TotalVotos++;
    }

    public void zerarVotos() {
        this.TotalVotos = 0;
    }

   
    // Gets e Sets:

    public String getNome() {
      return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNumeroLegenda() {
        return numeroLegenda;
    }

    public void setNumeroLegenda(String numeroLegenda) {
        this.numeroLegenda = numeroLegenda;
    }

    public int getTotalVotos() {
        return TotalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        TotalVotos = totalVotos;
    }
}
