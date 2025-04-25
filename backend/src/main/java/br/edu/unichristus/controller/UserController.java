package br.edu.unichristus.controller;

import br.edu.unichristus.domain.dto.MessageDTO;
import br.edu.unichristus.domain.dto.UserDTO;
import br.edu.unichristus.domain.dto.UserLowDTO;
import br.edu.unichristus.domain.model.User;
import br.edu.unichristus.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public UserLowDTO save(@RequestBody UserDTO user){
        return service.save(user);
    }

    @PutMapping
    public UserLowDTO update(@RequestBody UserDTO user){
        return service.save(user);
    }

    @Operation(summary = "Retorna o usuário do ID digitado | role: [ADMIN]"
            ,tags = "User")
    @GetMapping("/all")
    public List<UserLowDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Retorna o usuário do ID digitado | role: [ADMIN]"
    ,tags = "User")
    @ApiResponses({
       @ApiResponse(responseCode = "200", description = "Lista os dados do usuário"),
       @ApiResponse(responseCode = "404", description = "Usuário não encontrado!",
       content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }




}
