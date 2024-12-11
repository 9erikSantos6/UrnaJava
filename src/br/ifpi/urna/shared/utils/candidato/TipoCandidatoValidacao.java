package br.ifpi.urna.shared.utils.candidato;

public enum TipoCandidatoValidacao {
    PRESIDENTE("Presidente", 2),
    PREFEITO("Prefeito",  2),
    GOVERNADOR("Governador", 2),
    VEREADOR("Vereador", 5),
    DEPUTADO_FEDERAL("Deputado Federal", 4),
    DEPUTADO_ESTADUAL("Deputado Estadual", 5),
    SENADOR("Senador", 3);

    private final String nome;
    private final int quantidadeDigitos;

    TipoCandidatoValidacao(String nome, int quantidadeDigitos) {
        this.nome = nome;
        this.quantidadeDigitos = quantidadeDigitos;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeDigitos() {
        return quantidadeDigitos;
    }
}
