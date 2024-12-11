package br.ifpi.urna.candidato.titular;

import br.ifpi.urna.partido.Partido;
import br.ifpi.urna.shared.models.candidato.CandidatoTitular;
import br.ifpi.urna.shared.utils.candidato.Candidato;
import br.ifpi.urna.shared.utils.candidato.TipoCandidatoValidacao;

public class Senador extends CandidatoTitular {
  public Senador(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
  }

  @Override
  protected String validarNumero(String numero) {
    return Candidato.validarNumero(TipoCandidatoValidacao.SENADOR, numero);
  }
}
