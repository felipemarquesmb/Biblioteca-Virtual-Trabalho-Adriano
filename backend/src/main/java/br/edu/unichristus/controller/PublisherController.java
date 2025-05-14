package br.edu.unichristus.controller;

import br.edu.unichristus.domain.model.Publisher;
import br.edu.unichristus.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import br.edu.unichristus.domain.dto.MessageDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;

import java.util.List;

@RestController // Indica que esta classe é um controller REST
@RequestMapping("/api/v1/publishers")  // Define a URL base

public class PublisherController {

    @Autowired
    private PublisherService service;

    @Operation(summary = "Cria uma nova editora", tags = "Publisher")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Editora criada com sucesso")
    })
    @PostMapping // Cria uma nova editora
    public Publisher save(@RequestBody Publisher publisher) {
        return service.save(publisher);
    }


    @Operation(summary = "Atualiza uma editora existente", tags = "Publisher")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Editora atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Editora não encontrada",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })

    @PutMapping // Atualiza uma editora existente
    public Publisher update(@RequestBody Publisher publisher) {
        return service.save(publisher);
    }


    @Operation(summary = "Lista todas as editoras", tags = "Publisher")
    @ApiResponse(responseCode = "200", description = "Editora listadas com sucesso")

    @GetMapping // Retorna todas as editoras
    public List<Publisher> findAll() {
        return service.findAll();
    }




    @Operation(summary = "Retorna uma editora pelo ID", tags = "Publisher")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Editora encontrada"),
            @ApiResponse(responseCode = "404", description = "Editora não encontrada",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/{id}") // Retorna editora pelo ID
    public Publisher findById(@PathVariable Long id) {
        return service.findById(id);
    }



    @Operation(summary = "Deleta uma editora pelo ID", tags = "Publisher")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Editora deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Editora não encontrada",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })

    @DeleteMapping("/{id}") // Deleta editora pelo ID
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
