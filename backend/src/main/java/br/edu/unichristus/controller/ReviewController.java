package br.edu.unichristus.controller;

import br.edu.unichristus.domain.dto.MessageDTO;
import br.edu.unichristus.domain.model.Review;
import br.edu.unichristus.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta classe é um controller REST
@RequestMapping("/api/v1/reviews")

public class ReviewController {

    @Autowired
    private ReviewService service;

    @Operation(summary = "Cria uma nova avaliação", tags = "Review")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Avaliação criada com sucesso")
    })
    @PostMapping  // Cria uma nova avaliação
    public Review save(@RequestBody Review review) {
        return service.save(review);
    }




    @Operation(summary = "Atualiza uma avaliação existente", tags = "Review")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Avaliação atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Avaliação não encontrada",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @PutMapping  // Atualiza uma avaliação existente
    public Review update(@RequestBody Review review) {
        return service.save(review);
    }




    @Operation(summary = "Lista todas as avaliações", tags = "Review")
    @ApiResponse(responseCode = "200", description = "Avaliações listadas com sucesso")

    @GetMapping  // Retorna todas as avaliações
    public List<Review> findAll() {
        return service.findAll();
    }



    @Operation(summary = "Retorna uma avaliação pelo ID", tags = "Review")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Avaliação encontrada"),
            @ApiResponse(responseCode = "404", description = "Avaliação não encontrada",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/{id}")  // Retorna avaliação pelo ID
    public Review findById(@PathVariable Long id) {
        return service.findById(id);
    }



    @Operation(summary = "Deleta uma avaliação pelo ID", tags = "Review")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Avaliação deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Avaliação não encontrada",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @DeleteMapping("/{id}")  // Deleta avaliação pelo ID
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
