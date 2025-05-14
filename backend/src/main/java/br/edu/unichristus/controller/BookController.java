package br.edu.unichristus.controller;

import br.edu.unichristus.domain.model.Book;
import br.edu.unichristus.service.BookService;
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

@Tag(name = "Book")

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService service;

    @Operation(summary = "Cria um novo livro", tags = "Book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Livro criado com sucesso")
    })

    @PostMapping
    public Book save(@RequestBody Book book) {
        return service.save(book);
    }


    @Operation(summary = "Atualiza um livro existente", tags = "Book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })

    @PutMapping
    public Book update(@RequestBody Book book) {
        return service.save(book);
    }


    @Operation(summary = "Lista todos os livros", tags = "Book")
    @ApiResponse(responseCode = "200", description = "Livros listados com sucesso")

    @GetMapping
    public List<Book> findAll() {
        return service.findAll();
    }



    @Operation(summary = "Retorna um livro pelo ID", tags = "Book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Livro encontrado"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return service.findById(id);
    }



    @Operation(summary = "Deleta um livro pelo ID", tags = "Book")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Livro deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
