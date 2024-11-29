package br.ifpi.urna.candidato;

import br.ifpi.urna.partido.Partido;

public abstract class ViceCandidato extends Candidato {
    private CandidatoTitular candidatoTitularAssociado;

    ViceCandidato(String nome, String numero, Partido partido) {
        super(nome, numero, partido);
    }


    public void associarCandidatoTitular(CandidatoTitular candidatoTitular) {
        if (candidatoTitular instanceof Prefeito) {
            this.candidatoTitularAssociado = candidatoTitular;

            Prefeito prefeito = (Prefeito) candidatoTitular;
            prefeito.associarViceCandidato(this); 
        }

        // Faltando fazer o mesmo para Governador e Presidente
    }

    public void desassociarViceCandidato() {
        this.candidatoTitularAssociado = null;
    }

    // Gets e Sets

    public CandidatoTitular getCandidatoTitularAssociado() {
        return candidatoTitularAssociado;
    }
}
