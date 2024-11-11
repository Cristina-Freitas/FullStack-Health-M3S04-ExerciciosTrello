package br.trello.m3s04.sugestoes.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Sugestão de respostas")
public class SugestaoRequest extends SugestaoAbstract{

}
