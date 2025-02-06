package br.ifpi.eleicao.shared.interfaces.candidato;

import br.ifpi.eleicao.shared.models.candidato.ViceCandidato;

public interface IViceAssociado {
  public void associarViceCandidato(ViceCandidato viceCandidato);
  public void desassociarViceCandidato();
}