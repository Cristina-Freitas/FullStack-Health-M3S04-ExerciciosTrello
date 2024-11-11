package br.trello.m3s04.sugestoes.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(description = "Sugestão de Comentários")
public abstract class ComentarioAbstract {

    @Schema(
            description = "Conteúdo do comentário",
            example = "Atendimento ao cliente"
    )

   @NotEmpty(message = "O comentário não pode ser vazio.")
    private String texto;

}
