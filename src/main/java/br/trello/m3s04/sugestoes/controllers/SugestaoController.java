package br.trello.m3s04.sugestoes.controllers;

import br.trello.m3s04.sugestoes.dtos.SugestaoRequest;
import br.trello.m3s04.sugestoes.dtos.SugestaoResponse;
import br.trello.m3s04.sugestoes.services.SugestaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("sugestoes")
@Tag(name = "sugestoes", description = "Create/Read/Update/Delete")
public class SugestaoController {

    private final SugestaoService sugestaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Create a sugestao", summary = "Create sugestao")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Success!")})
    public SugestaoResponse create(@Valid @RequestBody SugestaoRequest request) {
        log.info("POST /sugestoes -> Begin");
        SugestaoResponse response = sugestaoService.create(request);
        log.info("POST /sugestoes -> End");
        return response;
    }
}
