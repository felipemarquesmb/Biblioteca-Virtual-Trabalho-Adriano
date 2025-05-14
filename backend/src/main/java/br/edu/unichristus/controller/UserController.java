package br.edu.unichristus.controller;

import br.edu.unichristus.domain.model.User;
import br.edu.unichristus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import br.edu.unichristus.domain.dto.MessageDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @Operation(summary = "Cria um novo usuário", tags = "User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso")
    })
    @PostMapping
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    @Operation(summary = "Atualiza um usuário existente", tags = "User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @PutMapping
    public User update(@RequestBody User user) {
        return service.save(user);
    }

    @Operation(summary = "Lista todos os usuários", tags = "User")
    @ApiResponse(responseCode = "200", description = "Usuários listados com sucesso")

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Retorna um usuário pelo ID", tags = "User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Deleta um usuário pelo ID", tags = "User")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
