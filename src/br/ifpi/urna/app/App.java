package br.ifpi.urna.app;

import br.ifpi.urna.candidato.titular.Presidente;
import br.ifpi.urna.candidato.vice.VicePresidente;
import br.ifpi.urna.partido.Partido;

public class App {
    public static void main(String[] args) {
      Partido partido = new Partido("NULO", "NL", "80");
      Presidente presidente = new Presidente("Jhon", "80", partido);
      VicePresidente vicePresidente = new VicePresidente("Ninguém Sabe", partido);

      vicePresidente.associarCandidatoTitular(presidente);

      System.out.println(vicePresidente.getCandidatoTitularAssociado());
      vicePresidente.desassociarViceCandidato();
      System.out.println(vicePresidente.getCandidatoTitularAssociado());
    }
}
