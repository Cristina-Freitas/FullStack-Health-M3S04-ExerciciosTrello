package br.trello.m3s04.sugestoes.entities;

import br.trello.m3s04.sugestoes.dtos.ComentarioRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "comentarios")
public class Comentario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Sugestao sugestao;

    @Column(nullable = false, length = 1024)
    private String texto;

    private LocalDateTime dataEnvio;

    public Comentario(ComentarioRequest request) {
    }
}
