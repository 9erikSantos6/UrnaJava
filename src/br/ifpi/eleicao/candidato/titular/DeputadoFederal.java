package br.ifpi.eleicao.candidato.titular;

import br.ifpi.eleicao.partido.Partido;
import br.ifpi.eleicao.shared.models.candidato.CandidatoTitular;
import br.ifpi.eleicao.shared.utils.candidato.Candidato;
import br.ifpi.eleicao.shared.utils.candidato.TipoCandidatoValidacao;

public class DeputadoFederal extends CandidatoTitular {
  public DeputadoFederal(String nome, String numero, Partido partido) {
    super(nome, numero, partido);
  }

  @Override
  protected String validarNumero(String numero) {
    return Candidato.validarNumero(TipoCandidatoValidacao.DEPUTADO_FEDERAL, numero);
  }
}
