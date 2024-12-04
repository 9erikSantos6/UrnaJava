package br.ifpi.urna.app;

import br.ifpi.urna.candidato.titular.Presidente;
import br.ifpi.urna.candidato.vice.VicePresidente;
import br.ifpi.urna.partido.Partido;

public class App {
    public static void main(String[] args) {
      Partido partido = new Partido("NULO", "001");

      Presidente presidente = new Presidente("Jhon", "80", partido);

      VicePresidente vicePresidente = new VicePresidente("Ninguém Sabe", "80", partido);

      vicePresidente.associarCandidatoTitular(presidente);

      System.out.println();
      System.out.println(vicePresidente.getCandidatoTitularAssociado());
      vicePresidente.desassociarViceCandidato();
      System.out.println(vicePresidente.getCandidatoTitularAssociado());
    }
}
