package br.trello.m3s04.sugestoes.dtos;

import br.trello.m3s04.sugestoes.entities.Sugestao;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "Sugetão detalhada")
public class SugestaoDetailResponse extends SugestaoResponse{

    @Schema(description = "Lista de comentários",
            example = "[{\"text\": \"Ótimo comentário.\"," +
                    " \"sugestaoId\": 1, \"dataEnvio\": \"11/11/2024 13:41\"}," +
                    "{\"text\": \"Concordo!\", \"sugestaoId\": 1," +
                    "\"dataEnvio\": \"11/11/2024 13:41\"}]")
    List<ComentarioResponse> comentarios;

    public SugestaoDetailResponse(Sugestao sugestao) {
        BeanUtils.copyProperties(sugestao, this);
    }
}
