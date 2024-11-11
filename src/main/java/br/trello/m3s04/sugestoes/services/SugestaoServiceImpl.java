package br.trello.m3s04.sugestoes.services;

import br.trello.m3s04.sugestoes.dtos.*;
import br.trello.m3s04.sugestoes.entities.Comentario;
import br.trello.m3s04.sugestoes.entities.Sugestao;
import br.trello.m3s04.sugestoes.repositories.ComentarioRepository;
import br.trello.m3s04.sugestoes.repositories.SugestaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SugestaoServiceImpl implements SugestaoService{

    private final SugestaoRepository sugestaoRepository;
    private final ComentarioRepository comentarioRepository;

    @Override
    public SugestaoResponse create(SugestaoRequest request) {
        log.info("POST /sugestoes -> Serviço chamado.");
        Sugestao sugestao = new Sugestao(request);
                sugestao.setDataEnvio(LocalDateTime.now());
        sugestao.setDataAtualizacao(LocalDateTime.now());
        Sugestao SavedSuggestion = sugestaoRepository.save(sugestao);
        log.info("POST /sugestoes -> Sugestão criada." + sugestao);
        return new SugestaoResponse(SavedSuggestion);
    }

    @Override
    public Page<SugestaoResponse> list(Filter filter, Pageable pageable) {
        log.info("GET /sugestoes -> Serviço chamado.");
        Page<Sugestao> sugestoes = sugestaoRepository.findAll(pageable);
        log.info("GET /sugestoes -> Lista de sugestões recuperada.");
        return sugestoes.map(SugestaoResponse::new);
    }

    @Override
    public ComentarioResponse addComentario(Long sugestaoId, ComentarioRequest request) {
        log.info("POST /sugestoes/{sugestaoId}/comentarios -> Serviço chamado.");
        Sugestao sugestao = sugestaoRepository.findById(sugestaoId)
                .orElseThrow(() -> new RuntimeException("Sugestão não encontrada."));
        Comentario comentario = new Comentario(request);
        comentario.setDataEnvio(LocalDateTime.now());
        comentario.setSugestao(sugestao);
        Comentario savedComment = comentarioRepository.save(comentario);
        log.info("POST /sugestoes/{sugestaoId}/comentarios -> Comentário criado.");
        return new ComentarioResponse(savedComment);

    }

    @Override
    public SugestaoDetailResponse search(Long id) {
        log.info("GET /sugestoes/{} -> Serviço chamado.", id);
        Sugestao sugestao = sugestaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sugestão não encontrada."));

        List<ComentarioResponse> comentarios = comentarioRepository
                .findBySugestaoOrderByDataEnvioDesc(sugestao)
                .stream()
                .map(ComentarioResponse::new)
                .toList();

        SugestaoDetailResponse response = new SugestaoDetailResponse(sugestao);
        response.setComentarios(comentarios);
        log.info("GET /sugestoes/{} -> Sugestão recuperada com comentários ordenados.", id);
        return response;
    }
}
