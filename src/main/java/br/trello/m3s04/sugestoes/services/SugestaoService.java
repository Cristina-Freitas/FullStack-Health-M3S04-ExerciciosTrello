package br.trello.m3s04.sugestoes.services;

import br.trello.m3s04.sugestoes.dtos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SugestaoService {

    SugestaoResponse create(SugestaoRequest request);

    Page<SugestaoResponse> list(Filter filter, Pageable pageable);

    ComentarioResponse addComentario(Long sugestaoId, ComentarioRequest request);
    SugestaoDetailResponse search(Long id);
}
