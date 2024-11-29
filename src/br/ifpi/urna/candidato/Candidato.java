package br.ifpi.urna.candidato;
import br.ifpi.urna.partido.*;;

public class Candidato {
    private String nome;
    private String numero;
    private Partido partido;

    Candidato(String nome, String numero, Partido partido) {
        this.nome = nome;
        this.numero = numero;
        this.partido = partido;
    }

    // NAO IMPLEMENTADO!
}
