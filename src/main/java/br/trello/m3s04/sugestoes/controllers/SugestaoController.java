package br.trello.m3s04.sugestoes.controllers;

import br.trello.m3s04.sugestoes.dtos.Filter;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Find all sugestoes", summary = "Find all sugestoes")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Success!")})
    public Page<SugestaoResponse> list(@RequestParam(required = false) String titulo, Pageable pageable) {
        log.info("GET /sugestoes -> Begin");
        Filter filter = new Filter();
        filter.setTitulo(titulo);

        Page<SugestaoResponse> response = sugestaoService.list(filter, pageable);
        log.info("GET /sugestoes -> End");
        return response;
    }
}

