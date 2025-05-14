package br.edu.unichristus.service;

import br.edu.unichristus.domain.model.Book;
import br.edu.unichristus.domain.model.Favorite;
import br.edu.unichristus.domain.model.User;
import br.edu.unichristus.exception.CommonsException;
import br.edu.unichristus.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    public Favorite save(Favorite favorite) {
        return repository.save(favorite);
    }

    public List<Favorite> findAll() {
        return repository.findAll();
    }

    public Favorite findById(Long id) {
        var favoriteEntity = repository.findById(id);
        if (favoriteEntity.isEmpty()) {
            throw new CommonsException(HttpStatus.NOT_FOUND,
                    "unichristus.favorite.findbyid.notfound",
                    "Favorito não encontrado!");
        }
        return favoriteEntity.get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void sendSuggestionByEmail(User user) {
        var topBooks = repository.findMostFavoritedBooks(org.springframework.data.domain.PageRequest.of(0, 1));
        if (topBooks.isEmpty()) return;

        Book book = topBooks.get(0);
        String subject = "📚 Que tal dar uma chance a este livro?";
        String text = String.format("Que tal dar uma chance para \"%s\" (Edição: %s), da editora %s?",
                book.getTitle(), book.getEdition(), book.getPublisher().getName());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }

    public void sendSuggestionsByEmail(String email) {
        List<Book> books = getMostFavoritedBooks();
        if (books.isEmpty()) return;

        StringBuilder messageBody = new StringBuilder("📚 Confira os livros mais populares:\n\n");
        for (Book book : books) {
            messageBody.append("• ").append(book.getTitle())
                    .append(" (Edição: ").append(book.getEdition())
                    .append(") - ").append(book.getPublisher().getName())
                    .append("\n");
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Sugestões de livros favoritos 📖");
        message.setText(messageBody.toString());

        mailSender.send(message);
    }

    public List<Book> getMostFavoritedBooks() {
        return repository.findMostFavoritedBooks(org.springframework.data.domain.PageRequest.of(0, 5));
    }
}
