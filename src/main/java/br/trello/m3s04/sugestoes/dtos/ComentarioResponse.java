package br.trello.m3s04.sugestoes.dtos;

import br.trello.m3s04.sugestoes.entities.Comentario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "Sugestão de Comentários")
public class ComentarioResponse {

    @Schema(description = "Comentario id", example = "1")
    private Long sugestaoId;

    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Schema(description = "Data e hora do envio", example = "11/11/2024 11:11")
    private LocalDateTime dataEnvio;

    public ComentarioResponse(Comentario comentario) {
        BeanUtils.copyProperties(comentario, this);
    }

}
