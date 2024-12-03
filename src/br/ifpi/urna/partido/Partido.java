package br.ifpi.urna.partido;

public class Partido {
    private String nome;
    private String numeroRegistro;
    private int TotalVotos;

    public Partido(String nome, String numeroRegistro) {
        this.nome = nome;
        this.numeroRegistro = numeroRegistro;
    }

    public void adicionarVotos() {
        this.TotalVotos++;
    }

    public void zerarVotos() {
        this.TotalVotos = 0;
    }

    public String getNome() {
        return nome;
    }

    // Gets e Sets:

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public int getTotalVotos() {
        return TotalVotos;
    }

    public void setTotalVotos(int totalVotos) {
        TotalVotos = totalVotos;
    }
}
