package br.trello.m3s04.sugestoes.repositories;

import br.trello.m3s04.sugestoes.entities.Sugestao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SugestaoRepository extends JpaRepository<Sugestao, Long> {

    Page<Sugestao> findAllByTituloContainingIgnoreCaseOrderByDataAtualizacao(String titulo, Pageable pageable);

    Page<Sugestao> findAllByOrderByDataAtualizacao(Pageable pageable);
}
