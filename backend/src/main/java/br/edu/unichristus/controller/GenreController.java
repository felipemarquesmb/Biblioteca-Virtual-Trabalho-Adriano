package br.edu.unichristus.controller;

import br.edu.unichristus.domain.model.Genre;
import br.edu.unichristus.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import br.edu.unichristus.domain.dto.MessageDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;


import java.util.List;

@Tag(name = "Genre")
@RestController
@RequestMapping("/api/v1/genres")
public class GenreController {

    @Autowired
    private GenreService service;


    @Operation(summary = "Cria um novo gênero", tags = "Genre")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Gênero criado com sucesso")
    })
    @PostMapping
    public Genre save(@RequestBody Genre genre) {
        return service.save(genre);
    }


    @Operation(summary = "Atualiza um gênero existente", tags = "Genre")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Gênero atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Gênero não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })

    @PutMapping
    public Genre update(@RequestBody Genre genre) {
        return service.save(genre);
    }



    @Operation(summary = "Lista todos os gêneros", tags = "Genre")
    @ApiResponse(responseCode = "200", description = "Gêneros listados com sucesso")

    @GetMapping
    public List<Genre> findAll() {
        return service.findAll();
    }



    @Operation(summary = "Retorna um gênero pelo ID", tags = "Genre")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Gênero encontrado"),
            @ApiResponse(responseCode = "404", description = "Gênero não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })

    @GetMapping("/{id}")
    public Genre findById(@PathVariable Long id) {
        return service.findById(id);
    }



    @Operation(summary = "Deleta um gênero pelo ID", tags = "Genre")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Gênero deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Gênero não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
