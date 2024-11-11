package br.trello.m3s04.sugestoes.dtos;

import br.trello.m3s04.sugestoes.entities.Sugestao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@Schema(description = "Sugestão de respostas")
public class SugestaoResponse extends SugestaoAbstract{

    @Schema(
            description = "Identificador da sugestão",
            example = "1"
    )
    private Long id;

    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Schema(description = "Date and time of creation", example = "11/11/2024 11:11")
    private String dataEnvio;

    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Schema(description = "Date and time of creation", example = "11/11/2024 11:11")
    private String dataAtualizacao;

    public SugestaoResponse(Sugestao sugestao) {
        BeanUtils.copyProperties(sugestao, this);

    }
}
