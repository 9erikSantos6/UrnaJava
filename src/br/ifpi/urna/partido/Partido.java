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
}
