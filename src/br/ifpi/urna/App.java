package br.ifpi.urna;

import br.ifpi.urna.candidato.Presidente;
import br.ifpi.urna.candidato.VicePresidente;
import br.ifpi.urna.partido.Partido;

public class App {
    public static void main(String[] args) {
      Partido partido = new Partido("NULO", "001");

      Presidente presidente = new Presidente("Jhon", "80", partido);

      VicePresidente vicePresidente = new VicePresidente("Ninguém Sabe", "80", partido);

      vicePresidente.associarCandidatoTitular(presidente);

      System.out.println(vicePresidente.getCandidatoTitularAssociado());
    }
}
