package br.ifpi.urna.app;

import br.ifpi.urna.candidato.titular.Presidente;
import br.ifpi.urna.candidato.vice.VicePresidente;

import br.ifpi.urna.eleitor.Titulo;
import br.ifpi.urna.partido.Partido;

import br.ifpi.urna.eleitor.Eleitor;
import br.ifpi.urna.db.eleitor.EleitorDAO;
import br.ifpi.urna.db.eleitor.TituloDAO;

public class App {
    public static void main(String[] args) {
      // Partido partido = new Partido("NULO", "NL", "80");
      // Presidente presidente = new Presidente("Jhon", "80", partido);
      // VicePresidente vicePresidente = new VicePresidente("Ninguém Sabe", partido);

      // vicePresidente.associarCandidatoTitular(presidente);

      // System.out.println(vicePresidente.getCandidatoTitularAssociado());
      // vicePresidente.desassociarViceCandidato();
      // System.out.println(vicePresidente.getCandidatoTitularAssociado());

      /* Testando EleitorDAO e TituloDAO*/

      // Criando eleitor
      Eleitor eleitor = new Eleitor("JHON DOE", "2000-03-25", "RICK DOE", "NOTHING DOE");
      eleitor.criarTitulo("009", "8675");

      // Salvando eleitor e título:
      TituloDAO.armazenarTitulo(eleitor.getTitulo());
      EleitorDAO.armazenarEleitor(eleitor);

      // System.out.println(TituloDAO.listarTitulos());
      System.out.println(TituloDAO.procurarPorInscricao(eleitor.getTitulo().getInscricao()));

      // System.out.println(EleitorDAO.listarEleitores());
      System.out.println(EleitorDAO.procurarPorID(eleitor.getId()));

      // System.out.println(eleitor.toString());
    }
}
