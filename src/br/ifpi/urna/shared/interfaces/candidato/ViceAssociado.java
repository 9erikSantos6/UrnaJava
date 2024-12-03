package br.ifpi.urna.shared.interfaces.candidato;

import br.ifpi.urna.shared.models.candidato.ViceCandidato;

public interface ViceAssociado {
  public void associarViceCandidato(ViceCandidato viceCandidato);
  public void desassociarViceCandidato();
}