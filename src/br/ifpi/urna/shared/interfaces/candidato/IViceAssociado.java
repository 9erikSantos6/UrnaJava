package br.ifpi.urna.shared.interfaces.candidato;

import br.ifpi.urna.shared.models.candidato.ViceCandidato;

public interface IViceAssociado {
  public void associarViceCandidato(ViceCandidato viceCandidato);
  public void desassociarViceCandidato();
}