package br.ifpi.urna.partido;

public class Partido {
    private String nome;
    private String numeroRegistro;
    private int TotalVotos;

    Partido(String nome, String numeroRegistro) {
        this.nome = nome;
        this.numeroRegistro = numeroRegistro;
    }

    void adicionarVotos() {
        this.TotalVotos++;
    }

    void zerarVotos() {
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
