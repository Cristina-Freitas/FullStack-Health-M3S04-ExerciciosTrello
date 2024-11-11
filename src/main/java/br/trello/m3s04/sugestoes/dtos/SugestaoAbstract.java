package br.trello.m3s04.sugestoes.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(description = "Classe para sugestões")
public abstract class SugestaoAbstract {
    @Schema(
            description = "Sugestão de título",
            example = "Atendimento ao cliente"
    )
    @NotEmpty(message = "O título não pode ser vazio.")
    private String titulo;

    @Schema(
            description = "Sugestão de descrição",
            example = "Sugiro que a equipe de atendimento ao cliente faça um treinamento para melhorar o atendimento."
    )
    @NotEmpty(message = "A descrição não pode ser vazia.")
    private String descricao;

}
