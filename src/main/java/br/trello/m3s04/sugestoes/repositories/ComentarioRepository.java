package br.trello.m3s04.sugestoes.repositories;

import br.trello.m3s04.sugestoes.entities.Comentario;
import br.trello.m3s04.sugestoes.entities.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findBySugestaoOrderByDataEnvioDesc(Sugestao sugestao);
}
