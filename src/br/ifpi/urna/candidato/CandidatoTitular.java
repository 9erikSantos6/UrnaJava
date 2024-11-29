package br.ifpi.urna.candidato;
import br.ifpi.urna.partido.Partido;

public abstract class CandidatoTitular extends Candidato {
    private int votos;
    CandidatoTitular(String nome, String numero, Partido partido) {
        super(nome, numero, partido);
    }

    public void adicionarVoto() {
        this.votos++;
    }

    public void zerarVotos() {
        this.votos = 0;
    }

    public int getVotos() {
        return votos;
    }
}
