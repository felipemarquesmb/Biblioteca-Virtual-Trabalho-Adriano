package br.edu.unichristus.controller;

import br.edu.unichristus.domain.model.Favorite;
import br.edu.unichristus.domain.model.User;
import br.edu.unichristus.service.FavoriteService;
import br.edu.unichristus.service.UserService;
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

@Tag(name = "Favorite")
@RestController
@RequestMapping("/api/v1/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService service;

    @Autowired
    private UserService userService;

    @Operation(summary = "Cria um novo favorito", tags = "Favorite")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Favorito criado com sucesso")
    })
    @PostMapping
    public Favorite save(@RequestBody Favorite favorite) {
        return service.save(favorite);
    }

    @Operation(summary = "Atualiza um favorito existente", tags = "Favorite")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Favorito atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Favorito não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @PutMapping
    public Favorite update(@RequestBody Favorite favorite) {
        return service.save(favorite);
    }

    @Operation(summary = "Lista todos os favoritos", tags = "Favorite")
    @ApiResponse(responseCode = "200", description = "Favoritos listados com sucesso")
    @GetMapping
    public List<Favorite> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Retorna um favorito pelo ID", tags = "Favorite")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Favorito encontrado"),
            @ApiResponse(responseCode = "404", description = "Favorito não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/{id}")
    public Favorite findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Deleta um favorito pelo ID", tags = "Favorite")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Favorito deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Favorito não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @Operation(summary = "Envia sugestão de livro por id", tags = "Favorite")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sugestão enviada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @PostMapping("/suggest/{userId}")
    public void sendSuggestion(@PathVariable Long userId) {
        User user = userService.findById(userId);
        service.sendSuggestionByEmail(user);
    }

    @Operation(summary = "Envia sugestões de livros por e-mail", tags = "Favorite")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sugestões enviadas com sucesso"),
            @ApiResponse(responseCode = "400", description = "E-mail inválido ou falha no envio",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @PostMapping("/send-suggestions")
    public void sendSuggestions(@RequestParam String email) {
        service.sendSuggestionsByEmail(email);
    }
}
