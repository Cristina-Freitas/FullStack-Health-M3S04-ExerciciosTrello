package br.trello.m3s04.sugestoes.entities;

import br.trello.m3s04.sugestoes.dtos.SugestaoRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sugestoes")
public class Sugestao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String titulo;

    private String descricao;

    private LocalDateTime dataEnvio;

    private LocalDateTime dataAtualizacao;

    public Sugestao(SugestaoRequest request) {
        BeanUtils.copyProperties(request, this);
    }


}
