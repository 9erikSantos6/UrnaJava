package br.ifpi.urna.app;

import br.ifpi.urna.candidato.titular.Presidente;
import br.ifpi.urna.candidato.vice.VicePresidente;

import br.ifpi.urna.eleitor.Titulo;
import br.ifpi.urna.partido.Partido;

import br.ifpi.urna.eleitor.Eleitor;

public class App {
    public static void main(String[] args) {
      // Partido partido = new Partido("NULO", "NL", "80");
      // Presidente presidente = new Presidente("Jhon", "80", partido);
      // VicePresidente vicePresidente = new VicePresidente("Ninguém Sabe", partido);

      // vicePresidente.associarCandidatoTitular(presidente);

      // System.out.println(vicePresidente.getCandidatoTitularAssociado());
      // vicePresidente.desassociarViceCandidato();
      // System.out.println(vicePresidente.getCandidatoTitularAssociado());

      // Test Eleitor
      Eleitor eleitor = new Eleitor("JHON DOE", "2000-03-25", "RICK DOE", "NOTHING DOE");
    
      eleitor.criarTitulo("009", "8675");



      System.out.println(eleitor.toString());
    }
}
