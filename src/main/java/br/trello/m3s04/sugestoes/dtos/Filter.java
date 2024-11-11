package br.trello.m3s04.sugestoes.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Parametros de filtro")
public class Filter {

    @Schema(description = "Filtro por título", example = "Atendimento ao cliente")
    private String titulo;

}
